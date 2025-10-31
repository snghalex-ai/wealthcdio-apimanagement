package com.kata.nw.submersible.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kata.nw.submersible.dto.LoginRequestDTO;
import com.kata.nw.submersible.security.JwtUtil;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthorizationController {
	
	@PostMapping(value="/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
		// Authenticate the user (e.g., using Spring Security's authentication manager)
		// If authentication is successful, generate a JWT
		String token = JwtUtil.generateToken(request.getUserName());
		return new ResponseEntity<>("token : "+token, HttpStatus.OK);
	}
}