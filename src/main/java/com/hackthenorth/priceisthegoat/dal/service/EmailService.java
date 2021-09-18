package com.hackthenorth.priceisthegoat.dal.service;

import com.hackthenorth.priceisthegoat.dal.models.ConfirmationToken;
import com.hackthenorth.priceisthegoat.dal.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    public void sendConfirmationEmail(final User user) {
        final ConfirmationToken token = new ConfirmationToken(user);

        final String content = String.format("To confirm your email click here : http://localhost:8080/confirm-account?token=%s", token.getConfirmationToken());
        getSimpleMailMessage(user.getEmail(), content);
    }

    private void getSimpleMailMessage(final String recipient, final String content) {
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipient);
        email.setSubject("Email Confirmation");
        email.setFrom("sc2021jf@gmail.com");
        email.setText(content);
        mailSender.send(email);
    }
}
