package com.JForce.VotingApp.dto;

import lombok.Builder;

@Builder
public class JwtResponse {
	
    private String jwtToken;
    private VoterDTO user;
    
    // Constructor
    public JwtResponse() {
    }
    
	public JwtResponse(String token, VoterDTO userDto) {
        this.jwtToken = token;
        this.user = userDto;
	}

	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public VoterDTO getUser() {
		return user;
	}
	public void setUser(VoterDTO user) {
		this.user = user;
	}
    
	
    
    
}
