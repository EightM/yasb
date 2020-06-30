package com.eightm.yasb;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties(value = "telegram")
public class TelegramProperties {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
