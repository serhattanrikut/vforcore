/**
 * 
 */
package com.vforcore.rest.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vforcore.repositories.user.UserRepository;
import com.vforcore.rest.dto.User;
import com.vforcore.rest.handlers.error.AppException;

/**
 * @author stanriku
 *
 */
@Component
@Path("/users")
@Secured("ROLE_ADMIN")
public class UsersResource {
	
	
	@Inject
	private UserRepository userRepository;
	
	/**
	 * Returns all resources (podcasts) from the database
	 * 
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 * @throws AppException
	 */
	@GET
	//@Compress //can be used only if you want to SELECTIVELY enable compression at the method level. By using the EncodingFilter everything is compressed now. 
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<User> getUsers(
			@QueryParam("orderByInsertionDate") String orderByInsertionDate,
			@QueryParam("numberDaysToLookBack") Integer numberDaysToLookBack)
			throws IOException,	AppException {
		
		List<com.vforcore.model.aa.User> allModelUsers = userRepository.findAll();
		
		List<User> users = new ArrayList<User>();
		for (com.vforcore.model.aa.User mu : allModelUsers) {
			User user = new User(mu.getId(), mu.getCreated(), mu.getLastName(), mu.getLastName(), mu.getEmail(), mu.getUsername(), mu.isCredentialsNonExpired(), mu.isAccountNonLocked(), mu.isAccountNonExpired(), mu.isEnabled());
			users.add(user);
		}
		
		
		return users;
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getPodcastById(@PathParam("id") Long id, @QueryParam("detailed") boolean detailed)
			throws IOException,	AppException {
		
		com.vforcore.model.aa.User mu = userRepository.findOne(id);
		User user = new User(mu.getId(), mu.getCreated(), mu.getLastName(), mu.getLastName(), mu.getEmail(), mu.getUsername(), mu.isCredentialsNonExpired(), mu.isAccountNonLocked(), mu.isAccountNonExpired(), mu.isEnabled());
		return Response.status(200)
				.entity(user)
				.header("Access-Control-Allow-Headers", "X-extra-header")
				.allow("OPTIONS").build();
	}


	
}
