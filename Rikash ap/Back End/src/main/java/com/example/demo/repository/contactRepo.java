package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.contact;

public interface contactRepo extends JpaRepository<contact, Long>{

}
