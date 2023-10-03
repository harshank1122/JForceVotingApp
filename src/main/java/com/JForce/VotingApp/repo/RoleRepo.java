package com.JForce.VotingApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JForce.VotingApp.entity.Role;


public interface RoleRepo extends JpaRepository<Role,String> {
	Role findByRoleName(String roleName);
} 


