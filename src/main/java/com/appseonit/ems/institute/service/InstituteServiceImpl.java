package com.appseonit.ems.institute.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appseonit.ems.institute.entity.EmsInstitute;
import com.appseonit.ems.institute.entity.EmsInstitutePK;
import com.appseonit.ems.institute.pojo.Institute;
import com.appseonit.ems.institute.pojo.InstituteMsg;
import com.appseonit.ems.institute.pojo.Response;
import com.appseonit.ems.institute.repository.InstituteJPARepository;
import com.appseonit.ems.institute.util.Constants;
import com.appseonit.ems.institute.util.EMSDateUtil;
import com.appseonit.ems.institute.util.InstituteRegisterValidator;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Service(value = "instituteService")
public class InstituteServiceImpl implements InstituteService{

	Logger log = LoggerFactory.getLogger(InstituteService.class);

	@Autowired
	InstituteJPARepository instituteJPA;
	
	InstituteRegisterValidator validator;
	EMSDateUtil dateUtil = new EMSDateUtil();
	@Autowired
	private Gson gson;
	
	
	public InstituteServiceImpl() {
		validator = new InstituteRegisterValidator();
	}
	
	@Override
	public Institute getInstituteDetails(Integer instituteId) {
		log.info("Inside getInstituteDetails...");
		Institute inst = new Institute();

		try {
			
			EmsInstitute entity = null;
			//EmsInstitute entity = instituteJPA.findOneByEmsInstitutePKInstituteId(instituteId);

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

	@Override
	public Response saveInstitute(Institute institute) {
		log.info("In saveInstitute...");
		InstituteMsg instValidationMsgs = new InstituteMsg();
		String responseMsg = Constants.ERR_MSG;
		int status_code = Constants.ERROR_CODE; 
		try {
			if(validator.validate(institute, instValidationMsgs)) {
				EmsInstitute instEntity = constructEntity(institute);
				instituteJPA.save(instEntity);
				responseMsg = Constants.SAVE_MSG;
				status_code = Constants.SUCCESS_CODE;
			}else {
				responseMsg = gson.toJson(instValidationMsgs);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return new Response(status_code, responseMsg, null);
	}
	
	
	private EmsInstitute constructEntity(Institute institute) throws Exception {
		EmsInstitutePK instPk = new EmsInstitutePK(null, institute.getInstituteName(), institute.getInstituteCode());
		EmsInstitute instEntity = new EmsInstitute(instPk);
		BeanUtils.copyProperties(institute, instEntity);
		
		LocalDate acedamicFromDate = dateUtil.parseDate(institute.getAcademicYearFrom(), Constants.UI_DATE_FORMAT);
		instEntity.setAcademicYearFrom(java.sql.Date.valueOf(acedamicFromDate));
		
		LocalDate acedamicToDate = dateUtil.parseDate(institute.getAcademicYearTo(), Constants.UI_DATE_FORMAT);
		instEntity.setAcademicYearTo(java.sql.Date.valueOf(acedamicToDate));
		
		return instEntity;
	}
}
