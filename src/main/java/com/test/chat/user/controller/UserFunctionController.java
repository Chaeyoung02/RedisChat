package com.test.chat.user.controller;

import com.test.chat.user.domain.UserEntity;
import com.test.chat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

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
    @ResponseBody // JSON 응답을 반환하기 위해 추가
    public Map<String, Object> login(@RequestBody Map<String, String> userInfo) {
        String userId = userInfo.get("userId");
        String userPw = userInfo.get("userPw");

        int loginResult = userService.selectUserInfo(userId, userPw);
        System.out.println(loginResult);
        Map<String, Object> response = new HashMap<>();
        if (loginResult > 0) {
            response.put("success", true); // 로그인 성공
        } else {
            response.put("success", false); // 로그인 실패
        }

        return response;
    }
}
