package com.ty.carrentalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.carrentalapp.dao.BookingDao;
import com.ty.carrentalapp.dto.Booking;
import com.ty.carrentalapp.dto.ResposneStructure;
import com.ty.carrentalapp.exception.NoIdFoundException;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingDao;

	public ResponseEntity<ResposneStructure<Booking>> saveBooking(Booking booking) {

		ResposneStructure<Booking> structure = new ResposneStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(bookingDao.savePayment(booking));

		return new ResponseEntity<ResposneStructure<Booking>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResposneStructure<Booking>> findBookingById(int id) {

		Booking booking = bookingDao.findPaymentById(id);
		ResposneStructure<Booking> structure = new ResposneStructure<>();
		if (booking != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(booking);
			return new ResponseEntity<ResposneStructure<Booking>>(structure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("Given id : " + id + " NOT FOUND");
		}
	}

	public ResponseEntity<ResposneStructure<List<Booking>>> getAllBookings() {
		List<Booking> list = bookingDao.getPayments();

		ResposneStructure<List<Booking>> structure = new ResposneStructure<>();
		if (list != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(list);
			return new ResponseEntity<ResposneStructure<List<Booking>>>(structure, HttpStatus.OK);

		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("List Not Found");
			structure.setData(list);
			return new ResponseEntity<ResposneStructure<List<Booking>>>(structure, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResposneStructure<String>> deleteBookingById(int id) {
		ResposneStructure<String> structure = new ResposneStructure<>();
		ResponseEntity<ResposneStructure<String>> resp;
		if (bookingDao.deletePaymentById(id)) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("SUCCESS");
			structure.setData("Payment Deleted");
			resp = new ResponseEntity<ResposneStructure<String>>(structure, HttpStatus.OK);
		} else {

			throw new NoIdFoundException("Can't delete with id " + id);
		}
		return resp;

	}
}
