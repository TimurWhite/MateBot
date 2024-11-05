package tandv.matebot.cache;

import lombok.With;
import tandv.matebot.domain.enums.CallBackGameData;
import tandv.matebot.domain.enums.CallBackYearsData;
import tandv.matebot.domain.enums.Language;

@With
public record RegistrationTempDataCacheRecord(Long id, String nickName, String discordTag, CallBackGameData gameData, CallBackYearsData yearsData, Language language, String chatId) implements CacheRecord {
}
