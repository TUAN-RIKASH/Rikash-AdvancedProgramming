package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.users;
import com.example.demo.repository.usersRepo;
import com.example.demo.response.response;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users/")
public class userscontroller {

	@Autowired
	private usersRepo usersRepository;

	// create users rest api
	@PostMapping("/saveusers")
	public users createUsers(@RequestBody users users) {
		return usersRepository.save(users);
	}

	// get all Users rest api
	@GetMapping("/getusers")
	private List<users> getAllUsers() {
		return usersRepository.findAll();
	}

	// get User by Id rest api
	@GetMapping("/getusers/{id}")
	public ResponseEntity<users> getUsersById(@PathVariable Long id) {
		users users = usersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id : " + id));
		return ResponseEntity.ok(users);
	}

	// update User rest api
	@PutMapping("/getusers/{id}")
	public ResponseEntity<users> updateUsers(@PathVariable Long id, @RequestBody users dusers) {
		users users = usersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id : " + id));
		users.setName(dusers.getName());
		users.setAddress(dusers.getAddress());
		users.setMobile(dusers.getMobile());
		users.setPassword(dusers.getPassword());

		users updateUsers = usersRepository.save(users);
		return ResponseEntity.ok(updateUsers);
	}

	// delete User rest api
	@DeleteMapping("/getusers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
		users users = usersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id : " + id));

		usersRepository.delete(users);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	//Users Login
	 @PostMapping("/login")
	    public ResponseEntity<Object> login(@RequestBody users loginForm) {
	        String name = loginForm.getName();
	        String password = loginForm.getPassword();

	        users user = usersRepository.findByEmailAndPassword(name, password);
	        if (user != null) {
	            // User authenticated successfully
	        	return response.responseBuilder("User Login Successfully.", HttpStatus.OK, usersRepository.findByEmailAndPassword(name, password));
	        	
	        } else {
	            // Invalid credentials
	        	Map<String, String> errorResponse = new HashMap<>();
	            errorResponse.put("message", "Request User Not Found");
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
	        }
	    }
	
	
}
