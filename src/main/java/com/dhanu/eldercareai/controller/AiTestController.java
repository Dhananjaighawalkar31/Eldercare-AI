package com.dhanu.eldercareai.controller;

import com.dhanu.eldercareai.model.SimpleAnswer;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiTestController {
    private final ChatClient chatClient;
    AiTestController(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }
    @GetMapping("/ai-test")
    public String aiTest(){
        return chatClient
                .prompt()
                .user("Say hello in one short sentence.")
                .call()
                .content();
    }
    @GetMapping("/ai-structured-test")
    public SimpleAnswer aiStructuredTest(){
        return chatClient
                .prompt()
                .user("A user just said: 'I passed my exam today!' What mood are they probably in, and why? Respond with mood and reason only.")
                .call()
                .entity(SimpleAnswer.class);
    }
}
