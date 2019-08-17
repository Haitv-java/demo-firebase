package com.ominext.demofirebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test {


    public static void main(String[] args) throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("D:\\serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://quick-start-pick.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("server/saving-data/quick-start-pick");


        DatabaseReference usersRef = ref.child("user");

        Map<String, User> users = new HashMap<>();
        users.put("alanisawesome", new User("June 23, 1912", "Alan Turing"));
        users.put("gracehop", new User("December 9, 1906", "Grace Hopper"));

        usersRef.setValueAsync(users);


    }

    public static class User {

        public String address;
        public String name;

        public User(String address, String name) {
            this.address = address;
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
