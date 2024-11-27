package com.test.chat.user.service;

import com.test.chat.mapper.UserMapper;
import com.test.chat.user.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    public int signUp(UserEntity userEntity){
        int result = 0;
        try{
            result = userMapper.insertUser(userEntity);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public int selectUserInfo(String userId, String userPw){
        int result = 0;
        try {
            result = userMapper.selectUserInfo(userId, userPw);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
