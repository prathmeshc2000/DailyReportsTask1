package com.cedge.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ADB {

	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "Message")
	private String message;
	
	@Column(name = "Bank")
	private String bank;
	
	@Column(name = "Date")
	private LocalDate date;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ADB [id=" + id + ", message=" + message + ", bank=" + bank + ", date=" + date + "]";
	}
	
	

}
