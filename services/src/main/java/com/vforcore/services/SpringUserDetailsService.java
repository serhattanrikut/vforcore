/**
 * 
 */
package com.vforcore.services;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.vforcore.model.aa.User;
import com.vforcore.repositories.user.UserRepository;

/**
 * @author stanriku
 *
 */
@Component
public class SpringUserDetailsService implements UserDetailsService{

	
	@Inject
	UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		return user;
	}

}
