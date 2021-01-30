package com.appseonit.ems.institute.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appseonit.ems.institute.dto.InstituteDTO;
import com.appseonit.ems.institute.dto.InstituteMsg;
import com.appseonit.ems.institute.entity.EmsInstitute;
import com.appseonit.ems.institute.service.InstituteService;

@Service
public class InstituteRegisterValidator {

	Logger log = LoggerFactory.getLogger(InstituteRegisterValidator.class);

	private EMSDateUtil dateUtil = new EMSDateUtil();
	
	@Autowired
	private InstituteService service;
	
	public boolean validate(InstituteDTO instituteDTO, InstituteMsg instMsg) throws Exception {
		if (instituteDTO != null) {
			if (instituteDTO.getInstituteName() == null || instituteDTO.getInstituteName().trim().equals("")) {
				instMsg.setInstituteNameMsg(Constants.INST_NAME_VALIDATION_MSG);
			}
			if (instituteDTO.getInstituteCode() == null || instituteDTO.getInstituteCode().trim().equals("")) {
				instMsg.setInstituteCodeMsg(Constants.INST_CODE_VALIDATION_MSG);
			}
			if (instituteDTO.getCity() == null || instituteDTO.getCity().trim().equals("")) {
				instMsg.setCityMsg(Constants.INST_CITY_VALIDATION_MSG);
			}
			if (instituteDTO.getCountry() == null || instituteDTO.getCountry().trim().equals("")) {
				instMsg.setCountryMsg(Constants.INST_COUNTRY_VALIDATION_MSG);
			}
			if (instituteDTO.getContactNo() == null || instituteDTO.getContactNo().trim().equals("")) {
				instMsg.setContactNoMsg(Constants.INST_CONTACT_NO_VALIDATION_MSG);
			}
			if (instituteDTO.getOfficePhoneNo() == null || instituteDTO.getOfficePhoneNo().trim().equals("")) {
				instMsg.setOfficePhoneNoMsg(Constants.INST_OFFICE_PHONE_NO_VALIDATION_MSG);
			}
			if (instituteDTO.getFullAddress() == null || instituteDTO.getFullAddress().trim().equals("")) {
				instMsg.setFullAddressMsg(Constants.INST_FULL_ADDRESS_VALIDATION_MSG);
			}
			if (instituteDTO.getLocality() == null || instituteDTO.getLocality().trim().equals("")) {
				instMsg.setLocalityMsg(Constants.INST_LOCALITY_VALIDATION_MSG);
			}
			if (instituteDTO.getMailId() == null || instituteDTO.getMailId().trim().equals("")) {
				instMsg.setMailIdMsg(Constants.INST_MAIL_ID_VALIDATION_MSG);
			}
			if (instituteDTO.getMedium() == null || instituteDTO.getMedium().trim().equals("")) {
				instMsg.setMediumMsg(Constants.INST_MEDIUM_VALIDATION_MSG);
			}
			if (instituteDTO.getPinCode() == null || instituteDTO.getPinCode().trim().equals("")) {
				instMsg.setPinCodeMsg(Constants.INST_PINCODE_VALIDATION_MSG);
			}
			if (instituteDTO.getRecognisedBy() == null || instituteDTO.getRecognisedBy().trim().equals("")) {
				instMsg.setRecognisedByMsg(Constants.INST_RECOGNISED_BY_VALIDATION_MSG);
			}
			if (instituteDTO.getState() == null || instituteDTO.getState().trim().equals("")) {
				instMsg.setStateMsg(Constants.INST_STATE_VALIDATION_MSG);
			}
			
			instMsg.setAcademicYearFromMsg(validateDate(instituteDTO.getAcademicYearFrom(), Constants.INST_ACDM_FROM_YEAR_VALIDATION_MSG, Constants.UI_DATE_FORMAT));
			
			instMsg.setAcademicYearToMsg(validateDate(instituteDTO.getAcademicYearTo(), Constants.INST_ACDM_TO_YEAR_VALIDATION_MSG, Constants.UI_DATE_FORMAT));

		} else {
			// Please include field here too if you add any new field validation check above.
			instMsg.setInstituteNameMsg(Constants.INST_NAME_VALIDATION_MSG);
			instMsg.setInstituteCodeMsg(Constants.INST_CODE_VALIDATION_MSG);
			instMsg.setAcademicYearFromMsg(Constants.INST_ACDM_FROM_YEAR_VALIDATION_MSG);
			instMsg.setAcademicYearToMsg(Constants.INST_ACDM_TO_YEAR_VALIDATION_MSG);
			instMsg.setCityMsg(Constants.INST_CITY_VALIDATION_MSG);
			instMsg.setCountryMsg(Constants.INST_COUNTRY_VALIDATION_MSG);
			instMsg.setContactNoMsg(Constants.INST_CONTACT_NO_VALIDATION_MSG);
			instMsg.setOfficePhoneNoMsg(Constants.INST_OFFICE_PHONE_NO_VALIDATION_MSG);
			instMsg.setFullAddressMsg(Constants.INST_FULL_ADDRESS_VALIDATION_MSG);
			instMsg.setLocalityMsg(Constants.INST_LOCALITY_VALIDATION_MSG);
			instMsg.setMailIdMsg(Constants.INST_MAIL_ID_VALIDATION_MSG);
			instMsg.setMediumMsg(Constants.INST_MEDIUM_VALIDATION_MSG);
			instMsg.setPinCodeMsg(Constants.INST_PINCODE_VALIDATION_MSG);
			instMsg.setRecognisedByMsg(Constants.INST_RECOGNISED_BY_VALIDATION_MSG);
			instMsg.setStateMsg(Constants.INST_STATE_VALIDATION_MSG);
		}
		return instMsg.checkAllValidationFieldMsgsAreEmpty(instMsg);
	}
	
	private String validateDate(Date date, String instMsg, String uiDateFmt) {
		String validate = null;
		try {
//			LocalDate acedamicFromDate = dateUtil.parseDate(dateStr, uiDateFmt);
			if (date == null) {
				validate =  instMsg;
			}
		} catch (DateTimeParseException dpe) {
			validate =  instMsg;
			log.error(dpe.getMessage(), dpe);
		}
		return validate;
	}
	
}
