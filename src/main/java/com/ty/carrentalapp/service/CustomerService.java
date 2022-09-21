package com.ty.carrentalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.carrentalapp.dao.CustomerDao;
import com.ty.carrentalapp.dto.Customer;
import com.ty.carrentalapp.dto.ResposneStructure;
import com.ty.carrentalapp.exception.NoIdFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public ResponseEntity<ResposneStructure<Customer>> saveCustomer(Customer customer) {

		ResposneStructure<Customer> resposneStructure = new ResposneStructure<>();
		resposneStructure.setStatus(HttpStatus.OK.value());
		resposneStructure.setMessage("Created");
		resposneStructure.setData(customerDao.saveCustomer(customer));

		return new ResponseEntity<ResposneStructure<Customer>>(resposneStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResposneStructure<List<Customer>>> getAllCustomers() {

		List<Customer> customer = customerDao.getAllCustomer();
		ResposneStructure<List<Customer>> resposneStructure = new ResposneStructure<>();

		if (customer != null) {

			resposneStructure.setStatus(HttpStatus.OK.value());
			resposneStructure.setMessage("Created");
			resposneStructure.setData(customer);

			return new ResponseEntity<ResposneStructure<List<Customer>>>(resposneStructure, HttpStatus.OK);
		} else {

			resposneStructure.setStatus(HttpStatus.NOT_FOUND.value());
			resposneStructure.setMessage("no data found");
			return new ResponseEntity<ResposneStructure<List<Customer>>>(resposneStructure, HttpStatus.OK);

		}
	}

	public ResponseEntity<ResposneStructure<String>> deleteCustomerById(int id) {

		ResposneStructure<String> resposneStructure = new ResposneStructure<>();

		boolean customer=customerDao.deleteCustomerById(id);
		if (customer) {
			resposneStructure.setStatus(HttpStatus.OK.value());
			resposneStructure.setMessage("succes");
			resposneStructure.setData("data is deleted");
			return new ResponseEntity<ResposneStructure<String>>(resposneStructure, HttpStatus.OK);

		}
		throw new NoIdFoundException("No data found ");
	}

	public ResponseEntity<ResposneStructure<Customer>> getCustomerById(int id) {
		ResposneStructure<Customer> resposneStructure = new ResposneStructure<>();
		Customer customer = customerDao.getCustomerById(id);
		if (customer != null) {
			resposneStructure.setStatus(HttpStatus.OK.value());
			resposneStructure.setMessage("succes");
			resposneStructure.setData(customer);
			return new ResponseEntity<ResposneStructure<Customer>>(resposneStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("Data is not present in the database");

		}

	}
	
	
	public ResponseEntity<ResposneStructure<Customer>> updateCustomer(Customer customer) {
		
		ResposneStructure<Customer> resposneStructure = new ResposneStructure<>();

		Customer customer1=customerDao.updateCustomer(customer);
		if(customer1 !=null) {
		resposneStructure.setStatus(HttpStatus.OK.value());
		resposneStructure.setMessage("updated");
		resposneStructure.setData(customer1);
		return new ResponseEntity<ResposneStructure<Customer>>(resposneStructure,HttpStatus.OK);
		
		}
		else {
			resposneStructure.setStatus(HttpStatus.OK.value());
			resposneStructure.setMessage("customer object is present");
			resposneStructure.setData(null);
			return new ResponseEntity<ResposneStructure<Customer>>(resposneStructure,HttpStatus.OK);
			
		}
		
		
	}

}
