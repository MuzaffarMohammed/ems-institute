package com.appseonit.ems.institute.pojo;

import com.appseonit.ems.institute.util.Constants;

public class Response {

	/*
	 * This pojo is for response status along with response data 
	 * 'code' field should be added without fail to sync with UI code.
	 * Default value is been set because to avoid response errors.
	 * */
	
	public int code = Constants.ERROR_CODE;
	public String respMsg;
	public String response;
	
	public Response() {}
	
	public Response(int code, String respMsg, String response) {
		this.code = code;
		this.respMsg = respMsg;
		this.response = response;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
}
