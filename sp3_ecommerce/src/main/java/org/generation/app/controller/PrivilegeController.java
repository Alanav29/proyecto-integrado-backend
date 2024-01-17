package org.generation.app.controller;

import java.util.List;

import org.generation.app.entity.Privilege;
import org.generation.app.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

//@Log4j2
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/privileges")
public class PrivilegeController {
	
	@Autowired
	PrivilegeService privilegeService;
	
	@PostMapping
	ResponseEntity<Privilege> setPrivilege(@RequestBody Privilege privilege){
		Privilege newPrivilege = privilegeService.createPrivilege(privilege);
		return new ResponseEntity<>( newPrivilege, HttpStatus.CREATED);
	}
	
	@GetMapping
	ResponseEntity< List<Privilege> > getAllPrivileges(){
		List<Privilege> privileges = privilegeService.getAllPrivileges();
		return new ResponseEntity<>( privileges, HttpStatus.OK);
	}
	

}
