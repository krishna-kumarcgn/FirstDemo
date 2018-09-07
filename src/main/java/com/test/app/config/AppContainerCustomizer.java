package com.test.app.config;

//import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;
 
// set the port, address, error pages etc. for embedded tomcat container or set by appplication.properties file , or create by bean

@Component
public class AppContainerCustomizer //implements EmbeddedServletContainerCustomizer 
{
 /*
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
 
        container.setPort(9000);
 
  container.setContextPath("/home"); //custom path for context application or set by application.properties
    }*/
}