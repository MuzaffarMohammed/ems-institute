package com.appseonit.ems.institute.service;

import com.appseonit.ems.institute.pojo.Institute;
import com.appseonit.ems.institute.pojo.Response;

public interface InstituteService {


	Institute getInstituteDetails(Integer userId);

	Response saveInstitute(Institute institute);
}
