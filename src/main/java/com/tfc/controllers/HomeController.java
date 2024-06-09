package com.tfc.controllers;

import com.tfc.dto.UserRegisterDto;
import com.tfc.entities.GameUser;
import com.tfc.exceptions.UserAlreadyExistsException;
import com.tfc.services.LoginService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@AllArgsConstructor
@Controller
public class HomeController {

    private final LoginService loginService;

    @GetMapping
    public ModelAndView home(Map<String, Object> model, Authentication authentication) {

        if (authentication != null) {
            model.put("user", authentication.getName());
        }

        return new ModelAndView("index", model);
    }

    @GetMapping("/index")
    public ModelAndView index(Map<String, Object> model, Authentication authentication) {

        model.put("username", authentication.getName());
        return new ModelAndView("index", model);
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }


    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/shop")
    public String shop() {
        return "shop";
    }
}