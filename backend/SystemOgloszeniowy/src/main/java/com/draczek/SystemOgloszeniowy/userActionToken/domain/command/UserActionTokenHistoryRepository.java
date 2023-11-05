package com.draczek.SystemOgloszeniowy.userActionToken.domain.command;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserActionTokenHistory repository.
 */
@Repository
public interface UserActionTokenHistoryRepository
    extends JpaRepository<UserActionTokenHistory, Long> {
}
