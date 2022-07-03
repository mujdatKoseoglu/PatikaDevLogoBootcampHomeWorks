package com.logo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.logo.Dto.EmailDto;
import com.logo.Repository.CustomerRepository;
import com.logo.Repository.UserRepository;
import com.logo.model.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logo.model.Customer;
import com.logo.model.User;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RabbitMQService rabbitMQService;

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Autowired
	private CustomerRepository customerRepository;

	public User createUser(User user) {
		rabbitTemplate.convertAndSend("isbasi.email", new EmailDto("mujdat@gmail.com","Email","tamamdır"));
		userRepository.save(user);
		customerRepository.saveAll(user.getCustomerList());
		return user;

	}

	public void deleteUserById(int id) {

		/*
		 * deleteById metodu da olabilir.
		 */
		User foundUser = userRepository.findById(id).orElseThrow(RuntimeException::new);

		userRepository.delete(foundUser);

		//userRepository.deleteAll();

		//userRepository.deleteById(id);
	}

	public void deleteUserByEmail(String email) {

		Optional<User> foundUser = userRepository.findByEmail(email);
		if (!foundUser.isPresent()) {
			log.info("user not found");
		}

		userRepository.delete(foundUser.get());

	}

	public User updateUser(User user) {

		String sql = "Update User set email = yeniemail where id =1";

		User foundUser = userRepository.findById(user.getId()).get();

		foundUser.setEmail(user.getEmail());
		foundUser.setSurname(user.getSurname());

		return userRepository.save(foundUser);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserByEmail(String email) {
		/*
		 * kullanıcı bulunamadığında hata verilmeli. Aşağıdaki iki kullanım da olabilir.
		 * Kendi Exception classımızı oluşturmamız gerek
		 */

		// userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException());

		// userRepository.findByEmail(email).orElseThrow(RuntimeException::new);

		Optional<User> foundUser = userRepository.findByEmail(email);

		boolean isPresent = foundUser.isPresent();
		if (isPresent) {
			return foundUser.get();
		}
		// null dönme!
		return null;

	}

	public List<Customer> getCustomersByEmail(String email) {
		User foundUser = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException());

		return foundUser.getCustomerList();
	}}