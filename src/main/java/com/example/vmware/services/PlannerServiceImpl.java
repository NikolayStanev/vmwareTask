package com.example.vmware.services;

import com.example.vmware.communicators.ExchangeRateCommunicator;
import com.example.vmware.communicators.GeoNamesCommunicator;
import com.example.vmware.exceptions.AppException;
import com.example.vmware.rest.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: nikolay.stanev
 * Date: 26.3.2022 г.
 * Time: 17:15
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PlannerServiceImpl implements PlannerService{

    private static final Logger logger = LoggerFactory.getLogger(PlannerServiceImpl.class);

    @Autowired
    GeoNamesCommunicator communicatorGeo;

    @Autowired
    ExchangeRateCommunicator exchangeRateCommunicator;


    /**
     * Main point of this business logic. Taking the request and doing the whole planning.
     * Doing the math
     * Building the response.
     * @param request resource request.
     * @return The response.
     * @throws AppException When connection  errors occur.
     */
    @Override
    public Response planTour(Request request) throws AppException {
        logger.info("Planning tour...");
        logger.debug("for request: " + request);

        String countryFull = request.getCountry().trim();

        Pattern pattern = Pattern.compile("[A-Z]{2}");
        Matcher matcher = pattern.matcher(countryFull);
        String countryISO;

        //checking for countryCode in the request
        if(matcher.find()) {
            countryISO = matcher.group();
            //String countryCode = countryFull.substring(countryFull.indexOf("(") + 1,countryFull.indexOf(")"));
        }else {
            //if there is no ISO format of the country in the request we need to call getCountryInfo
            ToponymSearchResult result = communicatorGeo.getCountryInfo();
            countryISO = findCountryISO(result, countryFull);
        }
        logger.info("Country ISO code: " + countryISO);

        //getting the neighbours
        ToponymSearchResult neighbors = communicatorGeo.getNeighbours(countryISO);

        BigDecimal total = request.getTotalBudget();
        BigDecimal countries = new BigDecimal(neighbors.getTotalResultsCount());
        BigDecimal budget = request.getBudget();

        BigDecimal[] countLeftovers = total.divideAndRemainder(budget.multiply(countries),new MathContext(99,RoundingMode.DOWN));

        Map<String,String> moneyRequiredPerCountry = buildMoneyMap(neighbors, request.getCurrency(), request.getBudget().toString());

        Response response = new Response(countLeftovers[0],countLeftovers[1],moneyRequiredPerCountry);

        return response;
    }


    /**
     * Finding the countryCode from all the countries in GeoName webService.
     * @param result Result from GeoName WebService getCountryInfo call. {@link GeoNamesCommunicator}
     * @param country The name of the country
     * @return String presentation of CountryCode. or null if there is not such country in the result set.
     */
    private String findCountryISO(ToponymSearchResult result, String country){
        logger.info("findCountryISO()");
        for(Toponym toponym : result.getGeonames()) {

            if(toponym.getCountryName().equals(country)){
                return toponym.getCountryCode();
            }
        }
        return null;
    }

    /**
     * Build money map which tell how much money need to be bought for the different neighbours.
     * @param toponymResult result from the GeoNames webService call for neighbours.
     * @param fromCurrency the base currency from the request.
     * @param amount the amount needed per neighbour country for the tour.
     * @return Map of the money that need to be bought.
     * @throws AppException when there is a connection problem with the webServices.
     */
    private Map<String,String> buildMoneyMap(ToponymSearchResult toponymResult, String fromCurrency, String amount) throws AppException {
        logger.info("buildMoneyMap()");

        List<Toponym> list = toponymResult.getGeonames();
        StringBuilder sb = new StringBuilder();
        Map<String,String> moneyMap = new HashMap<>();
        Map<String,String> currencyMap = new HashMap<>();

        // toponymResult's toponym list does not contain Currency code...
        // so we have to call geoNames webService again to obtain it.
        for (Toponym toponym : list) {
            ToponymSearchResult result = communicatorGeo.getCountryInfo(toponym.getCountryCode());
            Toponym countryInfo = result.getGeonames().get(0);

            //not adding the currency if it is the same as default currency
            sb.append(countryInfo.getCurrencyCode());
            sb.append(",");
            currencyMap.put(toponym.getCountryName(),countryInfo.getCurrencyCode());

        }

        String currenciesNeeded = sb.deleteCharAt(sb.length() -1 ).toString();

        //calling exchange rate webService
        //trying to optimise the calling amount for this webService since the free version
        //has only 250 calls a month.
        ExchangeRate exchangeRate = exchangeRateCommunicator.getExchangeRate(fromCurrency, currenciesNeeded);

        //and we have to loop them again because we need the country name
        for(Map.Entry<String,String> entry: currencyMap.entrySet()) {

            double tempExchangedAmount = exchangeRate.getRates().get(entry.getValue()) * Double.parseDouble(amount);
            String tempAmountCurrency = new BigDecimal(tempExchangedAmount).setScale(2, RoundingMode.CEILING) +" " + entry.getValue();

            moneyMap.put(entry.getKey(),tempAmountCurrency);

        }
        return  moneyMap;
    }
}
