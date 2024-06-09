package com.tfc.services;

import com.tfc.entities.Transaction;
import com.tfc.repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getListByClient(String userName) {
        return this.transactionRepository.findByUserUsername(userName);
    }

    public void cleanShoppingCart(UUID clientId) {
        this.transactionRepository.deleteById(clientId);
    }

    public void removeProduct(UUID id) {
        this.transactionRepository.deleteById(id);
    }

    public void addProduct(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }

    public Long getCountByUser(UUID userId) {
        return this.transactionRepository.countById(userId);
    }
}
