package com.JForce.VotingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JForce.VotingApp.dto.VoterDTO;
import com.JForce.VotingApp.service.voterservice;

@RestController
@RequestMapping("/voter")
public class voterCon {
	
	@Autowired
	voterservice voterservice;
	
	@PostMapping("/create")
    public ResponseEntity<VoterDTO> createUser(@RequestBody VoterDTO userDTO) {
		VoterDTO createdUser = voterservice.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
