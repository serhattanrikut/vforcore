/**
 * 
 */
package com.vforcore.rest.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * This will call once the request is authenticated. If it is not, the request
 * will be redirected to authenticate entry point
 * 
 * @author stanriku
 *
 */
@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request,
			final HttpServletResponse response, final Authentication authentication)
			throws ServletException, IOException {
		// You can do something here for which is success requests
	}

}
