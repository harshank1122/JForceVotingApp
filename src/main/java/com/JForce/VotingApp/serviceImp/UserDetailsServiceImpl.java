package com.JForce.VotingApp.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.JForce.VotingApp.entity.Voter;
import com.JForce.VotingApp.repo.VoterRpo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {



	@Autowired
	private VoterRpo  userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("fff" + username);
		Voter user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User with given email not found !!"));
		return user;
	}

}
