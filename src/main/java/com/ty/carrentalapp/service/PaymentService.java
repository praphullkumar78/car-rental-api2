package com.ty.carrentalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.carrentalapp.dao.PaymentDao;
import com.ty.carrentalapp.dto.Payment;
import com.ty.carrentalapp.dto.ResposneStructure;
import com.ty.carrentalapp.exception.NoIdFoundException;

@Service
public class PaymentService {

	@Autowired
	private PaymentDao paymentDao;
	
	public ResponseEntity<ResposneStructure<Payment>> savePayment(Payment payment) {

		ResposneStructure<Payment> structure = new ResposneStructure<>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(paymentDao.savePayment(payment));

		return new ResponseEntity<ResposneStructure<Payment>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResposneStructure<Payment>> findPaymentById(int id) {

		Payment payment = paymentDao.findPaymentById(id);
		ResposneStructure<Payment> structure = new ResposneStructure<>();
		if (payment != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(payment);
			return new ResponseEntity<ResposneStructure<Payment>>(structure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("Given id : " + id + " NOT FOUND");
		}
	}

	public ResponseEntity<ResposneStructure<List<Payment>>> getAllPayments() {
		List<Payment> list = paymentDao.getPayments();

		ResposneStructure<List<Payment>> structure = new ResposneStructure<>();
		if (list != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(list);
			return new ResponseEntity<ResposneStructure<List<Payment>>>(structure, HttpStatus.OK);

		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("List Not Found");
			structure.setData(list);
			return new ResponseEntity<ResposneStructure<List<Payment>>>(structure, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResposneStructure<String>> deletePaymentById(int id) {
		ResposneStructure<String> structure = new ResposneStructure<>();
		ResponseEntity<ResposneStructure<String>> resp;
		if (paymentDao.deletePaymentById(id)) {
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
