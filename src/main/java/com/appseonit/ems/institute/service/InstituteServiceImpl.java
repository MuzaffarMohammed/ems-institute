package com.appseonit.ems.institute.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appseonit.ems.institute.entity.EmsInstitute;
import com.appseonit.ems.institute.pojo.Institute;
import com.appseonit.ems.institute.repository.InstituteJPARepository;
import com.google.gson.Gson;

@Service(value = "instituteService")
public class InstituteServiceImpl implements InstituteService{

	Logger log = LoggerFactory.getLogger(InstituteService.class);

	@Autowired
	InstituteJPARepository instituteJPA;
	
	@Autowired
	private Gson gson;
	
	@Override
	public Institute getInstituteDetails(Integer instituteId) {
		log.info("Inside getInstituteDetails...");
		Institute inst = new Institute();

		try {
			
			EmsInstitute entity = instituteJPA.findOneByEmsInstitutePKInstituteId(instituteId);
			// Copying entity object to pojo.
			BeanUtils.copyProperties(entity, inst);
			inst.setInstituteId(entity.getId().getInstituteId());
			inst.setInstituteName(entity.getId().getInstituteName());
			inst.setInstituteCode(entity.getId().getInstituteCode());
			//gson.toJson(inst);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return inst;
	}
	
}
