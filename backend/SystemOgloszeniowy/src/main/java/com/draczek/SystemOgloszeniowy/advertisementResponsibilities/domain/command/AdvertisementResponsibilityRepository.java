package com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.exception.AdvertisementResponsibilityNotFoundException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository AdvertisementResponsibilityRepository.
 */
@Repository
public interface AdvertisementResponsibilityRepository
    extends JpaRepository<AdvertisementResponsibility, Long>,
    JpaSpecificationExecutor<AdvertisementResponsibility> {

  Optional<AdvertisementResponsibility> findOneByUuid(UUID uuid);

  /**
   * Method for fetching AdvertisementResponsibility by its UUID.
   *
   * @param uuid AdvertisementResponsibility's UUID
   * @return found AdvertisementResponsibility entity
   */
  default AdvertisementResponsibility get(UUID uuid) {
    return findOneByUuid(uuid)
        .orElseThrow(
            () -> new AdvertisementResponsibilityNotFoundException(uuid));
  }
}