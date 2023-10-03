package com.JForce.VotingApp.dto;

import java.util.Set;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DynamicUpdate
@DynamicInsert
public class VoterDTO {
    
	private String email;
	private String voterrole;
    private String username1;
    private Integer status;
    private String pass;
    private Long phoneNumber;
    private Set<String> roleNames;
 
    
}
