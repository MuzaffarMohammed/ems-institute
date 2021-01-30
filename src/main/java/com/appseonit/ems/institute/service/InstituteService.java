package com.appseonit.ems.institute.service;

import com.appseonit.ems.institute.dto.InstituteDTO;
import com.appseonit.ems.institute.dto.Response;

public interface InstituteService {


	InstituteDTO getInstituteDetails(Integer instituteId);
	
	InstituteDTO getInstituteDetails(String instituteName);

	Response saveInstitute(InstituteDTO instituteDTO);
	
}
