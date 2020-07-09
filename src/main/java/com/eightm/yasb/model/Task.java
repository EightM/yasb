package com.eightm.yasb.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Singleton
public class Task implements SpprEntity {
    private String name;
    private String code;
    private String status;
    private String author;
    private String executor;
    private String controller;
    @JsonProperty("begin_date")
    private String beginDate;
    @JsonProperty("end_date")
    private String endDate;
    private String subject;
    private String project;
    private String text;
    @JsonProperty("recipient_id")
    private String recipientId;
    private EntityCategory entityCategory;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
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

    public EntityCategory getEntityCategory() {
        return entityCategory;
    }

    public void setEntityCategory(EntityCategory entityCategory) {
        this.entityCategory = entityCategory;
    }

    @Override
    public String generateMessageText() {

        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put("Наименование", name);
        fieldsMap.put("Код", code);
        fieldsMap.put("Статус", status);
        fieldsMap.put("Автор", author);
        fieldsMap.put("Исполнитель", executor);
        fieldsMap.put("Контролирующий", controller);
        fieldsMap.put("Дата начала", beginDate);
        fieldsMap.put("Дата окончания", endDate);
        fieldsMap.put("Предмет", subject);
        fieldsMap.put("Проект", project);
        fieldsMap.put("Описание", this.text);
        fieldsMap.put("Ссылка на задачу", externalRef);

        return fieldsMap.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .map(entry -> String.format("*%s*: %s%n", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining());
    }

    @Override
    public String getRecipientId() {
        return recipientId;
    }
}
