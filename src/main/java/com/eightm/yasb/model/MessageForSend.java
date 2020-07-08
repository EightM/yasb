package com.eightm.yasb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageForSend {

    @JsonProperty("chat_id")
    private String chatId;
    private String text;
    @JsonProperty("parse_mode")
    private String parseMode;

    public static MessageForSend createMessage(Task task) {
        MessageForSend messageForSend = new MessageForSend();
        messageForSend.parseMode = "Markdown";
        messageForSend.chatId = task.getRecipientId();
        messageForSend.text = generateMessageText(task);

        return messageForSend;
    }

    private static String generateMessageText(Task task) {

        String text = String.format("Тебе пришла новая задача.%n") +
                String.format("%s%n", task.getName()) +
                String.format("*Автор:* %s%n", task.getAuthor()) +
                String.format("*Статус:* %s%n", task.getStatus()) +
                String.format("*Описание задачи:* %s%n", task.getText());

        if (!task.getEndDate().isBlank()) {
            text += String.format("*Дата окончания:* %s%n", task.getEndDate());
        }

        if (!task.getExternalRef().isBlank()) {
            text += String.format("[Ссылка на задачу](%s)%n", task.getExternalRef());
        }

        return text;
    }

    public String getChatId() {
        return chatId;
    }

    public MessageForSend(String chatId, String text) {
        this.chatId = chatId;
        this.text = text;
    }

    public MessageForSend() {
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

    public String getParseMode() {
        return parseMode;
    }

    public void setParseMode(String parseMode) {
        this.parseMode = parseMode;
    }
}
