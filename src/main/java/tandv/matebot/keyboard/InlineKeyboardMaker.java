package tandv.matebot.keyboard;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import tandv.matebot.domain.entity.UserEntity;
import tandv.matebot.domain.enums.Language;
import tandv.matebot.service.MessageService;

import java.util.ArrayList;
import java.util.List;

import static tandv.matebot.domain.enums.Messages.*;

@Component
@Data
@RequiredArgsConstructor
public class InlineKeyboardMaker {
    private final MessageService messageService;

    public SendMessage languageChooseButtons(long chatId){
        String languageMessage = messageService.getMessage(ONSTART, Language.EN);;

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Ukrainian");
        button1.setCallbackData("language_ukrainian");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("English");
        button2.setCallbackData("language_english");

        row.add(button1);
        row.add(button2);
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(languageMessage);
        sendMessage.setReplyMarkup(keyboardMarkup);
        return sendMessage;
    }
    public SendMessage gameChooseButtons(long chatId){
        String gameMessage = messageService.getMessage(GAME, Language.EN);

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Valorant");
        button1.setCallbackData("valorant");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("CS2");
        button2.setCallbackData("cs2");

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("PUBG");
        button3.setCallbackData("pubg");

        row.add(button1);
        row.add(button2);
        row.add(button3);
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(gameMessage);
        sendMessage.setReplyMarkup(keyboardMarkup);

        return sendMessage;
    }
    public SendMessage ageChooseButtons(long chatId){
        String ageMessage = messageService.getMessage(YEARS_OLD, Language.EN);

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        // Первый ряд кнопок
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("15+");
        button1.setCallbackData("teen");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("18+");
        button2.setCallbackData("youth");

        row1.add(button1);
        row1.add(button2);

        // Второй ряд кнопок
        List<InlineKeyboardButton> row2 = new ArrayList<>();


        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("25+");
        button3.setCallbackData("adult");

        row2.add(button3);


        // Добавляем ряды в клавиатуру
        keyboard.add(row1);
        keyboard.add(row2);

        keyboardMarkup.setKeyboard(keyboard);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(ageMessage);
        sendMessage.setReplyMarkup(keyboardMarkup);

        return sendMessage;
    }
}
