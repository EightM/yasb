package com.eightm.yasb.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
    private String name;
    private String status;
    private String author;

    @JsonProperty("end_date")
    private String endDate;

    private String text;
    @JsonProperty("recipient_id")
    private String recipientId;

    @JsonProperty("external_ref")
    private String externalRef;

    public Task(String author, String text, String recipientId) {
        this.author = author;
        this.text = text;
        this.recipientId = recipientId;
    }

    public Task() {
    }

    public String getExternalRef() {
        return externalRef;
    }

    public void setExternalRef(String externalRef) {
        this.externalRef = externalRef;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
