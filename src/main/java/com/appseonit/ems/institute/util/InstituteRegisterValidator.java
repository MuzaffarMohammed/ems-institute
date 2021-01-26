package com.appseonit.ems.institute.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appseonit.ems.institute.pojo.Institute;
import com.appseonit.ems.institute.pojo.InstituteMsg;

public class InstituteRegisterValidator {

	Logger log = LoggerFactory.getLogger(InstituteRegisterValidator.class);

	private EMSDateUtil dateUtil = new EMSDateUtil();
	
	public boolean validate(Institute institute, InstituteMsg instMsg) throws Exception {
		if (institute != null) {
			if (institute.getInstituteName() == null || institute.getInstituteName().trim().equals("")) {
				instMsg.setInstituteNameMsg(Constants.INST_NAME_VALIDATION_MSG);
			}
			if (institute.getInstituteCode() == null || institute.getInstituteCode().trim().equals("")) {
				instMsg.setInstituteCodeMsg(Constants.INST_CODE_VALIDATION_MSG);
			}
			if (institute.getCity() == null || institute.getCity().trim().equals("")) {
				instMsg.setCityMsg(Constants.INST_CITY_VALIDATION_MSG);
			}
			if (institute.getCountry() == null || institute.getCountry().trim().equals("")) {
				instMsg.setCountryMsg(Constants.INST_COUNTRY_VALIDATION_MSG);
			}
			if (institute.getContactNo() == null || institute.getContactNo().trim().equals("")) {
				instMsg.setContactNoMsg(Constants.INST_CONTACT_NO_VALIDATION_MSG);
			}
			if (institute.getOfficePhoneNo() == null || institute.getOfficePhoneNo().trim().equals("")) {
				instMsg.setOfficePhoneNoMsg(Constants.INST_OFFICE_PHONE_NO_VALIDATION_MSG);
			}
			if (institute.getFullAddress() == null || institute.getFullAddress().trim().equals("")) {
				instMsg.setFullAddressMsg(Constants.INST_FULL_ADDRESS_VALIDATION_MSG);
			}
			if (institute.getLocality() == null || institute.getLocality().trim().equals("")) {
				instMsg.setLocalityMsg(Constants.INST_LOCALITY_VALIDATION_MSG);
			}
			if (institute.getMailId() == null || institute.getMailId().trim().equals("")) {
				instMsg.setMailIdMsg(Constants.INST_MAIL_ID_VALIDATION_MSG);
			}
			if (institute.getMedium() == null || institute.getMedium().trim().equals("")) {
				instMsg.setMediumMsg(Constants.INST_MEDIUM_VALIDATION_MSG);
			}
			if (institute.getPinCode() == null || institute.getPinCode().trim().equals("")) {
				instMsg.setPinCodeMsg(Constants.INST_PINCODE_VALIDATION_MSG);
			}
			if (institute.getRecognisedBy() == null || institute.getRecognisedBy().trim().equals("")) {
				instMsg.setRecognisedByMsg(Constants.INST_RECOGNISED_BY_VALIDATION_MSG);
			}
			if (institute.getState() == null || institute.getState().trim().equals("")) {
				instMsg.setStateMsg(Constants.INST_STATE_VALIDATION_MSG);
			}
			
			instMsg.setAcademicYearFromMsg(validateDate(institute.getAcademicYearFrom(), Constants.INST_ACDM_FROM_YEAR_VALIDATION_MSG, Constants.UI_DATE_FORMAT));
			
			instMsg.setAcademicYearToMsg(validateDate(institute.getAcademicYearTo(), Constants.INST_ACDM_TO_YEAR_VALIDATION_MSG, Constants.UI_DATE_FORMAT));

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
	
	private String validateDate(String dateStr, String instMsg, String uiDateFmt) {
		String validate = null;
		try {
			LocalDate acedamicFromDate = dateUtil.parseDate(dateStr, uiDateFmt);
			if (acedamicFromDate == null) {
				validate =  instMsg;
			}
		} catch (DateTimeParseException dpe) {
			validate =  instMsg;
			log.error(dpe.getMessage(), dpe);
		}
		return validate;
	}
	
}
