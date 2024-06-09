package com.tfc.services;

import com.tfc.dto.UserLoginDto;
import com.tfc.dto.UserRegisterDto;
import com.tfc.entities.GameUser;
import com.tfc.enums.RoleEnum;
import com.tfc.exceptions.UserAlreadyExistsException;
import com.tfc.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LoginService {

    private static final long INITIAL_POINTS = 1000;

    private final UserRepository repository;
    private final AuthenticationManager authenticationManager;

    public GameUser register(UserRegisterDto newUser) throws UserAlreadyExistsException {

        if (repository.existsByUsername(newUser.getUsername())) {
            throw new UserAlreadyExistsException("There is an account with that username: " + newUser.getEmail());
        }

        if (repository.existsByEmail(newUser.getEmail())) {
            throw new UserAlreadyExistsException("There is an account with that email: " + newUser.getEmail());
        }

        return repository.save(mapToUser(newUser));
    }

    public GameUser mapToUser(UserRegisterDto userLogin) {

        return GameUser.builder()
                .username(userLogin.getUsername())
                .email(userLogin.getEmail())
                .password(userLogin.getPassword())
                .points(INITIAL_POINTS)
                .role(RoleEnum.USER)
                .build();
    }

    public Authentication login(UserLoginDto user) {
        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(user.username(), user.password());

        var authentication = this.authenticationManager.authenticate(authenticationRequest);

        final SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

        return authentication;
    }
}
