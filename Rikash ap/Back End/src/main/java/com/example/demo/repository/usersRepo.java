package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.users;

public interface usersRepo extends JpaRepository<users, Long >{
	 @Query(value = "SELECT * FROM users WHERE name = :name AND password = :password", nativeQuery = true)
	    users findByEmailAndPassword(@Param("name") String name, @Param("password") String password);
}
