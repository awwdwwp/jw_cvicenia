package com.example.notificationSystem;

import com.example.notificationSystem.format.MessageFormatter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("pushNotification")
public class PushNotification implements NotificationService {

    private final MessageFormatter messageFormatter;

    public PushNotification(@Qualifier("push") MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }

    @Override
    public String send(String message) {
        String formattedMessage = messageFormatter.format(message);
        return "Posielam PUSH notifikáciu: " + formattedMessage;
    }
}
