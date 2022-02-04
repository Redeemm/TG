package com.ovelychko.webhookbotspring;

import com.ovelychko.webhookbotspring.ut.bot;
import com.ovelychko.webhookbotspring.ut.getWeather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

@SpringBootApplication
public class WebhookBotSpringApplication {
    private static final Logger logger = LoggerFactory.getLogger(WebhookBotSpringApplication.class);

    public static void main(String[] args) throws IOException {
        logger.info("WebhookBotSpringApplication.main called");
        SpringApplication.run(WebhookBotSpringApplication.class, args);


        getWeather.doHTTPGet();


        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
