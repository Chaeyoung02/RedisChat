package com.test.chat.user.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserEntity {

    private int userNo;
    private String userName;
    private String userId;
    private String userPw;
    private LocalDateTime userCreateAt;
    private LocalDateTime userUpdateAt;


}
