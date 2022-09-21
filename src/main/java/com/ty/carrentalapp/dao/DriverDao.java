package com.ty.carrentalapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.carrentalapp.dto.Driver;
import com.ty.carrentalapp.repository.DriverRespository;

@Repository
public class DriverDao {

	@Autowired
	private DriverRespository driverRepository;

	public Driver saveDriver(Driver driver) {
		return driverRepository.save(driver);
	}

	public Driver findDriverById(int id) {
		Optional<Driver> opt = driverRepository.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public List<Driver> getAllDrivers() {
		return driverRepository.findAll();
	}

	public boolean deleteDriverById(int id) {
		Optional<Driver> opt = driverRepository.findById(id);
		if (opt != null) {
			driverRepository.delete(opt.get());
			return true;
		} else {
			return false;
		}
	}

	public Driver findDriverByDrivingLicense(String license) {
		return driverRepository.findByDrivingLicense(license);
	}

	public Driver updateDriver(Driver driver) {
		Optional<Driver> opt = driverRepository.findById(driver.getId());
		if (opt != null) {
			return driverRepository.save(driver);
		}

		return null;
	}

}
