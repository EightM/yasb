package com.eightm.yasb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageForSend {

    @JsonProperty("chat_id")
    private String chatId;
    private String text;

    public static MessageForSend createMessage(Task task) {
        MessageForSend messageForSend = new MessageForSend();
        messageForSend.chatId = task.getRecipientId();
        messageForSend.text = generateMessageText(task);

        return messageForSend;
    }

    private static String generateMessageText(Task task) {

        return String.format("Привет, тебе пришла новая задача.%n") +
                String.format("Автор: %s%n", task.getAuthor()) +
                String.format("Статус: %s%n", task.getStatus()) +
                String.format("Дата окончания: %s%n", task.getEndDate()) +
                String.format("Описание задачи: %s%n", task.getText());
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
}
