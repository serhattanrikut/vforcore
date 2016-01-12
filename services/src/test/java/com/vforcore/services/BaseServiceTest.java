/**
 * 
 */
package com.vforcore.services;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vforcore.model.aa.Role;
import com.vforcore.model.aa.RoleEnum;
import com.vforcore.model.aa.User;

/**
 * @author stanriku
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration(locations = {"classpath*:spring/logging-application-config.xml","classpath:services-context-test.xml"})
public abstract class BaseServiceTest {

	
	// mocking methods
	
	public User createUser(String firstName, String lastName, String email, String username, String password,
			boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
		User user = createUser(firstName, 
				lastName, 
				email, 
				username, 
				password, 
				accountNonExpired, 
				accountNonLocked, 
				credentialsNonExpired, 
				enabled,null);
		return user;
	}
	
	public User createUser(String firstName, String lastName, String email, String username, String password,
			boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled,
			Role role) {
		User user = new User(firstName, 
				lastName, 
				email, 
				username, 
				password, 
				accountNonExpired, 
				accountNonLocked, 
				credentialsNonExpired, 
				enabled);
		return user;
	}
	
	public User createUser1() {
		User user1 = createUser("User1", "Tanrikut", "s.t@gmail.com", "User1", "User1", true, true, true, true);
		return user1;
	}
	
	public User createUser2() {
		User user1 = createUser("User2", "noone", "n.n@gmail.com", "User2", "User2", true, true, true, true);
		return user1;
	}
	
	public Role createRole(String name, String description) {
		Role role = new Role(name, description);
		return role;
	}
	
	public Role createRoleMember() {
		Role role = createRole(RoleEnum.MEMBER.name(), "regular member");
		return role;
	}
	
	public Role createRoleAnonymous() {
		Role role = createRole(RoleEnum.ANONYMOUS.name(), "Anonymous member");
		return role;
	}
}
