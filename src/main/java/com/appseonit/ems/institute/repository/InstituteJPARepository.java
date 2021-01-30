package com.appseonit.ems.institute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appseonit.ems.institute.entity.EmsInstitute;

@Repository
public interface InstituteJPARepository extends JpaRepository<EmsInstitute, Integer>{
	
	EmsInstitute findOneByInstituteId(Integer instituteId);
	
	EmsInstitute findOneByInstituteName(String instituteName);

}
