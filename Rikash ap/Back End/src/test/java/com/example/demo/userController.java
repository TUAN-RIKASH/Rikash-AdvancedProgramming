package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.users;
import com.example.demo.repository.usersRepo;

@SpringBootTest
public class userController {
 @Autowired
 usersRepo usersRepo;
 
 @Test
	public void testUserSave() {
		users users = new users();
		users.setId(3L);
		users.setName("Test");
		users.setAddress("Test Address");
		users.setMobile("Mobile");
		users.setPassword("Test");
		usersRepo.save(users);
		assertNotNull(usersRepo.findById(3L).get());
	}

	@Test
	public void testReadAllUser() {
		List<users> list1 = usersRepo.findAll();
		assertThat(list1).size().isGreaterThan(0);
	}

	@Test
	public void testUpdateUser() {
		users users = usersRepo.findById(2L).get();
		users.setAddress("Test Address0");
		usersRepo.save(users);
		assertNotEquals("Keyboard", usersRepo.findById(2L).get().getAddress());
	}

	@Test
	public void testDelete() {
		usersRepo.deleteById(1L);
		assertThat(usersRepo.existsById(1L)).isFalse();
	}
 
 
}
