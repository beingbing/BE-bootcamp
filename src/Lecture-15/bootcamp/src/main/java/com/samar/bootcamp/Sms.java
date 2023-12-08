package com.samar.bootcamp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Sms implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sms message is: " + message);
    }
}
