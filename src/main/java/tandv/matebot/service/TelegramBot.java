package tandv.matebot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import tandv.matebot.config.BotConfig;

import java.util.ArrayList;
import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig config;

    public TelegramBot(BotConfig config) {
        this.config = config;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()&& update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            String callback = update.getCallbackQuery().getData();
            long chatId = update.getMessage().getChatId();
            switch (messageText){
                case "/start":
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    if(callback.equals("ukr_lang")){
                        sendMessage(chatId, "Sorry, not supported");
                    }
                    else if(callback.equals("eng_lang")){
                        
                    }
                    break;
                    default: sendMessage(chatId, "Sorry not supported");

            }

        }

    }
    private void startCommandReceived(long chatId, String firstName){
        String welcomeMessage = "Hello " + firstName +" please choose your language, it will affect on teamates you'll be finding" +
                "\nПривіт "+firstName + " будь ласка обери мову, це вплине на мову твоїх тімейтів";

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Ukranian");
        button1.setCallbackData("ukr_lang");
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("English");
        button2.setCallbackData("eng_lang");
        row.add(button1);
        row.add(button2);
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        sendMessage(chatId, welcomeMessage, keyboardMarkup);

    }
    private void sendMessage(long chatId, String textToSend){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        try{
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    private void sendMessage(long chatId, String textToSend, InlineKeyboardMarkup keyboardMarkup){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        message.setReplyMarkup(keyboardMarkup);
        try{
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String getBotToken(){
        return config.getToken();
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }
}
