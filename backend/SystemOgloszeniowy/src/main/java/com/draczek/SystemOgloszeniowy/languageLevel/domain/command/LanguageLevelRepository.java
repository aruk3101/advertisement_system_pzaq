package com.draczek.SystemOgloszeniowy.languageLevel.domain.command;

import com.draczek.SystemOgloszeniowy.languageLevel.domain.exception.LanguageLevelNotFoundException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository LanguageLevel.
 */
@Repository
public interface LanguageLevelRepository extends JpaRepository<LanguageLevel, Long>,
    JpaSpecificationExecutor<LanguageLevel> {

  Optional<LanguageLevel> findOneByUuid(UUID uuid);

  /**
   * Method for fetching LanguageLevel by its UUID.
   *
   * @param uuid LanguageLevel's UUID
   * @return found LanguageLevel entity
   */
  default LanguageLevel get(UUID uuid) {
    return findOneByUuid(uuid)
        .orElseThrow(
            () -> new LanguageLevelNotFoundException(uuid));
  }
}

