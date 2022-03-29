package com.example.vmware;

import com.example.vmware.providers.RequestHandler;
import com.example.vmware.resources.AuthResource;
import com.example.vmware.resources.PlannerResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("rest")
public class JerseyConfig extends ResourceConfig {
    private static final Logger logger = LoggerFactory.getLogger(JerseyConfig.class);

    public JerseyConfig() {
        logger.debug("JerseyConfig()");

        register(PlannerResource.class);
        register(AuthResource.class);
        register(RequestHandler.class);

    }

}
