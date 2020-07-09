package com.vti.academy.web.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RefreshTokenDTO {
	@JsonProperty("username")
	private String username;
	@JsonProperty("refreshToken")
	private String refreshToken;

	public String getRefreshToken() {
		return refreshToken;
	}
	
	public String getUserName() {
		return username;
	}
}
