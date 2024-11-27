package com.test.chat.chatting.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RedisHash("ChatMessage")  // Redis에서 저장될 때 이 이름으로 관리됩니다.
public class ChatMessageEntity {

    @Id
    private String id;  // Redis에서는 String 형태의 ID를 주로 사용합니다.
    private String sender;
    private String content;

    // 기본 생성자
    public ChatMessageEntity() {}

    // 생성자
    public ChatMessageEntity(String id, String sender, String content) {
        this.id = id;
        this.sender = sender;
        this.content = content;
    }
}
