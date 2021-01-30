package com.appseonit.ems.institute.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appseonit.ems.institute.dto.InstituteDTO;
import com.appseonit.ems.institute.dto.Response;
import com.appseonit.ems.institute.service.InstituteService;


@RestController
@RequestMapping("/institute/register")
public class InstituteRegsiterController {
	Logger log = LoggerFactory.getLogger(InstituteRegsiterController.class);

	@Autowired
	InstituteService service;
	
	@PostMapping("/save")
	public Response saveInstitute(@RequestBody InstituteDTO instituteDTO) {
		return service.saveInstitute(instituteDTO);
	}
	
}
