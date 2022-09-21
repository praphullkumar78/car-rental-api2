package com.ty.carrentalapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.carrentalapp.dto.Payment;
import com.ty.carrentalapp.repository.PaymentRepository;

@Repository
public class PaymentDao {

	@Autowired
	private PaymentRepository paymentRepository;

	public Payment savePayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	public Payment findPaymentById(int id) {
		Optional<Payment> opt = paymentRepository.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public List<Payment> getPayments() {
		return paymentRepository.findAll();
	}

	public boolean deletePaymentById(int id) {
		Optional<Payment> opt = paymentRepository.findById(id);
		if (opt != null) {
			paymentRepository.delete(opt.get());
			return true;
		} else {
			return false;
		}
	}

	public Payment updateDriver(Payment payment) {
		Optional<Payment> opt = paymentRepository.findById(payment.getId());
		if (opt != null) {
			return paymentRepository.save(payment);
		}

		return null;
	}
}
