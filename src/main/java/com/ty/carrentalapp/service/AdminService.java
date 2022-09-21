package com.ty.carrentalapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.carrentalapp.dao.AdminDao;
import com.ty.carrentalapp.dto.Admin;
import com.ty.carrentalapp.dto.ResposneStructure;
import com.ty.carrentalapp.exception.NoIdFoundException;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResposneStructure<Admin>> saveAdmin(Admin admin) {
		ResposneStructure<Admin> responseStructure = new ResposneStructure<Admin>();
		responseStructure.setStatus(200);
		responseStructure.setMessage("passed");
		responseStructure.setData(adminDao.saveAdmin(admin));
		return new ResponseEntity<ResposneStructure<Admin>>(responseStructure, HttpStatus.OK); 
	}

	public ResponseEntity<ResposneStructure<Admin>> getAdminById(int id) {
		ResponseEntity<ResposneStructure<Admin>> resp;
		Admin admin = adminDao.getAdminById(id);
		ResposneStructure<Admin> responseStructure = new ResposneStructure<Admin>();

		if (admin != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("passed");
			responseStructure.setData(admin);
			resp = new ResponseEntity<ResposneStructure<Admin>>(responseStructure, HttpStatus.OK);
			return resp;

		} else {
			throw new NoIdFoundException();
		}
		

	}

	public ResponseEntity<ResposneStructure<String>> deleteAdminById(int id) {
		ResposneStructure<String> responseStructure = new ResposneStructure<String>();
		if (adminDao.deleteAdminById(id)) {
			responseStructure.setStatus(200);
			responseStructure.setMessage("id deleted");
			responseStructure.setData("admin with given id deleted");
			return new ResponseEntity<ResposneStructure<String>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException();
		}

	}

	public ResponseEntity<ResposneStructure<Admin>> findAdminByEmail(String email) {
		ResponseEntity<ResposneStructure<Admin>> resp;
		Admin admin = adminDao.findAdminByEmail(email);
		ResposneStructure<Admin> responseStructure = new ResposneStructure<Admin>();

		if (admin != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("passed");
			responseStructure.setData(admin);
			resp = new ResponseEntity<ResposneStructure<Admin>>(responseStructure, HttpStatus.OK);
			return resp;

		} else {
			throw new NoIdFoundException();
		}
		

	}

	public ResponseEntity<ResposneStructure<Admin>> updateAdmin(Admin admin) {
		Admin admin1 = adminDao.updateAdmin(admin);

		ResposneStructure<Admin> responseStructure = new ResposneStructure<Admin>();

		if (admin1 != null) {
			responseStructure.setMessage("updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(admin1);
			return new ResponseEntity<ResposneStructure<Admin>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(admin);
			return new ResponseEntity<ResposneStructure<Admin>>(responseStructure, HttpStatus.NOT_FOUND);

		}
	}

}
