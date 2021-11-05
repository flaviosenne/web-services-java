package com.ms.email.services;

import com.ms.email.enums.StatusEmail;
import com.ms.email.models.EmailModel;
import com.ms.email.repositories.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailService {

    private final EmailRepository repository;
    private final JavaMailSender mailSender;

    public EmailModel sendEmail(EmailModel model) {
        model.setSendDateEmail(LocalDateTime.now());

        try{

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(model.getEmailFrom());
            message.setTo(model.getEmailTo());
            message.setSubject(model.getSubject());
            message.setText(model.getText());
            mailSender.send(message);

            model.setStatusEmail(StatusEmail.SENT);



        }catch (MailException e){
            model.setStatusEmail(StatusEmail.ERROR);
        }finally {
            return repository.save(model);
        }
    }
}
