package com.example.vmware.providers;
import com.example.vmware.communicators.GoogleAuthenticator;
import com.example.vmware.exceptions.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Created with IntelliJ IDEA.
 * User: nikolay.stanev
 * Date: 28.2.2022 г.
 * Time: 13:13
 * To change this template use File | Settings | File Templates.
 */
@Provider
@Component
public class RequestHandler implements ContainerRequestFilter {

    @Autowired
    GoogleAuthenticator authenticator;

    @Override
    public void filter(ContainerRequestContext requestContext)  {

        if(!requestContext.getUriInfo().getPath().contains("auth")) {

            if(requestContext.getHeaders().get("Google-id-token") != null) {
                try {
                    if(!authenticator.checkToken(requestContext.getHeaders().get("Google-id-token").get(0))){
                        requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
                    }
                } catch (AppException e) {
                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
                }
            }else {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }

        }

    }
}
