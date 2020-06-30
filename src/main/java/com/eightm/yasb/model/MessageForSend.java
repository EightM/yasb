package com.eightm.yasb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageForSend {

    @JsonProperty("chat_id")
    private String chatId;
    private String text;

    public String getChatId() {
        return chatId;
    }

    public MessageForSend(String chatId, String text) {
        this.chatId = chatId;
        this.text = text;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
