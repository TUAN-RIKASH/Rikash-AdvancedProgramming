package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.appoinment;
import com.example.demo.repository.appoinmentRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/appoinment/")
public class appoinmentcontroller {
	@Autowired
	private appoinmentRepo appoinmentRepo;
	
	// create users rest api
		@PostMapping("/saveappoinment")
		public appoinment createUsers(@RequestBody appoinment appoinment) {
			return appoinmentRepo.save(appoinment);
		}

		// get all Users rest api
		@GetMapping("/getappoinment")
		private List<appoinment> getAllConsult() {
			return appoinmentRepo.findAll();
		}
		
		// delete User rest api
		@DeleteMapping("/getappoinment/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteConsult(@PathVariable Long id) {
			appoinment appoinment = appoinmentRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("appoinment not exist with id : " + id));

			appoinmentRepo.delete(appoinment);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
		 @PostMapping("/consultant-name/{name}")
		    public List<appoinment> filterByCounsultName(@PathVariable String name) {
		        //String CName = requestBody.get("c_name");
		        return appoinmentRepo.findByCounsultName(name);
		    }
}
