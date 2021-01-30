package com.appseonit.ems.institute.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class EMSGson {

	public Gson gson;
	
	
	public EMSGson() {
		gson = new Gson();
	}
	
	@Bean
	public Gson getGson() {
		return gson;
	}
}
