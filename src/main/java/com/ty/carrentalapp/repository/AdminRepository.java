package com.ty.carrentalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.carrentalapp.dto.Admin;

public interface AdminRepository  extends JpaRepository<Admin, Integer>{
	
	Admin findByEmail(String email);

}
