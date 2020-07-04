package com.eightm.yasb;

import io.micronaut.context.annotation.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties("telegram")
public class TelegramConfig {

    @NotBlank
    private String token;
    private String sppr;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSppr() {
        return sppr;
    }

    public void setSppr(String sppr) {
        this.sppr = sppr;
    }
}
