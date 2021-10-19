package com.valbersouza.cursojavaspringvr.services;

import com.valbersouza.cursojavaspringvr.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMailMessage msg);
}
