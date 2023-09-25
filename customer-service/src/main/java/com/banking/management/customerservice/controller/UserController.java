package com.banking.management.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.management.customerservice.entity.UserDetail;
import com.banking.management.customerservice.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/health")
	public String health() {
		return "Customer service is up";
	}
	
	@GetMapping("/users")
	public List<UserDetail> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/user/{userId}")
	public UserDetail getUser(@PathVariable Long userId) {
		return userRepository.findById(userId).get();
	}
	
	@PostMapping("/user/register")
	public ResponseEntity<UserDetail> registerUser(@RequestBody UserDetail userDetail){
		userRepository.save(userDetail);
		return new ResponseEntity<UserDetail>(userDetail, HttpStatus.CREATED);
	}
	
	@PutMapping("/user/{userId}/update")
	public ResponseEntity<UserDetail> updateUser(@PathVariable Long userId, @RequestBody UserDetail updatedUser){
		UserDetail existingUser = userRepository.findById(userId).get();
		existingUser.setAccount(updatedUser.getAccount());
		existingUser.setAddress(updatedUser.getAddress());
		existingUser.setContactNumber(updatedUser.getContactNumber());
		existingUser.setCountry(updatedUser.getCountry());
		existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
		existingUser.setEmail(updatedUser.getEmail());
		existingUser.setFirstName(updatedUser.getFirstName());
		existingUser.setLastName(updatedUser.getLastName());
		existingUser.setPanNumber(updatedUser.getPanNumber());
		existingUser.setPassword(updatedUser.getPassword());
		existingUser.setState(updatedUser.getState());
		existingUser.setUserName(updatedUser.getUserName());
		userRepository.save(existingUser);
		return new ResponseEntity<UserDetail>(existingUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/user/{userId}/delete")
	public ResponseEntity deleteUser(@PathVariable Long userId){
		userRepository.deleteById(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
