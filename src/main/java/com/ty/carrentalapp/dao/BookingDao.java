package com.ty.carrentalapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.carrentalapp.dto.Booking;
import com.ty.carrentalapp.repository.BookingRepository;

@Repository
public class BookingDao {

	@Autowired
	private BookingRepository bookingRepository;

	public Booking savePayment(Booking booking) {
		return bookingRepository.save(booking);
	}

	public Booking findPaymentById(int id) {
		Optional<Booking> opt = bookingRepository.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public List<Booking> getPayments() {
		return bookingRepository.findAll();
	}

	public boolean deletePaymentById(int id) {
		Optional<Booking> opt = bookingRepository.findById(id);
		if (opt != null) {
			bookingRepository.delete(opt.get());
			return true;
		} else {
			return false;
		}
	}

	public Booking updateDriver(Booking booking) {
		Optional<Booking> opt = bookingRepository.findById(booking.getId());
		if (opt != null) {
			return bookingRepository.save(booking);
		}

		return null;
	}
}
