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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.carrentalapp.dto.Payment;
import com.ty.carrentalapp.dto.ResposneStructure;
import com.ty.carrentalapp.service.PaymentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@ApiOperation(value = "saves Payment", notes = "Saves the Payment in the DataBase")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Created") , @ApiResponse(code = 400, message = "BAD REQUEST")})
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Payment>> savePayment(@RequestBody @Valid Payment payment) {
		return paymentService.savePayment(payment);
	}

	@ApiOperation(value = "Get Payment", notes = "Fetches the Payment in the DataBase using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched") , @ApiResponse(code = 404, message = "NOT FOUND") })
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Payment>> findPaymentById(@PathVariable int id) {
		return paymentService.findPaymentById(id);
	}

	@ApiOperation(value = "gets all Payments", notes = "Gets the List of Payments")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched"),  @ApiResponse(code = 404, message = "NOT FOUND") })
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<List<Payment>>> getAllPayments() {
		return paymentService.getAllPayments();
	}
	
	
	@ApiOperation(value = "Delete Payment", notes = "Delete Payment By Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Deleted") , @ApiResponse(code = 404, message = "NOT FOUND")})
	@DeleteMapping("/{id}")
	public ResponseEntity<ResposneStructure<String>> deletePaymentById(@PathVariable int id){
		
		return paymentService.deletePaymentById(id);
	}
}
