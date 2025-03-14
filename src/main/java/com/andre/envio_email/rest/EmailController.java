package com.andre.envio_email.rest;

import com.andre.envio_email.dtos.EmailDto;
import com.andre.envio_email.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emails")
@CrossOrigin(origins = "*")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> enviarEmail(@RequestBody EmailDto emailDto){
        emailService.enviaEmail(emailDto);
        return ResponseEntity.ok("E-mail enviado com sucesso!");
    }
}
