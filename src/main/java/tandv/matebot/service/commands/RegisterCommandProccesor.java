package tandv.matebot.service.commands;

import lombok.AllArgsConstructor;
import org.jvnet.hk2.annotations.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import tandv.matebot.cache.CacheService;
import tandv.matebot.cache.OperationCacheRecord;
import tandv.matebot.cache.RegistrationTempDataCacheRecord;

@Service
@AllArgsConstructor
public class RegisterCommandProccesor implements CommandProccesor{
    private CacheService<OperationCacheRecord, Long> operationCacheService;
    private CacheService<RegistrationTempDataCacheRecord, Long> registerCacheService;

    @Override
    public SendMessage process(Message message) {
        return null;
    }

    @Override
    public String getCommand() {
        return "";
    }
}
