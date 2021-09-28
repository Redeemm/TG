package com.ovelychko.webhookbotspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebhookBotSpringApplication {
    private static final Logger logger = LoggerFactory.getLogger(WebhookBotSpringApplication.class);

    public static void main(String[] args) {
        logger.info("WebhookBotSpringApplication.main called");
        SpringApplication.run(WebhookBotSpringApplication.class, args);
    }
}
