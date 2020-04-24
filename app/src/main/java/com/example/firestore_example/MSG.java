package com.example.firestore_example;

public class MSG {
    private String message;
    private String username;
    private String timestamp;

    public MSG(String message, String username, String timestamp) {
        this.message = message;
        this.username = username;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
