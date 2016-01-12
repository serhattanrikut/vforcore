/**
 * 
 */
package com.vforcore.repositories.role;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vforcore.model.aa.Role;

/**
 * @author stanriku
 *
 */
public interface RoleRepository extends JpaRepository<Role, Serializable> {

	@Query("SELECT _role FROM Role _role WHERE LOWER(_role.name) = LOWER(:name)")
	public Role findByName(@Param("name") String name);
	
}
