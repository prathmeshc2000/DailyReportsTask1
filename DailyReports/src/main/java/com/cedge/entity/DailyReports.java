package com.cedge.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DailyReports {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bank;
    private Integer successful;
    private Integer unsuccessful;
    private LocalDate date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public Integer getSuccessful() {
		return successful;
	}
	public void setSuccessful(Integer successful) {
		this.successful = successful;
	}
	public Integer getUnsuccessful() {
		return unsuccessful;
	}
	public void setUnsuccessful(Integer unsuccessful) {
		this.unsuccessful = unsuccessful;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "DailyReports [id=" + id + ", bank=" + bank + ", successful=" + successful + ", unsuccessful="
				+ unsuccessful + ", date=" + date + "]";
	}
	
    

}
