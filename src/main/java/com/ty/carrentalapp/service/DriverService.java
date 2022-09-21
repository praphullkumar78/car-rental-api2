package com.ty.carrentalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.carrentalapp.dao.DriverDao;
import com.ty.carrentalapp.dto.Driver;
import com.ty.carrentalapp.dto.ResposneStructure;
import com.ty.carrentalapp.exception.NoIdFoundException;

@Service
public class DriverService {

	@Autowired
	private DriverDao driverDao;

	public ResponseEntity<ResposneStructure<Driver>> saveDriver(Driver driver) {

		ResposneStructure<Driver> structure = new ResposneStructure<>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(driverDao.saveDriver(driver));

		return new ResponseEntity<ResposneStructure<Driver>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResposneStructure<Driver>> findDriverById(int id) {

		Driver driver = driverDao.findDriverById(id);
		ResposneStructure<Driver> structure = new ResposneStructure<>();
		if (driver != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(driver);
			return new ResponseEntity<ResposneStructure<Driver>>(structure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("Given id : " + id + " NOT FOUND");
		}
	}

	public ResponseEntity<ResposneStructure<List<Driver>>> getAllDrivers() {
		List<Driver> list = driverDao.getAllDrivers();

		ResposneStructure<List<Driver>> structure = new ResposneStructure<>();
		if (list != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(list);
			return new ResponseEntity<ResposneStructure<List<Driver>>>(structure, HttpStatus.OK);

		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("List Not Found");
			structure.setData(list);
			return new ResponseEntity<ResposneStructure<List<Driver>>>(structure, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResposneStructure<String>> deleteDriverById(int id) {
		ResposneStructure<String> structure = new ResposneStructure<>();
		ResponseEntity<ResposneStructure<String>> resp;
		if (driverDao.deleteDriverById(id)) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("SUCCESS");
			structure.setData("Driver Deleted");
			resp = new ResponseEntity<ResposneStructure<String>>(structure, HttpStatus.OK);
		} else {

			throw new NoIdFoundException("Can't delete with id " + id);
		}
		return resp;

	}
	
	public ResponseEntity<ResposneStructure<Driver>> findDriverByDrivingLicense(String license) {
		
		Driver driver = driverDao.findDriverByDrivingLicense(license);
		ResposneStructure<Driver> structure = new ResposneStructure<>();
		if(driver != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(driver);
			return new ResponseEntity<ResposneStructure<Driver>>(structure,HttpStatus.OK);
		}else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Not Found");
			structure.setData(driver);
			return new ResponseEntity<ResposneStructure<Driver>>(structure,HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResposneStructure<Driver>> updateDriver(Driver driver) {
		
		Driver drive = driverDao.updateDriver(driver);
		ResposneStructure<Driver> structure = new ResposneStructure<>();
		if(drive != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(drive);
			return new ResponseEntity<>(structure,HttpStatus.OK);
		}else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Not Found");
			structure.setData(drive);
			return new ResponseEntity<>(structure,HttpStatus.NOT_FOUND);
		}
	}

}
