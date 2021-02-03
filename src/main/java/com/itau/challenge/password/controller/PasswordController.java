package com.itau.challenge.password.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.itau.challenge.password.validator.PasswordValidator;
import com.itau.challenge.password.dto.PasswordDTO;

@RestController
@RequestMapping("/api")
public class PasswordController {

	@Autowired
	private PasswordValidator validator;

	@PostMapping("/password")
	public boolean isPasswordValid(@RequestBody @Valid PasswordDTO dto) {
		return validator.isValid(dto.getPassword());
	}

}
