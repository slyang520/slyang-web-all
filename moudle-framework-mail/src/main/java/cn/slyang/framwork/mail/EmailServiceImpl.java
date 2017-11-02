package cn.slyang.framwork.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	MailProperties mailProperties;

	@Override
	public void sendSimpleMail(String sendTo, String titel, String content) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mailProperties.getUsername());
		message.setTo(sendTo);
		message.setSubject(titel);
		message.setText(content);
		mailSender.send(message);

	}

}