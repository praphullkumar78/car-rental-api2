package com.ty.carrentalapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.carrentalapp.dto.Car;
import com.ty.carrentalapp.repository.CarRepository;

@Repository
public class CarDao {

	@Autowired
	private CarRepository carRepository;

	public Car saveCar(Car car) {
		return carRepository.save(car);
	}

	public Car getCarById(int id) {
		Optional<Car> optional = carRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

	public boolean deleteCarById(int id) {
		Car car = getCarById(id);
		if (car != null) {
			carRepository.delete(car);
			return true;
		} else {
			return false;
		}
	}

	public Car updateCar(Car car) { 
		if (getCarById(car.getId()) != null) {
			
			return saveCar(car);
		}
		return null;
	}


	// changed availability convention we should pass boolean
	public List<Car> getAvailableCars(int availability) {
		return carRepository.findByAvailability(availability);
	}

	public List<Car> getCarsByType(int availability, String type) {
		return carRepository.findByAvailabilityAndCarType(availability,type);
	}

}
