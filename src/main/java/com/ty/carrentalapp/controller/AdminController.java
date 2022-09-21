package com.ty.carrentalapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.carrentalapp.dto.Admin;
import com.ty.carrentalapp.dto.ResposneStructure;
import com.ty.carrentalapp.service.AdminService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/admins")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	@ApiOperation(value = " save admin", notes = "admin obj and it gives admin id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "succesfully created") , @ApiResponse(code = 400, message = "BAD REQUEST")})
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Admin>> saveAdmin( @RequestBody @Valid Admin admin){
		return adminService.saveAdmin(admin);
		
	}
	
	@ApiOperation(value = " get Admin", notes = "takes admin id and gives admin object")
	@ApiResponses(value= {@ApiResponse(code = 200, message = "getting admin by id"), @ApiResponse(code = 404, message = "NOT FOUND")})
	@GetMapping(value="/{id}" ,produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Admin>> getAdminById( @PathVariable int id)
	{
		return adminService.getAdminById(id);  
	}
	
	@ApiOperation(value = " delete admin", notes = "takes id and deletes admin object")
	@ApiResponses(value= {@ApiResponse(code = 200, message = "succesfully deleted"), @ApiResponse(code = 404, message = "NOT FOUND")})
	@DeleteMapping("/{id}")
	public ResponseEntity<ResposneStructure<String>> deleteAdminById(@PathVariable int id)
	{
		return adminService.deleteAdminById(id);
	}
	
	@ApiOperation(value = "finds admin", notes = "takes id and gives object")
	@ApiResponses(value= {@ApiResponse(code = 200, message = "succesfully fetched"), @ApiResponse(code = 404, message = "NOT FOUND")})
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Admin>> findAdminByEmail(@RequestParam String email)
	{
		return adminService.findAdminByEmail(email); 
	}

	@ApiOperation(value = "update admin", notes = "takes admin object and gives updated admin object")
	@ApiResponses(value= {@ApiResponse(code = 200, message = "succesfully updated"), @ApiResponse(code = 404, message = "NOT FOUND")})
	@PutMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResposneStructure<Admin>> updateAdmin(@RequestBody @Valid Admin admin)
	{
		return adminService.updateAdmin(admin);
	}
	

}
