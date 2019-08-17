package com.ominext.demofirebase.transport;

import com.ominext.demofirebase.authentication.FirebaseAuthencation;
import com.ominext.demofirebase.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Component
public class FirebaseTransportImpl implements FirebaseTransport {

    @Autowired
    private FirebaseAuthencation authencation;

    @Override
    public void add(User user) throws URISyntaxException, IOException {

        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "https://quick-start-pick.firebaseio.com/user.json";
        URI uri = new URI(baseUrl);
        User data = new User("Adam", "Gemek");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authencation.getAccessToken());

        HttpEntity<User> request = new HttpEntity<>(data, headers);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        System.out.println(result);

    }
}
