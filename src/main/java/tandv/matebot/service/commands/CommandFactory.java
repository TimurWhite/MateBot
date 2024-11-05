package tandv.matebot.service.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface CommandFactory {
    SendMessage process(Message message);
}
