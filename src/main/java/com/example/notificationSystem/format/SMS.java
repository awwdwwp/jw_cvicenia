package com.example.notificationSystem.format;

import org.springframework.stereotype.Component;

@Component("sms")
public class SMS implements MessageFormatter {
    @Override
    public String format(String message) {
        return "" + message + "";
    }
}
