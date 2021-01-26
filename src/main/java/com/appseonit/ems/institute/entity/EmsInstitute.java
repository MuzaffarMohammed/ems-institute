package com.appseonit.ems.institute.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ems_institute database table.
 * 
 */
@Entity
@Table(name="ems_institute")
public class EmsInstitute implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmsInstitutePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="ACADEMIC_YEAR_FROM", nullable = false)
	private Date academicYearFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="ACADEMIC_YEAR_TO", nullable = false)
	private Date academicYearTo;

	@Column(name="CITY", nullable = false)
	private String city;

	@Column(name="CONTACT_NO", nullable = false)
	private String contactNo;

	@Column(name="COUNTRY", nullable = false)
	private String country;

	@Column(name="FULL_ADDRESS", nullable = false)
	private String fullAddress;

	@Column(name="LOCALITY", nullable = false)
	private String locality;

	@Column(name="MAIL_ID", nullable = false)
	private String mailId;

	@Column(name="MEDIUM", nullable = false)
	private String medium;

	@Column(name="OFFICE_PHONE_NO", nullable = false)
	private String officePhoneNo;

	@Column(name="PIN_CODE", nullable = false)
	private String pinCode;

	@Column(name="RECOGNISED_BY", nullable = false)
	private String recognisedBy;

	@Column(name="STATE", nullable = false)
	private String state;

	public EmsInstitute() {
	}
	
	public EmsInstitute(EmsInstitutePK id) {
		this.id = id;
	}

	public EmsInstitutePK getId() {
		return this.id;
	}

	public void setId(EmsInstitutePK id) {
		this.id = id;
	}

	public Date getAcademicYearFrom() {
		return this.academicYearFrom;
	}

	public void setAcademicYearFrom(Date academicYearFrom) {
		this.academicYearFrom = academicYearFrom;
	}

	public Date getAcademicYearTo() {
		return this.academicYearTo;
	}

	public void setAcademicYearTo(Date academicYearTo) {
		this.academicYearTo = academicYearTo;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFullAddress() {
		return this.fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getLocality() {
		return this.locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getMailId() {
		return this.mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getMedium() {
		return this.medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getOfficePhoneNo() {
		return this.officePhoneNo;
	}

	public void setOfficePhoneNo(String officePhoneNo) {
		this.officePhoneNo = officePhoneNo;
	}

	public String getPinCode() {
		return this.pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getRecognisedBy() {
		return this.recognisedBy;
	}

	public void setRecognisedBy(String recognisedBy) {
		this.recognisedBy = recognisedBy;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}