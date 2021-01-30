package com.appseonit.ems.institute.service;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appseonit.ems.institute.dto.InstituteDTO;
import com.appseonit.ems.institute.dto.InstituteMsg;
import com.appseonit.ems.institute.dto.Response;
import com.appseonit.ems.institute.entity.EmsInstitute;
import com.appseonit.ems.institute.repository.InstituteJPARepository;
import com.appseonit.ems.institute.util.Constants;
import com.appseonit.ems.institute.util.EMSDateUtil;
import com.appseonit.ems.institute.util.EMSGson;
import com.appseonit.ems.institute.util.InstituteRegisterValidator;

@Service(value = "instituteService")
public class InstituteServiceImpl implements InstituteService{

	Logger log = LoggerFactory.getLogger(InstituteService.class);

	@Autowired
	private InstituteJPARepository instituteJPA;
	
	@Autowired
	private InstituteRegisterValidator validator;
	
	private EMSDateUtil dateUtil = new EMSDateUtil();
	
	@Autowired
	private EMSGson emsGson;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public InstituteServiceImpl() {
		validator = new InstituteRegisterValidator();
	}
	
	@Override
	public InstituteDTO getInstituteDetails(Integer instituteId) {
		log.info("Inside getInstituteDetails...");
		InstituteDTO inst = null;
		try {
			EmsInstitute entity = instituteJPA.findOneByInstituteId(instituteId);
			inst = modelMapper.map(entity, InstituteDTO.class);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return inst;
	}
	
	public InstituteDTO getInstituteDetails(String instituteName) {
		log.info("Inside getInstituteData...");
		InstituteDTO instituteDTO = null;
		try {
			EmsInstitute instEntity = instituteJPA.findOneByInstituteName(instituteName);
			if(instEntity != null) {
				instituteDTO = modelMapper.map(instEntity, InstituteDTO.class);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return instituteDTO;
	}

	@Override
	public Response saveInstitute(InstituteDTO instituteDTO) {
		log.info("In saveInstitute...");
		InstituteMsg instValidationMsgs = new InstituteMsg();
		String responseMsg = Constants.ERR_MSG;
		int status_code = Constants.ERROR_CODE; 
		try {
			if(validator.validate(instituteDTO, instValidationMsgs)) {
				EmsInstitute instEntity = constructEntity(instituteDTO);
				instituteJPA.save(instEntity);
				responseMsg = Constants.SAVE_MSG;
				status_code = Constants.SUCCESS_CODE;
			}else {
				responseMsg = emsGson.getGson().toJson(instValidationMsgs);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return new Response(status_code, responseMsg, null);
	}
	
	
	private EmsInstitute constructEntity(InstituteDTO instituteDTO) throws Exception {
		return modelMapper.map(instituteDTO, EmsInstitute.class);
	}

}
