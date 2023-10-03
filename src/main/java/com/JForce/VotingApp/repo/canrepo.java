package com.JForce.VotingApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JForce.VotingApp.entity.candidate;

public interface canrepo extends JpaRepository<candidate, Long> {
    
}
