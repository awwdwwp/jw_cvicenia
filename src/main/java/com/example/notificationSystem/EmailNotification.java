package com.example.notificationSystem;

import com.example.notificationSystem.NotificationService;
import com.example.notificationSystem.format.MessageFormatter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Component
@Component("emailNotification")
public class EmailNotification implements NotificationService {

    private final MessageFormatter messageFormatter;

    public EmailNotification(@Qualifier("html") MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }

    @Override
    public String send(String message) {
        String formattedMessage = messageFormatter.format(message);
        return "Posielam notifikáciu e-mailom: " + formattedMessage;
    }
}