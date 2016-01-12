package com.vforcore.services;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.vforcore.model.aa.Role;
import com.vforcore.model.aa.User;
import com.vforcore.repositories.role.RoleRepository;
import com.vforcore.repositories.user.UserRepository;

@Transactional
public class UserRepositoryTest extends BaseServiceTest {

	@Inject
	private UserRepository userRepository;
	
	@Inject
	private RoleRepository roleRepository;
	
	@Test
	public void testFindByUsername() throws Exception {
		Role member = createRoleMember();
		member = roleRepository.saveAndFlush(member);
		
		User user = createUser1();
		user.setRole(member);
		userRepository.saveAndFlush(user);
		
		userRepository.findByUsername(user.getUsername());
		Assert.assertNotNull(user);
	}
	
	
	@Test
	public void testDelete() throws Exception {
		Role member = createRoleMember();
		member = roleRepository.saveAndFlush(member);
		
		User user = createUser1();
		user.setRole(member);
		userRepository.saveAndFlush(user);
		
		userRepository.findByUsername(user.getUsername());
		Assert.assertNotNull(user);
		
		userRepository.delete(user);
		
		member = roleRepository.findByName(member.getName());
		Assert.assertNotNull(member);
	}
	
	@Test
	public void testFindAll() throws Exception {
		Role member = createRoleMember();
		member = roleRepository.saveAndFlush(member);
		
		User user = createUser1();
		user.setRole(member);
		userRepository.saveAndFlush(user);
		
		
		user = createUser2();
		user.setRole(member);
		userRepository.saveAndFlush(user);
	
		
		List<User> findAll = userRepository.findAll();
		Assert.assertNotNull(findAll);
		Assert.assertNotNull(findAll.get(1));
	}

}
