package com.eightm.yasb.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
    private String author;
    private String text;
    @JsonProperty("recipient_id")
    private String recipientId;

    public Task(String author, String text, String recipientId) {
        this.author = author;
        this.text = text;
        this.recipientId = recipientId;
    }

    public Task() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }
}
