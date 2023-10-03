package com.JForce.VotingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JForce.VotingApp.dto.candidateDTO;
import com.JForce.VotingApp.dto.voteReDto;
import com.JForce.VotingApp.entity.candidate;
import com.JForce.VotingApp.service.canditate;
import com.JForce.VotingApp.service.voteResult;
import com.JForce.VotingApp.service.voterservice;

@RestController
@RequestMapping("/candidates")
public class candidatecontroller {
	
	@Autowired
	private canditate  candidateService;
	
	@Autowired
	private voteResult  voteResults;
	
	@GetMapping
    public List<candidateDTO> getAllCandidates() {
    	System.out.println(candidateService.getAllCandidates());
        return candidateService.getAllCandidates();
    }
    
//    @GetMapping("result")
//    public List<voteReDto> getAllresult() {
//        return voteResults.getAllresult();
//    }
    
    @GetMapping("/all")
    public List<candidate> getAllCandidates1() {
        return voteResults.getAllCandidates1();
    }
    
    @PostMapping("/vote")
    public ResponseEntity<?> voteForCandidate(@RequestBody voteReDto voteRequest) {
        candidate candidate = candidateService.voteForCandidate(voteRequest);
        
        if (candidate != null) {
            return ResponseEntity.ok(candidate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
