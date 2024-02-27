package com.doksakura.doksakuramail;

import com.doksakura.doksakuramail.model.EmailMessage;
import com.doksakura.doksakuramail.service.MailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

@SpringBootApplication
public class DoksakuraMailApplication {
    @Autowired
    MailService mailService;

    public static void main(String[] args) {
        SpringApplication.run(DoksakuraMailApplication.class, args);
    }

    @KafkaListener(topics = "doksakura-mail", groupId = "mail-service1")
    public void consume(String message) {
        Gson gson = new Gson();
        EmailMessage emailMessage = gson.fromJson(message, EmailMessage.class);
        mailService.sendMailOtp(emailMessage);
    }
}
