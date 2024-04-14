package tandv.matebot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tandv.matebot.domain.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
