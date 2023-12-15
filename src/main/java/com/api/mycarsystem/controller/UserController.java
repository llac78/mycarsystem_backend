package com.api.mycarsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mycarsystem.exception.ResourceNotFoundException;
import com.api.mycarsystem.model.User;
import com.api.mycarsystem.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//TODO validações
	@PostMapping("/users") 
	public User createUser(@Validated @RequestBody User user) {
        return userRepository.save(user);
    }
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUserById(@PathVariable Long id) {
		userRepository.deleteById(id);
		return ResponseEntity.ok().build();
    }

	@PostMapping("/users/{id}") 
	public User updateUser(@Validated @RequestBody User user) {
        return userRepository.save(user);
    }

	@PutMapping("/users/{id}")
    public ResponseEntity < User > updateUser(@PathVariable(value = "id") Long userId,
        @Validated @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }
	
}
