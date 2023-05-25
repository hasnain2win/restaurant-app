package com.codefider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codefider.entity.UserInfo;
import com.codefider.repo.UserInfoRepository;

@Service
public class UserInfoService {

	@Autowired
	UserInfoRepository userInfoRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtService jwtService;

	public String addUser(UserInfo userInfo) {

		userInfo.setPassword(encoder.encode(userInfo.getPassword()));
		userInfo = userInfoRepository.save(userInfo);
		return "User added to DB";
	}

	public String genrateToken(String username) {
		return jwtService.genrateToken(username);
	}

	public void validatedToken(String token) {
		jwtService.validateToken(token);
	}
}
