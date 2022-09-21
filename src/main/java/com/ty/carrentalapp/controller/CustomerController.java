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

import com.ty.carrentalapp.dto.Customer;
import com.ty.carrentalapp.dto.ResposneStructure;
import com.ty.carrentalapp.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = " save customer", notes = "customer obj and it gives customer id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully created"),
			@ApiResponse(code = 400, message = "Bad Request") })
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Customer>> saveCustomer(@RequestBody @Valid Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@ApiOperation(value = " get customers", notes = "customer obj and it gives customer id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully fetched"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping( produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<List<Customer>>> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@ApiOperation(value = "Delete customer", notes = "customer obj is deleted by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully deleted"),
			@ApiResponse(code = 404, message = "Not Found") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<String>> deleteCustomerById(@PathVariable int id) {

		return customerService.deleteCustomerById(id);
	}

	@ApiOperation(value = "Get customer By Id",notes = "getting customer object by using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success") , @ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Customer>> getCustomerById(@PathVariable int id){
		return customerService.getCustomerById(id);
	}
	
	
	@ApiOperation(value = "update customer",notes = "update customer")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"), @ApiResponse(code = 404, message = "Not Found") })
	@PutMapping( consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
	MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Customer>> updateCustomer(@RequestBody @Valid Customer customer) {
		
		return customerService.updateCustomer(customer);
		
	}
	
	
}
