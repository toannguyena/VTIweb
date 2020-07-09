package com.vti.academy.web.service;

import java.util.Optional;

import org.json.JSONObject;

import com.vti.academy.web.model.User;
import com.vti.academy.web.model.dto.CommonDTO;
import com.vti.academy.web.model.dto.RefreshTokenDTO;
import com.vti.academy.web.response.CommonResponse;

public interface AccountService {

	Optional<User> findByUserName(String userName);
	
	CommonResponse resetPassword(String account);
	
	CommonResponse changePassword(String account, String oldPassword, String newPassword);
	
	CommonResponse getFirstLoginByAccount(String userName);
	
	CommonResponse updateAvatar(CommonDTO commonDTO);
	
	CommonResponse getAccountInfo(String userName);
	
	CommonResponse getListAccountWhenLoginWithAccountAdmin();
	
	Optional<User> findByDetailToken(JSONObject payload);
	
	CommonResponse genToken(String userName);
	
	CommonResponse getAuthenDetail(String accessToken);
	
	CommonResponse refreshToken(RefreshTokenDTO refreshTokenDTO);
	
}
