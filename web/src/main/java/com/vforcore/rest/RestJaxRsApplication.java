/**
 * 
 */
package com.vforcore.rest;

import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;

/**
 * @author stanriku
 *
 * The class defines the components (root resource and provider classes,) of the JAX-RS application
 */
public class RestJaxRsApplication extends ResourceConfig {
	
	/**
	 * Register JAX-RS application components.
	 */
	@SuppressWarnings("unchecked")
	public RestJaxRsApplication() {
		// register application resources
		packages("com.vforcore.rest");

		// register features
		register(EntityFilteringFeature.class);
		EncodingFilter.enableFor(this, GZipEncoder.class);
	}

}
