package com.codefider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codefider.entity.UserInfo;
import com.codefider.service.UserInfoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserInfoContoller {

	@Autowired
	UserInfoService userInfoService;

	//@Autowired
	//JwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/add")
	public ResponseEntity<Object> addUserDetails(@RequestBody UserInfo userInfo) {

		return new ResponseEntity<Object>(userInfoService.addUser(userInfo), HttpStatus.OK);

	}

	/*
	 * @PostMapping("/authenticate") public String
	 * authenticatAndGetToken(@RequestBody AuthRequest authRequest) throws Exception
	 * { Authentication authentication = null; try { authentication =
	 * authenticationManager.authenticate( new
	 * UsernamePasswordAuthenticationToken(authRequest.getUsername(),
	 * authRequest.getPassword())); } catch (Exception e) {
	 * System.out.println(e.getMessage()); } if (authentication != null &&
	 * authentication.isAuthenticated()) { return
	 * jwtService.genrateToken(authRequest.getUsername()); } else { return
	 * "Invalid user request!!";
	 * 
	 * }
	 * 
	 * }
	 */

}
