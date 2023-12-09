package com.samar.bootcamp;

import org.springframework.stereotype.Component;

@Component
public class Whatsapp implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Whatsapp message is: " + message);
    }
}
