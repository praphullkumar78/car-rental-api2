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

import com.ty.carrentalapp.dto.Booking;
import com.ty.carrentalapp.dto.ResposneStructure;
import com.ty.carrentalapp.service.BookingService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@ApiOperation(value = "saves Booking", notes = "Saves the Booking in the DataBase")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Created") , @ApiResponse(code = 400, message = "BAD REQUEST")})
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Booking>> saveBooking(@RequestBody @Valid Booking booking) {
		booking.getCar().setAvailability(0);
		return bookingService.saveBooking(booking);
	}

	@ApiOperation(value = "Get Booking", notes = "Fetches the Booking in the DataBase using id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched") , @ApiResponse(code = 400, message = "BAD REQUEST") })
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Booking>> findBookingById(@PathVariable int id) {
		return bookingService.findBookingById(id);
	}

	@ApiOperation(value = "gets all Bookings", notes = "Gets the List of Bookings")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched"), @ApiResponse(code = 404, message = "NOT FOUND") })
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<List<Booking>>> getAllBookings() {
		return bookingService.getAllBookings();
	}
	
	
	@ApiOperation(value = "Delete Booking", notes = "Delete Booking By Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Deleted"), @ApiResponse(code = 404, message = "NOT FOUND") })
	@DeleteMapping(value = "/{id}",produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<String>> deleteBookingById(@PathVariable int id){
		
		return bookingService.deleteBookingById(id);
	}
}
