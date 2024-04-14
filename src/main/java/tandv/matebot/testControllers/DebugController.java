package tandv.matebot.testControllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tandv.matebot.config.EnMessages;
import tandv.matebot.domain.model.Language;
import tandv.matebot.service.MessageService;

import java.util.Map;

import static tandv.matebot.domain.model.Messages.HELLO;

@RestController
@RequestMapping("debug")
@AllArgsConstructor
public class DebugController {
    private MessageService messageService;
    @GetMapping("/{language}")
    public String debug(@PathVariable Language language){
        return messageService.getMessage(HELLO, language);

    }
}
