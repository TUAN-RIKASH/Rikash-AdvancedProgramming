package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appoinment")
public class appoinment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@Column(name = "c_name")
	private String c_name;

	@Column(name = "u_name")
	private String u_name;

	@Column(name = "book_date")
	private String book_date;

	@Column(name = "time")
	private String time;

	@Column(name = "contact")
	private String contact;

	public appoinment(long id, String c_name, String u_name, String book_date, String time, String contact) {
		super();
		Id = id;
		this.c_name = c_name;
		this.u_name = u_name;
		this.book_date = book_date;
		this.time = time;
		this.contact = contact;
	}
	
	public appoinment() {
		
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getBook_date() {
		return book_date;
	}

	public void setBook_date(String book_date) {
		this.book_date = book_date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
