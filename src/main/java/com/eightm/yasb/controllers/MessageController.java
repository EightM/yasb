package com.eightm.yasb.controllers;

import com.eightm.yasb.config.SPPRConfig;
import com.eightm.yasb.config.TelegramConfig;
import com.eightm.yasb.model.MessageForSend;
import com.eightm.yasb.model.RegisterRequest;
import com.eightm.yasb.model.Task;
import com.eightm.yasb.model.Update;
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
import java.util.Objects;

import static io.micronaut.http.HttpRequest.GET;
import static io.micronaut.http.HttpRequest.POST;

@Controller("/tasks")
public class MessageController {

    private final String token;
    private final String spprAddress;
    private final SPPRConfig spprConfig;

    @Client("https://api.telegram.org")
    @Inject
    RxHttpClient httpClient;

    public MessageController(TelegramConfig telegramConfig, SPPRConfig spprConfig) {
        token = "/bot" + telegramConfig.getToken();
        this.spprConfig = spprConfig;
        spprAddress = spprConfig.getAddress();
    }

    @Post(consumes = MediaType.APPLICATION_JSON)
    public Maybe<HttpStatus> sendMessage(Task task) {
        Objects.requireNonNull(task);

        return httpClient.exchange(
                POST(token + "/sendMessage", MessageForSend.createMessage(task)),
                MessageForSend.class
        ).firstElement().map(HttpResponse::getStatus);
    }

    @Post(value = "/webhook", consumes = MediaType.APPLICATION_JSON)
    public Maybe<HttpStatus> handleWebHookUpdate(Update update) {
        Objects.requireNonNull(spprAddress);
        Objects.requireNonNull(update.getMessage());
        String[] messageText = update.getMessage().getText().split("\\s+");

        if (messageText.length != 2 || !messageText[0].equals("/start")) {
            return Maybe.empty();
        }

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setInviteId(messageText[1]);
        registerRequest.setUserId(String.valueOf(update.getMessage().getFrom().getId()));

        return httpClient.exchange(
          POST(spprAddress + "/employees/register", "")
                  .basicAuth(spprConfig.getLogin(), spprConfig.getPassword())
                  .body(registerRequest)
        ).firstElement().map(HttpResponse::getStatus);
    }

    @Get("/info")
    public Maybe<String> getBotInfo() {
        return httpClient.retrieve(GET(token + "/getMe")).firstElement();
    }
}
