package com.tfc.controllers;

import com.tfc.dto.UserLoginDto;
import com.tfc.dto.UserRegisterDto;
import com.tfc.entities.GameUser;
import com.tfc.exceptions.UserAlreadyExistsException;
import com.tfc.services.LoginService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/register")
    public ModelAndView register(Map<String, Object> model) {

        return new ModelAndView("register", model);
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute("user") @Valid UserRegisterDto newUser) throws UserAlreadyExistsException {

        GameUser registered = loginService.register(newUser);

        return new ModelAndView("register", Map.of("username", registered.getUsername()));
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@ModelAttribute("user") @Valid UserLoginDto user) {
        var authentication = loginService.login(user);

        if (!authentication.isAuthenticated()) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("error", "Invalid username or password.");
            return modelAndView;
        }

        return new ModelAndView("redirect:/");
    }
}
