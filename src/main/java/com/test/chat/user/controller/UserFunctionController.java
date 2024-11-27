package com.test.chat.user.controller;

import com.test.chat.user.domain.UserEntity;
import com.test.chat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserFunctionController {
    private final UserService userService;

    @Autowired
    public UserFunctionController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/user/signUp")
    public String signUp(@ModelAttribute UserEntity userEntity, Model model){
        int isSignUp = userService.signUp(userEntity);

        if(isSignUp > 0){
            return "login";
        }else {
            return "signUp";
        }
    }

    @PostMapping("/user/login")
    public String login(@RequestParam String userId, @RequestParam String userPw, RedirectAttributes redirectAttributes){
        int login = userService.selectUserInfo(userId, userPw);
        if(login > 0){
            redirectAttributes.addAttribute("login", "success");
            return "chat";
        }else {
            redirectAttributes.addAttribute("login", "fail");
            return "signUp";
        }
    }
}
