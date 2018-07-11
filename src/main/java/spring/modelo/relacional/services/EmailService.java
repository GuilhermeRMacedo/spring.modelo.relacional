package spring.modelo.relacional.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import spring.modelo.relacional.domain.Pedido;

public interface EmailService {
	void sendOrderConfirmationEmail(Pedido obj);		//abstractMailService

	void sendEmail(SimpleMailMessage msg);				//Mock&Smtp

	void sendOrderConfirmationHtmlEmail(Pedido obj);	//abstractMailService	

	void sendHtmlEmail(MimeMessage msg);				//Mock&Smtp
}
