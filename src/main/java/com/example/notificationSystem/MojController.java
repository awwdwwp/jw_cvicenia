package com.example.notificationSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MojController {

    private final NotificationService emailService;
    private final NotificationService smsService;

    @Autowired
    public MojController(
            @Qualifier("emailNotification") NotificationService emailService,
            @Qualifier("smsNotification") NotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    @GetMapping("/notify/email")
    public String sendEmailNotification() {
        return emailService.send("Používateľ sa prihlásil.");
    }

    @GetMapping("/notify/sms")
    public String sendSmsNotification() {
        return smsService.send("Používateľ sa prihlásil.");
    }
}