package com.sys.management.repositories;

import com.sys.management.entities.MUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MUserRepository extends JpaRepository<MUser, Long> {
    Optional<MUser> findByUsername(String username);
}
