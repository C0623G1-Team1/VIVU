package com.tourbooking.service.booking.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail,
                          String subject,
                          String body){
        MimeMessage message = mailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, multipart);
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(body);
            String path1 = "E:\\Case_Module_4\\VIVU\\src\\main\\resources\\static\\TICKET.txt";
            FileSystemResource file1 = new FileSystemResource(new File(path1));
            helper.addAttachment("VIVU TICKET", file1);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
