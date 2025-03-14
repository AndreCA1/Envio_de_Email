package com.andre.envio_email.service;


import com.andre.envio_email.dtos.EmailDto;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void enviaEmail(EmailDto emailDto){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("noreplay@gmail.com");
            helper.setTo(emailDto.destinatario());
            helper.setSubject(emailDto.assunto());
            helper.setText(emailDto.texto());

            String template = carregaTemplateEmail();
            template = template.replace("{{remetente}}", "noreplay@gmail.com");
            template = template.replace("{{assunto}}",emailDto.assunto());
            template = template.replace("{{mensagem}}",emailDto.texto());
            helper.setText(template, true);

            javaMailSender.send(message);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String carregaTemplateEmail()throws IOException{
        ClassPathResource resource = new ClassPathResource("templates/email_template.html");
        return new String (resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
