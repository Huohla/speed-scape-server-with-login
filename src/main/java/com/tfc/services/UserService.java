package com.tfc.services;

import java.util.Optional;

import com.tfc.entities.GameUser;
import jakarta.transaction.Transactional;

import com.tfc.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<GameUser> getByUserName(String userName){
        return userRepository.findByUsername(userName);
    }
    public boolean existByUserName(String userName){
        return userRepository.existsByUsername(userName);
    }
    public void save(GameUser gameUser){
        userRepository.save(gameUser);
    }

}
