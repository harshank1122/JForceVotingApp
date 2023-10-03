package com.JForce.VotingApp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JForce.VotingApp.entity.Voter;

public interface VoterRpo extends JpaRepository<Voter,String>  {
	Optional<Voter> findByEmail(String email);
}
