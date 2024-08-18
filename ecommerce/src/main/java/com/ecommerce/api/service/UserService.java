package com.ecommerce.api.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.api.model.User;
import com.ecommerce.api.model.UserResponse;
import com.ecommerce.api.repository.UserRepository;
import com.ecommerce.api.repository.UserResponseRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserResponseRepository responseRepository;

	public ResponseEntity<UserResponse> registerUser(User user) {

		UserResponse response = new UserResponse();

		User savedDetails = repository.save(user);
		response.setCompanyName(savedDetails.getCompanyName());
		response.setClientID(UUID.randomUUID().toString());
		response.setClientSecret(generateSecret());
		response.setOwnerName(savedDetails.getOwnerName());
		response.setOwnerEmail(savedDetails.getOwnerEmail());
		response.setRollNo(savedDetails.getRollNo());

		responseRepository.save(response);

		return new ResponseEntity<UserResponse>(response, HttpStatus.CREATED);
	}

	private String generateSecret() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder secretKey = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 17; i++) {
			secretKey.append(alphabet.charAt(random.nextInt(alphabet.length())));
		}
		return secretKey.toString();
	}
}
