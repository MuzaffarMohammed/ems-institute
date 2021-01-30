package com.appseonit.ems.institute.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


	
@Configuration
public class ModelMapperConfig {

	    @Bean
	    public ModelMapper modelMapper() {
	        ModelMapper modelMapper = new ModelMapper();
	        modelMapper.getConfiguration().setSkipNullEnabled(true)
									        .setSourceNamingConvention(NamingConventions.NONE)	
									    	.setDestinationNamingConvention(NamingConventions.NONE)	
									    	.setMatchingStrategy(MatchingStrategies.STRICT);	
	        return modelMapper;
	    }
	
}
