package com.vti.academy.web.configuration.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vti.academy.web.model.User;
import com.vti.academy.web.service.AccountService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AccountService accountServiceRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optional = accountServiceRepo.findByUserName(username);
		List<GrantedAuthority> grantList = new ArrayList<>();
		mapRoleToAuthority(grantList);
		UserSecurityLogged userSecurity = new UserSecurityLogged("username", "password",
				grantList);
		return userSecurity;
	}
	
	public UserDetails loadUserByToken(JSONObject payload) throws UsernameNotFoundException {
		Optional<User> optional = accountServiceRepo.findByDetailToken(payload);
		if (!optional.isPresent()) {
			throw new UsernameNotFoundException(payload.getString("username") + " not found !");
		}
		User account = optional.get();
		List<GrantedAuthority> grantList = new ArrayList<>();
		mapRoleToAuthority(grantList);
		UserSecurityLogged userSecurity = new UserSecurityLogged("username", "password",
				grantList);
		return userSecurity;
	}

	/**
	 * 
	 * @param grantList
	 * @param role
	 */
	private void mapRoleToAuthority(List<GrantedAuthority> grantList) {
				GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
				grantList.add(authority);
	}
}
