package com.example.vmware.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: nikolay.stanev
 * Date: 26.3.2022 г.
 * Time: 15:01
 * To change this template use File | Settings | File Templates.
 */
@Component
@PropertySource("classpath:vmware.properties")
public class AppConfig {

    @Autowired
    private Environment env;

    public static final String GEO_NAMES_BASE_URL = "geo.names.base.url";

    public String getConfigValue(String configKey){
        return env.getProperty(configKey);
    }

}
