package tandv.matebot.testControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tandv.matebot.domain.enums.Language;
import tandv.matebot.service.MessageService;

import static tandv.matebot.domain.enums.Messages.HELLO;

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
