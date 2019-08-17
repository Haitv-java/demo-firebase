package com.ominext.demofirebase.controller;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.ominext.demofirebase.model.User;
import com.ominext.demofirebase.transport.FirebaseTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "/user")
public class UserRestController{

    @Autowired
    private FirebaseTransport firebaseTransport;

    @PostMapping(value = "/add")
    public String add(@RequestBody User user) throws IOException, URISyntaxException {
        firebaseTransport.add(user);
        return "success";
    }

}
