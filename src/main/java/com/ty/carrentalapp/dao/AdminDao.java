package com.ty.carrentalapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.carrentalapp.dto.Admin;
import com.ty.carrentalapp.repository.AdminRepository;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepository adminRepository;

	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public Admin getAdminById(int id) {
		Optional<Admin> opt = adminRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public boolean deleteAdminById(int id) {
		Optional<Admin> opt = adminRepository.findById(id);
		if (opt.isPresent()) {
			adminRepository.delete(opt.get());
			return true;
		} else {
			return false;
		}
	}

	public Admin findAdminByEmail(String email) {
		Admin opt = adminRepository.findByEmail(email);
		if (opt != null) {
			return opt;
		} else {
			return null;
		}
	}

	public Admin updateAdmin(Admin admin) {
		Optional<Admin> opt = adminRepository.findById(admin.getId());
		if (opt != null) {
			return adminRepository.save(admin);
		} else {
			return null;
		}
	}

}
