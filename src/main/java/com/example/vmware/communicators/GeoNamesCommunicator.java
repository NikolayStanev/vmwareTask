package com.example.vmware.communicators;

import com.example.vmware.exceptions.AppException;
import com.example.vmware.rest.ToponymSearchResult;
import com.example.vmware.services.PlannerServiceImpl;
import com.example.vmware.util.AppConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;


/**
 * Created with IntelliJ IDEA.
 * User: nikolay.stanev
 * Date: 26.3.2022 г.
 * Time: 14:42
 * To change this template use File | Settings | File Templates.
 */
@Service
public class GeoNamesCommunicator {

    private static final Logger logger = LoggerFactory.getLogger(GeoNamesCommunicator.class);

    @Autowired
    AppConfig appConfig;
    private final WebClient webClient;

    @Value("${geo.names.base.url}")
    private String baseURL;

    @Value("${geo.names.base.username}")
    private String username;

    private GeoNamesCommunicator() {
        WebClient.Builder builder = WebClient.builder();
        this.webClient = builder
                .baseUrl(baseURL)
                .build();
    }

    public ToponymSearchResult getCountryInfo() throws AppException {
        logger.info("Calling GeoName webService getCountryInfo()....");
        try {
            String uri = baseURL + "/countryInfoJSON" + "?username=" + username;

            logger.debug("Uri: " + uri);

            ToponymSearchResult response = this.webClient.get()
                    .uri(uri)
                    .retrieve()
                    .bodyToMono(ToponymSearchResult.class)
                    .block();

            logger.info("Success!");
            logger.debug("Response: " + response);

            return response;
        }catch (Exception e) {
            logger.error(e.getMessage(),e);

            throw new AppException("Connection problem with GeoName webService!",e);
        }
    }

    public ToponymSearchResult getCountryInfo(String countryCode) throws AppException {
        logger.info("Calling GeoName webService getCountryInfo()....");

        try {
            String uri = baseURL + "/countryInfoJSON" + "?username=" + username + "&country=" + countryCode;

            ToponymSearchResult response = this.webClient.get()
                    .uri(uri)
                    .retrieve()
                    .bodyToMono(ToponymSearchResult.class)
                    .block();

            logger.info("Success!");
            logger.debug("Response: " + response);

            return response;
        }catch (Exception e) {
            logger.error(e.getMessage(),e);

            throw new AppException("Connection problem with GeoName webService!",e);
        }
    }

    public ToponymSearchResult getNeighbours (String countryISO) throws AppException {
        logger.info("Calling GeoName webService getNeighbours()....");

        try {
            String uri = baseURL + "/neighboursJSON"  + "?username=" + username + "&country=" + countryISO;

            ToponymSearchResult response = this.webClient.get()
                    .uri(uri)
                    .retrieve()
                    .bodyToMono(ToponymSearchResult.class)
                    .block();

            logger.info("Success!");
            logger.debug("Response: " + response);

            return response;
        }catch (Exception e) {
            logger.error(e.getMessage(),e);

            throw new AppException("Connection problem with GeoName webService!",e);
        }
    }

}
