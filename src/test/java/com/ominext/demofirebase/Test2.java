package com.ominext.demofirebase;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Test2 {

    public static void main(String[] args) throws IOException {
        // Load the service account key JSON file
        FileInputStream serviceAccount =
                new FileInputStream("D:\\serviceAccountKey.json");

        // Authenticate a Google credential with the service account
        GoogleCredential googleCred = GoogleCredential.fromStream(serviceAccount);

        // Add the required scopes to the Google credential
        GoogleCredential scoped = googleCred.createScoped(
                Arrays.asList(
                        "https://www.googleapis.com/auth/firebase.database",
                        "https://www.googleapis.com/auth/userinfo.email"
                )
        );

// Use the Google credential to generate an access token
        scoped.refreshToken();
        String token = scoped.getAccessToken();
        System.out.println(token);
    }


// See the "Using the access token" section below for information
// on how to use the access token to send authenticated requests to the
// Realtime Database REST API.

}
