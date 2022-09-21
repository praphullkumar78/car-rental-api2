package com.ty.carrentalapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.carrentalapp.dto.Car;

public interface CarRepository extends  JpaRepository<Car, Integer>{
	

	

	List<Car> findByAvailability(int availability);
	
//	@Query("select c from car c where c.availability = :availability and c.carType = :carType")
	List<Car> findByAvailabilityAndCarType(int availability, String carType);

}
