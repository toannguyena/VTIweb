package com.vti.academy.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vti.academy.web.model.dto.RefreshTokenDTO;
import com.vti.academy.web.response.CommonResponse;
import com.vti.academy.web.service.AccountService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/auth/refresh-token", method = RequestMethod.POST)
	public CommonResponse genRefreshToken(@RequestBody RefreshTokenDTO refreshTokenDTO) {
		return null;
	}
}