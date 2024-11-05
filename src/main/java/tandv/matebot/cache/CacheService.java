package tandv.matebot.cache;

public interface CacheService<R extends CacheRecord, ID> {
    R get(ID id);

    R createOrUpdate(ID id, R value);

    void delete(ID id);
}
