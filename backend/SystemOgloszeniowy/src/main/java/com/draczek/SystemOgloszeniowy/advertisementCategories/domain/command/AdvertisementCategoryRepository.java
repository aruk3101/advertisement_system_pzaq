package com.draczek.SystemOgloszeniowy.advertisementCategories.domain.command;

import com.draczek.SystemOgloszeniowy.advertisement.domain.exception.AdvertisementNotFoundException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository AdvertisementCategoryRepository.
 */
@Repository
public interface AdvertisementCategoryRepository extends JpaRepository<AdvertisementCategory, Long>,
    JpaSpecificationExecutor<AdvertisementCategory> {

  Optional<AdvertisementCategory> findOneByUuid(UUID uuid);

  /**
   * Method for fetching AdvertisementCategory by its UUID.
   *
   * @param uuid AdvertisementCategory's UUID
   * @return found AdvertisementCategory entity
   */
  default AdvertisementCategory get(UUID uuid) {
    return findOneByUuid(uuid)
        .orElseThrow(
            () -> new AdvertisementNotFoundException(uuid));
  }
}
