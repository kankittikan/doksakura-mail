package com.doksakura.doksakuramail.service;

import com.doksakura.doksakuramail.model.EmailMessage;
import jakarta.mail.internet.InternetAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendMailOtp(EmailMessage mail) throws MailException {
        MimeMessagePreparator preparator = (mimeMessage) -> {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(new InternetAddress("contact@doksakura.com", mail.getPersonal()));
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getHeader());

            helper.setText(mail.getHtml(), true);
        };
        mailSender.send(preparator);
    }
}