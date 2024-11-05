package tandv.matebot.cache;

import lombok.With;

import tandv.matebot.domain.enums.Messages;
import tandv.matebot.domain.enums.Operation;

@With
public record OperationCacheRecord(Messages currentMessage) implements CacheRecord {
}
