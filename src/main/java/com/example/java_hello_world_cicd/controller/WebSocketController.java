package com.example.java_hello_world_cicd.controller;

import com.example.java_hello_world_cicd.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

  @MessageMapping("/chat.sendMessage")
  @SendTo("/topic/publicChatRoom")
  public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
    System.out.println("Sending message: " + chatMessage.getContent());
    return chatMessage;
  }

  @MessageMapping("/chat.addUser")
  @SendTo("/topic/publicChatRoom")
  public ChatMessage addUser(
    @Payload ChatMessage chatMessage,
    SimpMessageHeaderAccessor headerAccessor
  ) {
    headerAccessor
      .getSessionAttributes()
      .put("username", chatMessage.getSender());
    return chatMessage;
  }
}
