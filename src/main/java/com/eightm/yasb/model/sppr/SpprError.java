package com.eightm.yasb.model.sppr;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SpprError implements SpprEntity {

    @JsonProperty("recipient_id")
    private String recipientId;
    private String description;
    private String name;
    private String status;
    private String priority;
    private String executor;
    private String comment;
    private String code;
    private String project;

    @Override
    public String generateMessageText() {
        Map<String, String> fieldsMap = new LinkedHashMap<>();
        fieldsMap.put("Наименование", name);
        fieldsMap.put("Проект", project);
        fieldsMap.put("Срочность исправления", priority);
        fieldsMap.put("Порядок воспроизведения", description);
        fieldsMap.put("Код", code);
        fieldsMap.put("Статус", status);
        fieldsMap.put("Исполнитель", executor);
        fieldsMap.put("Комментарий", comment);

        return fieldsMap.entrySet().stream()
                .filter(entry -> entry.getValue() != null && !entry.getValue().isBlank())
                .map(entry -> String.format("*%s*: %s%n", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining());
    }

    @Override
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

