package com.budong.model.dto;

public class Local_LawdCodeDTO {
	// 서울특별시  자치구  code / name
	private String lawd_code;
	private String lawd_name;
	
	public Local_LawdCodeDTO(String lawd_name) {
		this.lawd_name = lawd_name;
	}
	
	public String getLawd_code() {
		return lawd_code;
	}
	public void setLawd_code(String lawd_code) {
		this.lawd_code = lawd_code;
	}
	public String getLawd_name() {
		return lawd_name;
	}
	public void setLawd_name(String lawd_name) {
		this.lawd_name = lawd_name;
	}
}
