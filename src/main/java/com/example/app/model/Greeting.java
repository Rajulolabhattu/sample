package com.example.app.model;

import java.util.Date;

/**
 * A model class representing a greeting message.
 */
public class Greeting {
    private long id;
    private String message;
    private Date timestamp;

    public Greeting() {
        this.timestamp = new Date();
    }

    public Greeting(long id, String message) {
        this.id = id;
        this.message = message;
        this.timestamp = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Greeting [id=" + id + ", message=" + message + ", timestamp=" + timestamp + "]";
    }
}