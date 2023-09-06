package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.contact;
import com.example.demo.repository.contactRepo;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/contact/")
public class contactController {

	@Autowired
	private contactRepo contactRepo;

	// create users rest api
	@PostMapping("/savecontact")
	public contact createContact(@RequestBody contact contact) {
		return contactRepo.save(contact);
	}

	// get all Users rest api
	@GetMapping("/getContact")
	private List<contact> getAllContact() {
		return contactRepo.findAll();
	}
}
