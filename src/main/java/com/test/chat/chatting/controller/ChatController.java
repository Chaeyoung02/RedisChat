package com.test.chat.chatting.controller;

import com.test.chat.chatting.domain.ChatMessage;
import com.test.chat.chatting.repository.ChatRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChatRepository chatRepository;

    public ChatController(SimpMessagingTemplate simpMessagingTemplate, ChatRepository chatRepository){
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.chatRepository = chatRepository;
    }

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }

    @GetMapping("/chatPage")
    public String chat() {
        return "chat"; // chat.html 반환
    }
}
