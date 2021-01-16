package com.appseonit.ems.institute.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appseonit.ems.institute.pojo.Institute;
import com.appseonit.ems.institute.service.InstituteService;


@RestController
@RequestMapping("/institute")
public class InstituteController {
	Logger log = LoggerFactory.getLogger(InstituteController.class);

	@Autowired
	InstituteService service;
	
	@GetMapping("/details/{userId}")
	public Institute getInstituteDetails(@PathVariable int userId) {
		log.info("Inside getInstituteDetails...");
		return service.getInstituteDetails(userId);
	}
	
}
