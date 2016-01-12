/**
 * 
 */
package com.vforcore.rest.resources.test.integration;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vforcore.repositories.user.UserRepository;
import com.vforcore.rest.dto.User;

/**
 * @author stanriku
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/logging-application-config.xml","classpath*:services-context-test.xml"})
public class UsersResourceTestsIT {
	
	@Inject
	UserRepository userRepository;
	
	@BeforeClass
	public static void init() {
		//System.setProperty("spring.profiles.active", "dev");
		//System.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
	}
	
	@Test
	public void testGetUsers() throws JsonGenerationException,
			JsonMappingException, IOException {
		
		com.vforcore.model.aa.User userModel = new com.vforcore.model.aa.User("Serhat", "Tanrikut", "serhatt@gmail.com", "serhatt", "serhatt", true, true, true, true);
		
		userModel = userRepository.save(userModel);
		userRepository.flush();
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonFeature.class);

		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client
				.target("http://localhost:8080/web/api/users/");

		Builder request = webTarget.request();
		request.header("Content-type", MediaType.APPLICATION_JSON);

		Response response = request.get();
		Assert.assertTrue(response.getStatus() == 200);

		List<User> users = response
				.readEntity(new GenericType<List<User>>() {
				});

		ObjectMapper mapper = new ObjectMapper();
		System.out.print(mapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(users));

		Assert.assertTrue("At least one user is present",
				users.size() > 0);
	}
	
	@Test
	public void testGetUserById() throws JsonGenerationException,
			JsonMappingException, IOException {
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonFeature.class);

		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client
				.target("http://localhost:8080/web/api/users/1");

		Builder request = webTarget.request();
		request.header("Content-type", MediaType.APPLICATION_JSON);

		Response response = request.get();
		Assert.assertTrue(response.getStatus() == 200);

		User user = response
				.readEntity(new GenericType<User>() {
				});

		ObjectMapper mapper = new ObjectMapper();
		System.out.print(mapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(user));

		Assert.assertNotNull("User must be presented by id",user);
	}

}
