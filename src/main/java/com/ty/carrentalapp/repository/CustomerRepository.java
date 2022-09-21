package com.ty.carrentalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.carrentalapp.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	Customer findByEmail(String email);

}
