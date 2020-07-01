package com.eightm.yasb.controllers;

import com.eightm.yasb.model.GetInfoResult;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class MessageControllerTest {

    @Inject
    EmbeddedServer server;

    @Inject
    @Client("/messages")
    HttpClient client;

    @Test
    void testGetInfoResponse() {
        GetInfoResult response = client.toBlocking()
                .retrieve(HttpRequest.GET("/info"), GetInfoResult.class);
        assertTrue(response.isOk());
    }
}