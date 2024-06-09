package com.tfc.services;

import com.tfc.dto.UserLoginDto;
import com.tfc.entities.GameUser;
import com.tfc.enums.RoleEnum;
import com.tfc.exceptions.UserAlreadyExistsException;
import com.tfc.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LoginService {

    private static final long INITIAL_POINTS = 1000;

    private final UserRepository repository;

    public GameUser registerNewUser(UserLoginDto newUser) throws UserAlreadyExistsException {

        if (repository.existsByUsername(newUser.getUsername())) {
            throw new UserAlreadyExistsException("There is an account with that username: " + newUser.getEmail());
        }

        if (repository.existsByEmail(newUser.getEmail())) {
            throw new UserAlreadyExistsException("There is an account with that email: " + newUser.getEmail());
        }

        return repository.save(mapToUser(newUser));
    }

    public GameUser mapToUser(UserLoginDto userLogin) {

        return GameUser.builder()
                .username(userLogin.getUsername())
                .email(userLogin.getEmail())
                .password(userLogin.getPassword())
                .points(INITIAL_POINTS)
                .role(RoleEnum.ROLE_USER)
                .build();
    }
}
