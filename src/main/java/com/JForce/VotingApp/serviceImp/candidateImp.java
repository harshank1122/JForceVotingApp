package com.JForce.VotingApp.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JForce.VotingApp.dto.candidateDTO;
import com.JForce.VotingApp.dto.voteReDto;
import com.JForce.VotingApp.entity.Voter;
import com.JForce.VotingApp.entity.candidate;
import com.JForce.VotingApp.repo.VoterRpo;
import com.JForce.VotingApp.repo.canrepo;
import com.JForce.VotingApp.service.canditate;

@Service
public class candidateImp implements canditate {

	@Autowired
	private canrepo canrepo;
	
	@Autowired
	private VoterRpo rpo;

	@Override
    public List<candidateDTO> getAllCandidates() {
        List<candidate> candidates = canrepo.findAll();
        List<candidateDTO> candidateDTOs = new ArrayList<>();

        for (candidate candidate : candidates) {
            candidateDTO dto = new candidateDTO();
            dto.setCandidateName(candidate.getName());
            candidateDTOs.add(dto);
        }

        return candidateDTOs;
    }

	@Override
	public candidate voteForCandidate(voteReDto voteReDtos) {
		Long candidateId = voteReDtos.getId();
        String voterName = voteReDtos.getName();
        String email = voteReDtos.getEmail();
        
        Optional<candidate> optionalCandidate = canrepo.findById(candidateId);
        
        if (optionalCandidate.isPresent()) {
            candidate candidate = optionalCandidate.get();
            candidate.setVoteCount(candidate.getVoteCount() + 1);
            // Save the updated candidate
            canrepo.save(candidate);
            
            Optional<Voter> optionalVoter = rpo.findByEmail(email); // Replace voterId with the actual voter's ID
            if (optionalVoter.isPresent()) {
                Voter voter = optionalVoter.get();
                voter.setStatus(1); // Update the status to 1
                rpo.save(voter); // Save the updated voter
            }
            
            return candidate;
        }
        
		return null;
	}
}
