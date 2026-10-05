package com.example.notificationSystem;

import com.example.notificationSystem.format.MessageFormatter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("smsNotification")
public class SMSNotification implements NotificationService {

    private final MessageFormatter messageFormatter;

    public SMSNotification(@Qualifier("sms") MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }

    @Override
    public String send(String message) {
        String formattedMessage = messageFormatter.format(message);
        return "Posielam notifikáciu SMS: " + formattedMessage;
    }
}
