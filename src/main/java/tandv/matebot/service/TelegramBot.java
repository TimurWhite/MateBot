package tandv.matebot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import tandv.matebot.config.BotConfig;
import tandv.matebot.domain.enums.Language;
import tandv.matebot.keyboard.InlineKeyboardMaker;
import tandv.matebot.keyboard.ReplyKeyboardMaker;

import java.util.ArrayList;
import java.util.List;

import static tandv.matebot.domain.enums.Messages.HELLO;
import static tandv.matebot.domain.enums.Messages.ONSTART;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig config;
    private final ReplyKeyboardMaker replyKeyboardMaker;
    private final InlineKeyboardMaker inlineKeyboardMaker;


    public TelegramBot(BotConfig config, MessageService messageService, ReplyKeyboardMaker replyKeyboardMaker, InlineKeyboardMaker inlineKeyboardMaker) {
        this.config = config;
        this.messageService = messageService;
        this.replyKeyboardMaker = replyKeyboardMaker;
        this.inlineKeyboardMaker = inlineKeyboardMaker;
    }

    private MessageService messageService;

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()&& update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            switch (messageText){
                case "/start":
                    startCommandReceived(chatId);
                    break;
                case "/game_choose":
                    sendGameSelectionMessage(chatId);
                    break;
                case "/age_choose":
                    sendAgeSelectionMessage(chatId);
                    break;

                    default: sendMessage(chatId, "Sorry not supported");

            }

        }

    }

    private void sendReportMessage(long chatId) {
    }

    private void userProfileApplying(long chatId) {
    }


    private void startCommandReceived(long chatId) {
        // Отправляем сообщение с главным меню
        sendMainMenuMessage(chatId);
        // Отправляем сообщение с выбором языка
        sendLanguageSelectionMessage(chatId);
    }

    private void sendMainMenuMessage(long chatId) {
        String welcomeMessage = messageService.getMessage(HELLO, Language.EN);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(welcomeMessage);
        sendMessage.enableMarkdown(true);
        sendMessage.setReplyMarkup(replyKeyboardMaker.getMainMenuKeyboard());

        try {
            execute(sendMessage); // Этот метод должен отправлять сообщение
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendLanguageSelectionMessage(long chatId) {

        try {
            execute(inlineKeyboardMaker.languageChooseButtons(chatId)); // Этот метод должен отправлять сообщение
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private void sendGameSelectionMessage( long chatId){
        try{
            execute(inlineKeyboardMaker.gameChooseButtons(chatId));
        } catch (TelegramApiException e ){
            e.printStackTrace();
        }
    }
    private void sendAgeSelectionMessage( long chatId){
        try{
            execute(inlineKeyboardMaker.ageChooseButtons(chatId));
        } catch (TelegramApiException e ){
            e.printStackTrace();
        }
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

    /*private void sendMessage(long chatId, String textToSend, InlineKeyboardMarkup keyboardMarkup){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        message.setReplyMarkup(keyboardMarkup);
        try{
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }*/

    @Override
    public String getBotToken(){
        return config.getToken();
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }
}
