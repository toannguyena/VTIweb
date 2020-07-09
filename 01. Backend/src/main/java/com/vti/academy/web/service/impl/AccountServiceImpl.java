package com.vti.academy.web.service.impl;

import java.util.Optional;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.academy.web.exception.ClaimException;
import com.vti.academy.web.model.User;
import com.vti.academy.web.model.dto.CommonDTO;
import com.vti.academy.web.model.dto.RefreshTokenDTO;
import com.vti.academy.web.response.CommonResponse;
import com.vti.academy.web.service.AccountService;

@Service
@Transactional(rollbackFor = ClaimException.class)
public class AccountServiceImpl implements AccountService {
	private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Override
	public Optional<User> findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResponse resetPassword(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResponse changePassword(String account, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResponse getFirstLoginByAccount(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResponse updateAvatar(CommonDTO commonDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResponse getAccountInfo(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResponse getListAccountWhenLoginWithAccountAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findByDetailToken(JSONObject payload) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResponse genToken(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResponse getAuthenDetail(String accessToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResponse refreshToken(RefreshTokenDTO refreshTokenDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	

}


