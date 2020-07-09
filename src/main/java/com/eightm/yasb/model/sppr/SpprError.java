package com.eightm.yasb.model.sppr;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpprError implements SpprEntity {

    @JsonProperty("recipient_id")
    private String recipientId;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String generateMessageText() {
        return description;
    }

    @Override
    public String getRecipientId() {
        return recipientId;
    }
}

