package com.eightm.yasb.controllers;

import com.eightm.yasb.Message;
import com.eightm.yasb.Task;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Maybe;

import javax.inject.Inject;

import static io.micronaut.http.HttpRequest.GET;
import static io.micronaut.http.HttpRequest.POST;

@Controller("/messages")
public class MessageController {
    @Value("${telegram.token}")
    private String token;

    @Client("https://api.telegram.org")
    @Inject
    RxHttpClient httpClient;

    @Post(consumes = MediaType.APPLICATION_JSON)
    public Maybe<HttpStatus> sendMessage(Task task) {

        Message message = new Message(task.getRecipientId(), task.getAuthor() + "\n" + task.getText());
        return httpClient.exchange(
                POST(token + "/sendMessage", message),
                Message.class
        ).firstElement().map(HttpResponse::getStatus);
    }

    @Get("/info")
    public Maybe<String> getBotInfo() {
        return httpClient.retrieve(GET(token + "/getMe")).firstElement();
    }
}
