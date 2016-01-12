package com.vforcore.services;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.vforcore.model.aa.Role;
import com.vforcore.repositories.role.RoleRepository;

@Transactional
public class RoleRepositoryTest extends BaseServiceTest {

	@Inject
	private RoleRepository roleRepository;
	
	
	@Test
	public void testFindByName() throws Exception {
		Role role = createRoleMember();
		role = roleRepository.saveAndFlush(role);
		Assert.assertNotNull(role);
		
		roleRepository.findByName(role.getName());
		Assert.assertNotNull(role);
	}
	
	@Test
	public void testFindAll() throws Exception {
		Role role = createRoleMember();
		role = roleRepository.saveAndFlush(role);
		Assert.assertNotNull(role);
		
		Role role2 = createRoleAnonymous();
		role2 = roleRepository.saveAndFlush(role2);
		
		List<Role> findAll = roleRepository.findAll();
		Assert.assertNotNull(findAll);
		Assert.assertNotNull(findAll.get(0));
		Assert.assertEquals(2, findAll.size());
	}

}
