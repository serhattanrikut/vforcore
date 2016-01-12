/**
 * 
 */
package com.vforcore.repositories.user;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vforcore.model.aa.User;

/**
 * @author stanriku
 *
 */
public interface UserRepository extends JpaRepository<User, Serializable> {
	
	@Query("SELECT _user FROM User _user WHERE LOWER(_user.username) = LOWER(:username)")
	public User findByUsername(@Param("username") String username);
}
