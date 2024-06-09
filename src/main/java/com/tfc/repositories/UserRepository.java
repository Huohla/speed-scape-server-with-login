package com.tfc.repositories;

import java.util.Optional;
import java.util.UUID;

import com.tfc.entities.GameUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<GameUser, UUID> {

    Optional<GameUser> findByUsername(String userName);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}