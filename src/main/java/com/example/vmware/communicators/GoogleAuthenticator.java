package com.example.vmware.communicators;

import com.example.vmware.exceptions.AppException;
import com.google.api.client.googleapis.auth.oauth2.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: nikolay.stanev
 * Date: 28.3.2022 г.
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 */
@Service
public class GoogleAuthenticator {

    @Value("${google.auth.client.id}")
    private String clientId;

    @Value("${google.auth.secret.id}")
    private String clientSecret;

    private final GoogleClientSecrets clientSecrets;
    private final NetHttpTransport transport;
    private final GsonFactory gsonFactory;

    public GoogleAuthenticator() {
        GoogleClientSecrets.Details details = new GoogleClientSecrets.Details();
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        clientSecrets = new GoogleClientSecrets();
        clientSecrets.setInstalled(details);
        transport = new NetHttpTransport();
        gsonFactory = GsonFactory.getDefaultInstance();
    }

    public GoogleTokenResponse authorise(String token) throws AppException {
        try {
            GoogleTokenResponse tokenResponse =
                    new GoogleAuthorizationCodeTokenRequest(
                            transport,
                            gsonFactory,
                            "https://oauth2.googleapis.com/token",
                            clientId,
                            clientSecret,
                            token,
                            "http://localhost:8888")  // Specify the same redirect URI that you use with your web
                            // app. If you don't have a web version of your app, you can
                            // specify an empty string.
                            .execute();

            return tokenResponse;
        }catch (IOException e) {

            throw new AppException(e.getMessage(),e);
        }

    }
    public boolean checkToken(String idToken) throws AppException {

        try {
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport,gsonFactory).build();
            GoogleIdToken googleIdToken = verifier.verify(idToken);

            if(googleIdToken == null) {
                return false;
            }
            return true;


        } catch (Exception e) {

            throw new AppException(e.getMessage(),e);
        }
    }
}
