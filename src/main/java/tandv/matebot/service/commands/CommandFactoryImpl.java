package tandv.matebot.service.commands;

import lombok.AllArgsConstructor;
import org.jvnet.hk2.annotations.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import tandv.matebot.cache.CacheService;
import tandv.matebot.cache.OperationCacheRecord;
import tandv.matebot.domain.enums.Language;
import tandv.matebot.domain.enums.Messages;
import tandv.matebot.service.MessageService;

import java.util.List;

import static tandv.matebot.domain.enums.Messages.NONE;

@Service
@AllArgsConstructor
public class CommandFactoryImpl implements CommandFactory {
    List<CommandProccesor> commandProccessors;
    CacheService<OperationCacheRecord, Long> operationCacheService;
    MessageService messageService;
    @Override
    public SendMessage process(Message message) {
        Messages messages = operationCacheService.get(message.getChatId()).currentMessage();
        if(messages != NONE && !message.getText().equals("/cancel")){
            return new SendMessage(String.valueOf(message.getChatId()), messageService.getMessage(NONE, Language.EN)); //Заменить через User
        }
        String command = message.getText().replace("/","");
        return  commandProccessors.stream()
                .filter(commandProccesor -> commandProccesor.getCommand().equals(command))
                .findFirst()
                .map(commandProccesor -> commandProccesor.process(message))
                .orElseGet(()-> new SendMessage(String.valueOf(message.getChatId()), String.format(messageService.getMessage(NONE, Language.EN), command)));

    }


}
