package com.appseonit.ems.institute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appseonit.ems.institute.entity.EmsInstitute;
import com.appseonit.ems.institute.entity.EmsInstitutePK;

@Repository
public interface InstituteJPARepository extends JpaRepository<EmsInstitute, EmsInstitutePK>{
	
	//EmsInstitute findOneByEmsInstitutePKInstituteId(Integer instituteId);

}
