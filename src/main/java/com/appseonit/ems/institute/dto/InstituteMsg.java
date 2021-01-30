package com.appseonit.ems.institute.dto;

import java.lang.reflect.Field;

public class InstituteMsg {

	public String instituteNameMsg;
	public String instituteCodeMsg;
	public String academicYearFromMsg;
	public String academicYearToMsg;
	public String cityMsg;
	public String contactNoMsg;
	public String countryMsg;
	public String fullAddressMsg;
	public String localityMsg;
	public String mailIdMsg;
	public String mediumMsg;
	public String officePhoneNoMsg;
	public String pinCodeMsg;
	public String recognisedByMsg;
	public String stateMsg;

	public InstituteMsg() {
	}

	public String getInstituteNameMsg() {
		return instituteNameMsg;
	}

	public void setInstituteNameMsg(String instituteNameMsg) {
		this.instituteNameMsg = instituteNameMsg;
	}

	public String getInstituteCodeMsg() {
		return instituteCodeMsg;
	}

	public void setInstituteCodeMsg(String instituteCodeMsg) {
		this.instituteCodeMsg = instituteCodeMsg;
	}

	public String getAcademicYearFromMsg() {
		return academicYearFromMsg;
	}

	public void setAcademicYearFromMsg(String academicYearFromMsg) {
		this.academicYearFromMsg = academicYearFromMsg;
	}

	public String getAcademicYearToMsg() {
		return academicYearToMsg;
	}

	public void setAcademicYearToMsg(String academicYearToMsg) {
		this.academicYearToMsg = academicYearToMsg;
	}

	public String getCityMsg() {
		return cityMsg;
	}

	public void setCityMsg(String cityMsg) {
		this.cityMsg = cityMsg;
	}

	public String getContactNoMsg() {
		return contactNoMsg;
	}

	public void setContactNoMsg(String contactNoMsg) {
		this.contactNoMsg = contactNoMsg;
	}

	public String getCountryMsg() {
		return countryMsg;
	}

	public void setCountryMsg(String countryMsg) {
		this.countryMsg = countryMsg;
	}

	public String getFullAddressMsg() {
		return fullAddressMsg;
	}

	public void setFullAddressMsg(String fullAddressMsg) {
		this.fullAddressMsg = fullAddressMsg;
	}

	public String getLocalityMsg() {
		return localityMsg;
	}

	public void setLocalityMsg(String localityMsg) {
		this.localityMsg = localityMsg;
	}

	public String getMailIdMsg() {
		return mailIdMsg;
	}

	public void setMailIdMsg(String mailIdMsg) {
		this.mailIdMsg = mailIdMsg;
	}

	public String getMediumMsg() {
		return mediumMsg;
	}

	public void setMediumMsg(String mediumMsg) {
		this.mediumMsg = mediumMsg;
	}

	public String getOfficePhoneNoMsg() {
		return officePhoneNoMsg;
	}

	public void setOfficePhoneNoMsg(String officePhoneNoMsg) {
		this.officePhoneNoMsg = officePhoneNoMsg;
	}

	public String getPinCodeMsg() {
		return pinCodeMsg;
	}

	public void setPinCodeMsg(String pinCodeMsg) {
		this.pinCodeMsg = pinCodeMsg;
	}

	public String getRecognisedByMsg() {
		return recognisedByMsg;
	}

	public void setRecognisedByMsg(String recognisedByMsg) {
		this.recognisedByMsg = recognisedByMsg;
	}

	public String getStateMsg() {
		return stateMsg;
	}

	public void setStateMsg(String stateMsg) {
		this.stateMsg = stateMsg;
	}

	public boolean checkAllValidationFieldMsgsAreEmpty(InstituteMsg instMsg)
			throws IllegalArgumentException, IllegalAccessException {
		for (Field f : instMsg.getClass().getDeclaredFields()) {
			if (f.get(this) != null) {
				return false;
			}
		}
		return true;
	}

}
