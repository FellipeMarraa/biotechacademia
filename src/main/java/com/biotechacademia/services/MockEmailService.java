package com.biotechacademia.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import com.biotechacademia.domain.ItemLista;

public class MockEmailService extends AbstractEmailService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de email");
		LOG.info(msg.toString());
		LOG.info("Email enviado!");
		
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Simulando envio de email HTML");
		LOG.info(msg.toString());
		LOG.info("Email enviado!");
	}

	@Override
	public void sendOrderConfirmationEmail(ItemLista obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendOrderConfirmationHtmlEmail(ItemLista obj) {
		// TODO Auto-generated method stub
		
	}

}
