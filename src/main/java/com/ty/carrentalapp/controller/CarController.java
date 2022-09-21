package com.ty.carrentalapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.carrentalapp.dto.Car;
import com.ty.carrentalapp.dto.ResposneStructure;
import com.ty.carrentalapp.service.CarService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarService carService;

	@ApiOperation(value = "save car", notes = "input is car object and returns car object with id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully saved"),
			@ApiResponse(code = 404, message = "input mismatch") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Car>> saveCar(@RequestBody @Valid Car car) {
		return carService.saveCar(car);
	}

	@ApiOperation(value = "get car by id", notes = "input is car id and returns car object of that particular id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully retrieved data"),
			@ApiResponse(code = 404, message = "id not found") })
	@GetMapping(value = "/{id}",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Car>> getCarById(@PathVariable int id) {
		return carService.getCarById(id);
	}

	@ApiOperation(value = "get all cars", notes = "returns list of all car objects present in the database")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully retrieved data"),
			@ApiResponse(code = 404, message = "no data to retrieve") })
	@GetMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<List<Car>>> getAllCars() {
		return carService.getAllCars();
	}

	@ApiOperation(value = "delete car by id", notes = "takes id as input and deletes the object and returns true if deleted successfully")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully retrieved data"),
			@ApiResponse(code = 404, message = "id not found") })
	@DeleteMapping(value = "/{id}",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Car>> deleteCarById(@PathVariable int id) {
		return carService.getCarById(id);
	}

	@ApiOperation(value = "update car", notes = "takes car object as input, updates the values and returns the car object")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully retrieved data"),
			@ApiResponse(code = 404, message = "object not present") })
	@PutMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Car>> updateCar(@RequestBody @Valid Car car) {
		return carService.updateCarById(car);
	}



	@ApiOperation(value = "get available cars", notes = "takes integer input.send 1 for available cars and 0 for booked cars. It returns list of cars")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully retrieved data"),
			@ApiResponse(code = 404, message = "data not present") })
	@GetMapping(value = "/available/{availability}",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<List<Car>>> getAvailableCars(@PathVariable int availability) {
		return carService.getAvailableCars(availability);
	}

	@ApiOperation(value = "get cars by type", notes = "takes integer input,send 1 for available cars and 0 for booked cars, takes type of car as input. It returns list of cars")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully retrieved data"),
			@ApiResponse(code = 404, message = "object not present") })
	@GetMapping(value = "/{availability}/{type}",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<List<Car>>> getCarsByType(@PathVariable int availability,
			@PathVariable String type) {
		return carService.getCarsByType(availability, type);
	}


}
