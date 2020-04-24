package com.example.firestore_example;

public class Users {
    String username;
    String UID;
    String email;
    public  Users(){
    }

    public Users(String username, String UID, String email) {
        this.username = username;
        this.UID = UID;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
