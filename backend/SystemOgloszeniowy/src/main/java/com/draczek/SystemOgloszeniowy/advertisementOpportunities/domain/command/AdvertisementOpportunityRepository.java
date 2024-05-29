package com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.exception.AdvertisementOpportunityNotFoundException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository AdvertisementOpportunityRepository.
 */
@Repository
public interface AdvertisementOpportunityRepository
    extends JpaRepository<AdvertisementOpportunity, Long>,
    JpaSpecificationExecutor<AdvertisementOpportunity> {

  Optional<AdvertisementOpportunity> findOneByUuid(UUID uuid);

  /**
   * Method for fetching AdvertisementOpportunity by its UUID.
   *
   * @param uuid AdvertisementOpportunity's UUID
   * @return found AdvertisementOpportunity entity
   */
  default AdvertisementOpportunity get(UUID uuid) {
    return findOneByUuid(uuid)
        .orElseThrow(
            () -> new AdvertisementOpportunityNotFoundException(uuid));
  }
}
