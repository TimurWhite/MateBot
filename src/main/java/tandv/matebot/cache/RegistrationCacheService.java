package tandv.matebot.cache;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RegistrationCacheService implements CacheService<RegistrationTempDataCacheRecord, Long> {
    @Override
    @Cacheable(cacheNames = "registrationCache", key ="#userId")
    public RegistrationTempDataCacheRecord get(Long userId){return null;}

    @Override
    @CachePut(cacheNames = "registrationCache", key = "#userId")
    public RegistrationTempDataCacheRecord createOrUpdate(Long userId, RegistrationTempDataCacheRecord value) {
        return value;
    }

    @Override
    @Cacheable(cacheNames = "registrationCache", key = "#userId")
    public void delete(Long aLong) {

    }
}
