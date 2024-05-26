package com.draczek.SystemOgloszeniowy.advertisement.domain.command;

import com.draczek.SystemOgloszeniowy.advertisement.domain.exception.AdvertisementNotFoundException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository AdvertisementRepository.
 */
@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long>,
    JpaSpecificationExecutor<Advertisement> {

  Optional<Advertisement> findOneByUuid(UUID uuid);

  /**
   * Method for fetching Advertisement by its UUID.
   *
   * @param uuid Advertisement's UUID
   * @return found Advertisement entity
   */
  default Advertisement get(UUID uuid) {
    return findOneByUuid(uuid)
        .orElseThrow(
            () -> new AdvertisementNotFoundException(uuid));
  }
}
