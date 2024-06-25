package tandv.matebot.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tandv.matebot.config.EnMessages;
import tandv.matebot.config.UaMessages;
import tandv.matebot.domain.enums.Language;
import tandv.matebot.domain.enums.Messages;

@Service
@AllArgsConstructor
public class MessageService {
    private EnMessages enMessages;
    private UaMessages uaMessages;

    public String getMessage(Messages message, Language language){
        return switch (language){
            case EN -> enMessages.getMessages().get(message.getPropertyName());
            case UA -> uaMessages.getMessages().get(message.getPropertyName());
        };
    }

}
