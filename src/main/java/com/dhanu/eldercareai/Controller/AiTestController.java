package com.dhanu.eldercareai.Controller;

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
}
