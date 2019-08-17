package com.ominext.demofirebase.transport;

import com.ominext.demofirebase.model.User;

import java.io.IOException;
import java.net.URISyntaxException;

public interface FirebaseTransport {

    void add(User user) throws URISyntaxException, IOException;

}
