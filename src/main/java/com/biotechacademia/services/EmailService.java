package com.biotechacademia.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.biotechacademia.domain.Cliente;
import com.biotechacademia.domain.ItemLista;

public interface EmailService {
	
	void sendEmail(SimpleMailMessage msg);

	void sendOrderConfirmationEmail(ItemLista obj);

	void sendOrderConfirmationHtmlEmail(ItemLista obj);
	
	void sendHtmlEmail(MimeMessage msg);

	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
