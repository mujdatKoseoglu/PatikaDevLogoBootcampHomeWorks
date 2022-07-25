package com.email.Listener;

import com.email.Model.Email;
import com.email.Repository.EmailRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailListener {
	@Autowired
	private EmailRepository emailRepository;
	
	@RabbitListener(queues = "movie.emailmovie")
	public void emailListener(Email email) {
		log.info("email address: {}", email.getEmail());
		emailRepository.save(email);
	}

}
