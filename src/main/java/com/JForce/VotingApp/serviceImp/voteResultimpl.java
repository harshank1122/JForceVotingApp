package com.JForce.VotingApp.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JForce.VotingApp.dto.voteReDto;
import com.JForce.VotingApp.entity.candidate;
import com.JForce.VotingApp.repo.canrepo;
import com.JForce.VotingApp.service.voteResult;

@Service
public class voteResultimpl implements voteResult {
     
	@Autowired
	private canrepo canrepo;
	
//		@Override
//	    public List<voteReDto> getAllresult() {
//	        List<candidate> candidates = canrepo.findAll();
//	        List<voteReDto> candidateDTOs = new ArrayList<>();
//
//	        for (candidate candidate : candidates) {
//	        	voteReDto dto = new voteReDto();
//	            dto.setName(candidate.getName());
//	            candidateDTOs.add(dto);
//	        }
//
//	        return candidateDTOs;
//	    }
	
	@Override
    public List<candidate> getAllCandidates1() {
        return canrepo.findAll();
    }

}
