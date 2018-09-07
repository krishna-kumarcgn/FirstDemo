package com.test.app.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.test.app.filter.SecurityFilter;
import com.test.app.jersey.jax_resource.UserResource;
 
//jersey support JAX api
@Component
public class JerseyConfig extends ResourceConfig
{
	//ResourceConfig provides advanced capabilities to simplify registration of JAX-RS components.
	
    public JerseyConfig()
    {
    	register(SecurityFilter.class); //when add security roles
        register(UserResource.class);
    }
}