package com.ty.carrentalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.carrentalapp.dao.CarDao;
import com.ty.carrentalapp.dto.Car;
import com.ty.carrentalapp.dto.ResposneStructure;
import com.ty.carrentalapp.exception.NoIdFoundException;

@Service
public class CarService {

	@Autowired
	private CarDao carDao;

	static ResposneStructure<Car> responseStructure = new ResposneStructure<Car>();
	static ResponseEntity<ResposneStructure<Car>> resp;

	public ResponseEntity<ResposneStructure<Car>> saveCar(Car car) {
		responseStructure.setMessage("success");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(carDao.saveCar(car));
		return new ResponseEntity<ResposneStructure<Car>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResposneStructure<Car>> getCarById(int id) {
		Car car = carDao.getCarById(id);
		if (car != null) {
			responseStructure.setMessage("success");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(carDao.saveCar(car));
			return new ResponseEntity<ResposneStructure<Car>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException();
		}
	}

	public ResponseEntity<ResposneStructure<List<Car>>> getAllCars() {
		ResposneStructure<List<Car>> responseStructure = new ResposneStructure<List<Car>>();
		List<Car> cars = carDao.getAllCars();
		if (cars != null) {
			responseStructure.setMessage("success");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(cars);
			return new ResponseEntity<ResposneStructure<List<Car>>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("data not found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResposneStructure<List<Car>>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResposneStructure<Car>> deleteCarById(int id) {
		if (carDao.deleteCarById(id)) {
			responseStructure.setMessage("deleted the data");
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResposneStructure<Car>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException();
		}
	}

	public ResponseEntity<ResposneStructure<Car>> updateCarById(Car car) {
		car = carDao.updateCar(car);
		if (car != null) {
			responseStructure.setMessage("updated the data");
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResposneStructure<Car>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("data not found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResposneStructure<Car>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}


	public ResponseEntity<ResposneStructure<List<Car>>> getAvailableCars(int availability) {
		ResposneStructure<List<Car>> responseStructure = new ResposneStructure<List<Car>>();
		List<Car> cars = carDao.getAvailableCars(availability);
		if (cars != null) {
			responseStructure.setMessage("success");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(cars);
			return new ResponseEntity<ResposneStructure<List<Car>>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("data not found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResposneStructure<List<Car>>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResposneStructure<List<Car>>> getCarsByType(int availability, String type) {
		ResposneStructure<List<Car>> responseStructure = new ResposneStructure<List<Car>>();
		List<Car> cars = carDao.getCarsByType(availability, type);
		if (cars != null) {
			responseStructure.setMessage("success");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(cars);
			return new ResponseEntity<ResposneStructure<List<Car>>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("data not found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResposneStructure<List<Car>>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

}
