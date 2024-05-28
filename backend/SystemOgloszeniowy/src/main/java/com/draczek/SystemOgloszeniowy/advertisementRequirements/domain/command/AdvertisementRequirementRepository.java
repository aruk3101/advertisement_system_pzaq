package com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.exception.AdvertisementRequirementNotFoundException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository AdvertisementRequirementRepository.
 */
@Repository
public interface AdvertisementRequirementRepository
    extends JpaRepository<AdvertisementRequirement, Long>,
    JpaSpecificationExecutor<AdvertisementRequirement> {

  Optional<AdvertisementRequirement> findOneByUuid(UUID uuid);

  /**
   * Method for fetching AdvertisementRequirement by its UUID.
   *
   * @param uuid AdvertisementRequirement's UUID
   * @return found AdvertisementRequirement entity
   */
  default AdvertisementRequirement get(UUID uuid) {
    return findOneByUuid(uuid)
        .orElseThrow(
            () -> new AdvertisementRequirementNotFoundException(uuid));
  }
}