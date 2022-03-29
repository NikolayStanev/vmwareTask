package com.example.vmware.communicators;

import com.example.vmware.exceptions.AppException;
import com.example.vmware.rest.ExchangeRate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

/**
 * Created with IntelliJ IDEA.
 * User: nikolay.stanev
 * Date: 26.3.2022 г.
 * Time: 18:43
 * To change this template use File | Settings | File Templates.
 */

@Service
public class ExchangeRateCommunicator {
    private static final Logger logger = LoggerFactory.getLogger(ExchangeRateCommunicator.class);

    private final WebClient webClient;


    @Value("${exchange.rate.base.url}")
    private String baseURL;

    @Value("${exchange.rate.api.key}")
    private String apiKey;

    public ExchangeRateCommunicator() {
        WebClient.Builder builder = WebClient.builder();
        this.webClient = builder
                    .baseUrl(baseURL)
                    .build();
    }

    public ExchangeRate getExchangeRate(String fromCurrency,String toCurrencies) throws AppException {
        logger.info("Calling ExchangeRates webService getExchangeRate()....");

        try {
            String uri = baseURL +
                    "/latest" +
                    "?access_key=" + apiKey +
                    "&base=" + fromCurrency +
                    "&symbols=" + toCurrencies;

            logger.debug("Uri:" + uri);

            ExchangeRate response = this.webClient.get()
                    .uri(uri)
                    .retrieve()
                    .bodyToMono(ExchangeRate.class)
                    .block();

            if (response == null) {
                throw new AppException("Problem getting exchange rate!");
            }

            logger.info("Success!");
            logger.debug("Response: " + response);

            return response;
        }catch (Exception e) {
            logger.error(e.getMessage(),e);

            throw new AppException("Connection problem with ExchangeRates webService!",e);
        }
    }


}
