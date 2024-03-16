package com.draczek.SystemOgloszeniowy.address.domain.command;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository AddressRepository.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>,
    JpaSpecificationExecutor<Address> {
}

