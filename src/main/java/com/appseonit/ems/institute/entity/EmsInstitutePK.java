package com.appseonit.ems.institute.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ems_client database table.
 * 
 */
@Embeddable
public class EmsInstitutePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CLIENT_ID", nullable = false)
	private Integer instituteId;

	@Column(name="CLIENT_NAME", nullable = false)
	private String instituteName;

	@Column(name="CLIENT_CODE", nullable = false)
	private String instituteCode;

	public EmsInstitutePK() {
	}

	public EmsInstitutePK(Integer instituteId, String instituteName, String instituteCode) {
		this.instituteId = instituteId;
		this.instituteName = instituteName;
		this.instituteCode = instituteCode;
	}

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}



	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getInstituteCode() {
		return instituteCode;
	}

	public void setInstituteCode(String instituteCode) {
		this.instituteCode = instituteCode;
	}



	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmsInstitutePK)) {
			return false;
		}
		EmsInstitutePK castOther = (EmsInstitutePK)other;
		return 
			(this.instituteId == castOther.instituteId)
			&& this.instituteName.equals(castOther.instituteName)
			&& this.instituteCode.equals(castOther.instituteCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.instituteId;
		hash = hash * prime + this.instituteName.hashCode();
		hash = hash * prime + this.instituteCode.hashCode();
		
		return hash;
	}
}