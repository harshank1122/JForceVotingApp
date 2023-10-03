package com.JForce.VotingApp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.JForce.VotingApp.dto.JwtRequest;
import com.JForce.VotingApp.dto.JwtResponse;
import com.JForce.VotingApp.dto.VoterDTO;
import com.JForce.VotingApp.service.voterservice;
import com.JForce.VotingApp.squrity.jwtHelper;



@RestController
@RequestMapping("/auth")
//@CrossOrigin(
//origins = "http://localhost:4200",
//allowedHeaders = {"Authorization"},
//methods = {RequestMethod.GET,RequestMethod.POST},
//maxAge = 3600
//)
public class AuthController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private voterservice userService;

	@Autowired
	private jwtHelper helper;


//	@Value("${newPassword}")
//	private String newPassword;

	private Logger logger = LoggerFactory.getLogger(AuthController.class);

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
		doAuthenticate(request.getEmail(), request.getPassword());
		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
		String token = this.helper.generateToken(userDetails);
		System.out.println(token);
		VoterDTO savedUserDTO = new VoterDTO();
		BeanUtils.copyProperties(userDetails, savedUserDTO);
		JwtResponse response = new JwtResponse(token, savedUserDTO);
		System.out.println(response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new RuntimeException(" Invalid Username or Password  !!");
        }

    }
	
    @GetMapping("/current")
    public ResponseEntity<VoterDTO> getCurrentUser(Principal principal) {
        String name = principal.getName();
        System.out.println("ddd" + name);
        UserDetails userDetails = userDetailsService.loadUserByUsername(name);
        VoterDTO empDetailsDTO = new VoterDTO();
        BeanUtils.copyProperties(userDetails, empDetailsDTO);
        return new ResponseEntity<>(empDetailsDTO, HttpStatus.OK);

    }
	

	

}
