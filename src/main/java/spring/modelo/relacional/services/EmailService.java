package spring.modelo.relacional.services;

import org.springframework.mail.SimpleMailMessage;

import spring.modelo.relacional.domain.Pedido;

public interface EmailService {
	void sendOrderConfirmationMail(Pedido obj);

	void sendMail(SimpleMailMessage msg);
}