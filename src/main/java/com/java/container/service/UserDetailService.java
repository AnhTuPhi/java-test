package com.java.container.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.java.container.dao.UserDetail;
import com.java.container.entity.User;
import com.java.container.repository.UserRepository;

public class UserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository repo;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repo.findByEmail(email);
		if(user ==null) {
			throw new UsernameNotFoundException("Could not foun");
		}
		return new UserDetail(user);
	}

}
