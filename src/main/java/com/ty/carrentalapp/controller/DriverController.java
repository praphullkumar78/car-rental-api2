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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.carrentalapp.dto.Driver;
import com.ty.carrentalapp.dto.ResposneStructure;
import com.ty.carrentalapp.service.DriverService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/drivers")
public class DriverController {

	@Autowired
	private DriverService driverService;

	@ApiOperation(value = "saves Driver", notes = "Saves the Driver in the DataBase")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Created") , @ApiResponse(code = 400, message = "BAD REQUEST")})
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Driver>> saveDriver(@RequestBody @Valid Driver driver) {
		return driverService.saveDriver(driver);
	}

	@ApiOperation(value = "Get Driver", notes = "Fetches the Driver in the DataBase using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched") , @ApiResponse(code = 404, message = "NOT FOUND") })
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Driver>> findDriverById(@PathVariable int id) {
		return driverService.findDriverById(id);
	}

	@ApiOperation(value = "gets all Drivers", notes = "Gets the List of Drivers")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched") , @ApiResponse(code = 404, message = "NOT FOUND")})
	@GetMapping(value = "/list" ,produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<List<Driver>>> getAllDrivers() {
		return driverService.getAllDrivers();
	}
	
	
	@ApiOperation(value = "Delete Driver", notes = "Delete Driver By Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Deleted") , @ApiResponse(code = 404, message = "NOT FOUND") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResposneStructure<String>> deleteDriverById(@PathVariable int id){
		
		return driverService.deleteDriverById(id);
	}
	
	@ApiOperation(value = "Gets the Driver" , notes = "Gets the Driver Object using License")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched") , @ApiResponse(code = 404, message = "NOT FOUND") })
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResposneStructure<Driver>> findDriverByDrivingLicense(@RequestParam String license){
		return driverService.findDriverByDrivingLicense(license);
	}
	
	@ApiOperation(value = "Updates the Driver", notes = "Updates the Existing Driver")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Updated") , @ApiResponse(code = 404, message = "NOT FOUND") })
	@PutMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Driver>> updateDriver(@RequestBody @Valid Driver driver){
		
		return driverService.updateDriver(driver);
	}

}
