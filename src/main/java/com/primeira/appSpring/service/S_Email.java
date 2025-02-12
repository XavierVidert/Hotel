package com.primeira.appSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class S_Email {
    @Autowired
    private JavaMailSender mailSender;

    public void enviaEmail(String to,String title, String mensagen){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(to);
        email.setSubject(title);
        email.setText(mensagen);

        mailSender.send(email);
    }
}
