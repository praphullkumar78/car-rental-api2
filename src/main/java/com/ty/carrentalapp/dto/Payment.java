package com.ty.carrentalapp.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Mention the Payment Mode")
	private String mode;
	@NotNull(message = "provide the date time")
	private LocalDateTime dateTime;
	@NotNull(message = "Enter the amount for rent")
	private double rentCost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public LocalDateTime getDataTime() {
		return dateTime;
	}
	public void setDataTime(LocalDateTime dataTime) {
		this.dateTime = dataTime;
	}
	public double getRentCost() {
		return rentCost;
	}
	public void setRentCost(double rentCost) {
		this.rentCost = rentCost;
	}
	
	

}
