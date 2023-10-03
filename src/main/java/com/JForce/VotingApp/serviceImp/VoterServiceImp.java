package com.JForce.VotingApp.serviceImp;


import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.JForce.VotingApp.dto.VoterDTO;
import com.JForce.VotingApp.entity.Role;
import com.JForce.VotingApp.entity.Voter;
import com.JForce.VotingApp.repo.RoleRepo;
import com.JForce.VotingApp.repo.VoterRpo;
import com.JForce.VotingApp.service.voterservice;

@Service
public class VoterServiceImp implements voterservice {
    
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Value("${admin.role.id}")
    private String Admin;
    
    @Value("${normal.role.id}")
    private String normal;

	@Autowired
	private VoterRpo userRepository;
	
    @Autowired
    private RoleRepo roleRepository;
	
	@Override
	public VoterDTO createUser(VoterDTO userDTO) {
		
		String roleName = "ROLE_NORMAL";
		
		Optional<Voter> existingUserOptional = userRepository.findByEmail(userDTO.getEmail());
		
		if (existingUserOptional.isPresent()) {
	        throw new RuntimeException("Email already exists!"); // You can choose a more specific exception type
	    }
		
		userDTO.setPass(passwordEncoder.encode(userDTO.getPass()));
		userDTO.setVoterrole(roleName);
		userDTO.setStatus(0);
		Voter newUser = new Voter();
		
		BeanUtils.copyProperties(userDTO, newUser);
		
		
		Role role = roleRepository.findByRoleName(roleName);
	    if (role == null) {
	        throw new RuntimeException("Role not found!");
	    }
	    newUser.getRoles().add(role);
		
		Voter savedUser = userRepository.save(newUser);
		VoterDTO savedUserDTO = new VoterDTO();
		BeanUtils.copyProperties(savedUser, savedUserDTO);
		return savedUserDTO;
	}
   
}
