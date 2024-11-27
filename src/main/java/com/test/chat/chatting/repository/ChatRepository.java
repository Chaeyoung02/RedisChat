package com.test.chat.chatting.repository;

import com.test.chat.chatting.domain.ChatMessageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends CrudRepository<ChatMessageEntity, String> {
}
