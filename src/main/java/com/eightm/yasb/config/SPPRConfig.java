package com.eightm.yasb.config;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("sppr")
public class SPPRConfig {
    private String address;
    private String login;
    private String password;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
