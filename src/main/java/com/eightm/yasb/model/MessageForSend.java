package com.eightm.yasb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageForSend {

    @JsonProperty("chat_id")
    private String chatId;
    private String text;
    @JsonProperty("parse_mode")
    private String parseMode;

    public static MessageForSend createMessage(SpprEntity spprEntity) {
        MessageForSend messageForSend = new MessageForSend();
        messageForSend.parseMode = "Markdown";
        messageForSend.chatId = spprEntity.getRecipientId();
        messageForSend.text = generateMessageText(spprEntity);

        return messageForSend;
    }

    private static String generateMessageText(SpprEntity spprEntity) {
        return spprEntity.generateMessageText();
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setParseMode(String parseMode) {
        this.parseMode = parseMode;
    }

    public String getChatId() {
        return chatId;
    }

    public String getText() {
        return text;
    }

    public String getParseMode() {
        return parseMode;
    }
}
