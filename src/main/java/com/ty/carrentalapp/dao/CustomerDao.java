package com.ty.carrentalapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.carrentalapp.dto.Customer;
import com.ty.carrentalapp.repository.CustomerRepository;

@Repository
public class CustomerDao {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public Customer saveCustomer(Customer customer) {
		
		
		return   customerRepository.save(customer);
	}
	
	public Customer getCustomerById(int id) {
		
		Optional<Customer> customer=customerRepository.findById(id);
		
		if(customer.isPresent()) {
			
			return customer.get();
					
		}
		
		return null;
				
	}
	
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}
	
	public boolean deleteCustomerById(int id) {
		Customer customer = getCustomerById(id);
		if(customer != null) {
			return true;
		}
		return false;
	}
	
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> opt = customerRepository.findById(customer.getId());
		if (opt != null) {
			return customerRepository.save(customer);
		} else {
			return null;
		}
	}
	
	public Customer getCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}
	
	
	
}
