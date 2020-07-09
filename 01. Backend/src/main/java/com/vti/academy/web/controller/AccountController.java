package com.vti.academy.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vti.academy.web.response.CommonResponse;
import com.vti.academy.web.service.AccountService;

@RestController
@RequestMapping("account")
@Validated
public class AccountController {

	private static final Logger log = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;

	@GetMapping(value = "/resetPassword")
	@ResponseBody
	public CommonResponse resetPassword(@RequestParam String account) {
		return accountService.resetPassword(account);
	}
	
}
