package Lab5;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo,Long> {

    @Override
    Optional<BuddyInfo> findById(Long l);


}
