package com.test.chat.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {

    @GetMapping("/user/signUp")
    public String showSignUpPage() {
        return "signUp";
    }

    @GetMapping("/user/login")
    public String showLoginPage() {
        return "login";
    }
}
