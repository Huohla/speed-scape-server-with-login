package com.tfc.repositories;

import com.tfc.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    List<Transaction> findByUserId(UUID clientId);
    List<Transaction> findByUserUsername(String username);
    Long countById(UUID id);
}
