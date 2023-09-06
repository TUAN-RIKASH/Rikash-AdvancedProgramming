package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.consult;
import com.example.demo.repository.consultRepo;
@SpringBootTest
public class consultantaController {
	@Autowired
	consultRepo consultRepo;

	@Test
	public void testConsultSave() {
		consult consult0 = new consult();
		consult0.setId(3L);
		consult0.setName("rikash");
		consult0.setEmail("rikash@gmail.com");
		consult0.setNic("NIC");
		consult0.setStart_time("7.00");
		consult0.setEnd_time("8.00");
		consult0.setPassword("rikash123");
		consultRepo.save(consult0);
		assertNotNull(consultRepo.findById(3L).get());
	}

	@Test
	public void testReadAllConsult() {
		List<consult> list1 = consultRepo.findAll();
		assertThat(list1).size().isGreaterThan(0);
	}

	@Test
	public void testUpdateConsult() {
		consult consult0 = consultRepo.findById(2L).get();
		consult0.setEmail("Test0123@gmail.com");
		consultRepo.save(consult0);
		assertNotEquals("Keyboard", consultRepo.findById(2L).get().getEmail());
	}

	@Test
	public void testDelete() {
		consultRepo.deleteById(1L);
		assertThat(consultRepo.existsById(1L)).isFalse();
	}
}
