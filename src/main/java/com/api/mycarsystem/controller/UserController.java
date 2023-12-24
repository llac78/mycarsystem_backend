package com.api.mycarsystem.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		List<User> lista = userRepository.findAll();
		for (User user : lista) {
			System.out.println(user.toString());
		}
		return lista;
	}
	
	//TODO validações
	@PostMapping("/users") 
	public User createUser(@Validated @RequestBody User user) {
		
        return userRepository.save(user);
    }
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) throws ResourceNotFoundException {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
        return ResponseEntity.ok(user);
    }
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUserById(@PathVariable Long id) throws ResourceNotFoundException {
	
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		
		userRepository.delete(user);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
    }

	@PutMapping("/users/{id}") 
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userData) throws ResourceNotFoundException {
		
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		
		user.setFirstName(userData.getFirstName());
		user.setLastName(userData.getLastName());
		user.setBirthday(userData.getBirthday());
		user.setEmail(userData.getEmail());
		user.setLogin(userData.getLogin());
		user.setPassword(userData.getPassword());
		user.setPhone(userData.getPhone());
		
		userRepository.save(user);
		
        return ResponseEntity.ok(user);
    }

}
