package org.spring.hostel_management_system.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String email, String subject, String body) {

        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("devinaagrawal@02@gmail.com");
        message.setTo(email);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);


    }
}
