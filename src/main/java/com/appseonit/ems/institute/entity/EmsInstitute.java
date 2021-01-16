package com.appseonit.ems.institute.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ems_client database table.
 * 
 */
@Entity
@Table(name="ems_client")
public class EmsInstitute implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmsInstitutePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="ACADEMIC_YEAR_FROM")
	private Date academicYearFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="ACADEMIC_YEAR_TO")
	private Date academicYearTo;

	private String city;

	@Column(name="CONTACT_NO")
	private String contactNo;

	private String country;

	@Column(name="FULL_ADDRESS")
	private String fullAddress;

	private String locality;

	@Column(name="MAIL_ID")
	private String mailId;

	private String medium;

	@Column(name="OFFICE_PHONE_NO")
	private String officePhoneNo;

	@Column(name="PIN_CODE")
	private String pinCode;

	@Column(name="RECOGNISED_BY")
	private String recognisedBy;

	private String state;

	public EmsInstitute() {
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