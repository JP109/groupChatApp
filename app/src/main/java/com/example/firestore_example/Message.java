package com.example.firestore_example;

import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class Message {
    String Username;
    String message;
    String samay;


//    @ServerTimestamp
    private FieldValue timestamp;
    public Message(){
    }

    public Message(String username, String message, String samay) {
        this.Username = username;
        this.message = message;
        this.samay=samay;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public FieldValue getTimeStamp() {
//        return timestamp;
//    }
//
//    public void setTimeStamp(FieldValue timeStamp) {
//        this.timestamp = timeStamp;
//    }

    public String getSamay() {
        return samay;
    }

    public void setSamay(String samay) {
        this.samay = samay;
    }
}

