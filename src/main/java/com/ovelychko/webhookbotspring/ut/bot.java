package com.ovelychko.webhookbotspring.ut;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.Locale;

public class bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
//        System.out.println(update.getMessage().getText());
//        System.out.println(update.getMessage().getFrom().getFirstName());

        DateTime.Date();
        DateTime.Time();

//        ExecuteTimer.executor();


        String command = update.getMessage().getText().toLowerCase(Locale.ROOT);
        String userName = update.getMessage().getFrom().getFirstName();


        if (command.equals("hello") || command.equals("hi")) {
            String message = null;
            try {
                message = "Hello  " + userName + " Today is " + DateTime.Date() + " " + getWeather.doHTTPGet();
            } catch (IOException e) {
                e.printStackTrace();
            }
            SendMessage response = new SendMessage();
            response.setChatId(update.getMessage().getChatId().toString());
            assert message != null;
            response.setText(message);


            try {
                execute(response);
            } catch (TelegramApiException E) {
                E.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        // TODO
        return "legonaidBot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "5013949709:AAFBnCOTC7tC9FSD9-FyxthaZTWSyhE2u-c";
    }
}

//Client ID
//3
//Client Secret
//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

//Web link
//https://localhost/?state=state_parameter_passthrough_value&code=4/0AX4XfWjsMpS0KzVbAH8-xQ34zw8gFu3VIvr2zav6E9QUKN-SK_74EJ8gnYm3UrN4BT9ZWQ&scope=https://mail.google.com/


