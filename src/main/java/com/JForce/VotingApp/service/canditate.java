package com.JForce.VotingApp.service;

import java.util.List;

import com.JForce.VotingApp.dto.candidateDTO;
import com.JForce.VotingApp.dto.voteReDto;
import com.JForce.VotingApp.entity.candidate;


public interface canditate {
	List<candidateDTO> getAllCandidates();
	candidate voteForCandidate(voteReDto voteReDtos);
}
