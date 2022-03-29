package com.example.vmware.resources;

import com.example.vmware.communicators.GoogleAuthenticator;
import com.example.vmware.exceptions.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


/**
 * Created with IntelliJ IDEA.
 * User: nikolay.stanev
 * Date: 28.3.2022 г.
 * Time: 13:46
 * To change this template use File | Settings | File Templates.
 */

@Path("auth")
public class AuthResource {

    @Autowired
    GoogleAuthenticator authenticator;

    @Value("${google.auth.client.id}")
    private String clientId;

    @Autowired
    HttpServletRequest request;

    @POST
    @Path("/signIn")
    @Produces("application/json")
    public String signIn (String authCode) throws AppException {

            String idToken = authenticator.authorise(authCode).getIdToken();

            return idToken;

    }
}
