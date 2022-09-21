package com.ty.carrentalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.carrentalapp.dto.Driver;

public interface DriverRespository extends JpaRepository<Driver, Integer> {

	
	Driver findByDrivingLicense(String drivingLicense);
}
