package com.test.chat.mapper;

import com.test.chat.user.domain.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insertUser(UserEntity userEntity);
    int selectUserInfo(String userId, String userPw);
}
