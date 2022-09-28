package org.infatlan.personalizador.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.infatlan.personalizador.security.dto.AuthDto;
import org.infatlan.personalizador.security.dto.LoginDto;
import org.infatlan.personalizador.security.service.AuthService;
import org.infatlan.personalizador.security.util.JWTUtils;

@RestController
@RequestMapping("/auth")

public class AuthController {
	
	@Autowired
    AuthService authService; 

	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	private ResponseEntity<AuthDto> authCredentials(@RequestBody LoginDto loginDto) {

		loginDto.setUsername(loginDto.getUsername().toLowerCase());
		if (authService.validateAD(loginDto.getUsername(), loginDto.getPassword()) == true) {
			if (authService.getInfo(loginDto.getUsername()) != null) {
				String[] userData = authService.getInfo(loginDto.getUsername());
				
				 return ResponseEntity.status(HttpStatus.OK).body(
	                        new AuthDto(
	                            JWTUtils.getJWTToken(
	                                loginDto.getUsername(), 
	                                userData[0]
	                                ), 
	                                userData[2],
	                                userData[3]));

			}

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
	}
}
