/**
 * 
 */
package com.test.app;

import org.apache.catalina.connector.Connector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.CommandLineRunner;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.json.XML;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;

import com.howtodoinjava.xml.school.StudentDetailsRequest;
import com.howtodoinjava.xml.school.StudentDetailsResponse;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.test.app.jms_templat.Message;
import com.test.app.sop.config.SOAPConnector;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
/*
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;*/
/**
 * @author kgkumar
 *
 */

//component , configuration, enableautoConfiguration, -> resolve server context dependency missing issue 
//else we need to add TomcatEmbeddedServletContainerFactory @Bean

@SpringBootApplication (exclude = SecurityAutoConfiguration.class) //for exclude auto configuration at same time of running
@Configuration
@ComponentScan
@EnableAutoConfiguration (excludeName = {"multipartResolver","mbeanServer"})
//@SpringBootConfiguration
public class MainApplication {
	  private static final Logger LOGGER = LogManager.getLogger(MainApplication.class);
	  

/*	 public static int PRETTY_PRINT_INDENT_FACTOR = 4;
	    public static String TEST_XML_STRING =
	        "<test attrib=\"moretest\">Turn this to JSON</test>";*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx =	SpringApplication.run(MainApplication.class, args);
		
		LOGGER.info("Info level log message");
        LOGGER.debug("Debug level log message");
        LOGGER.error("Error level log message");
		
		//if we need to check beans and config logs
		/*String[] beanNames = ctx.getBeanDefinitionNames();
        
        Arrays.sort(beanNames);
 
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }*/
		
        

        // Launch JMS with the application
        //Get JMS template bean reference
        JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
 
        // Send a message
        System.out.println("Sending a message.");
        jmsTemplate.convertAndSend("jms.message.endpoint", new Message(1001L, "test body", new Date()));
      
        
        //RSS ATOM and Feed Reader
        
        try {
            String url = "https://localhost:8080/rss";
 
            try (XmlReader reader = new XmlReader(new URL(url))) {
                SyndFeed feed = new SyndFeedInput().build(reader);
                System.out.println(feed.getTitle());
                System.out.println("***********************************");
                for (SyndEntry entry : feed.getEntries()) {
                    System.out.println(entry);
                    System.out.println("***********************************");
                }
                System.out.println("Done");
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
		
/*
 * json mapping code for xml conversion
		        try {
		            JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
		            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
		            System.out.println(jsonPrettyPrintString);
		        } catch (JSONException je) {
		            System.out.println(je.toString());
		        }*/
		
		/*String data = ""+
                "<student>"+
                "<age>11</age>"+
                "<id>12</id>"+
                "<name>JavaInterviewPoint</name>"+
             "</student>";
        
        try
        {
            // Create a new XmlMapper to read XML tags
            XmlMapper xmlMapper = new XmlMapper();
            
            //Reading the XML
            JsonNode jsonNode = xmlMapper.readTree(data.getBytes());
            
            //Create a new ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            
            //Get JSON as a string
            String value = objectMapper.writeValueAsString(jsonNode);
            
            System.out.println("*** Converting XML to JSON ***");
            System.out.println(value);
            

        } catch (JsonParseException e)
        {
            e.printStackTrace();
        } catch (JsonMappingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }*/
	}

	
	// jetty configuration custom can set by application.properties or by bean
	/*@Bean
	public ConfigurableServletWebServerFactory webServerFactory()
	{
	    JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
	    factory.setPort(9000);
	    factory.setContextPath("/myapp");
	    factory.addErrorPages(new org.springframework.boot.web.server.ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
	    return factory;
	}*/
	
	
	/* 
	 * request change from http to https , use with bean or use with application properties
	 */
	/*@Bean
	public EmbeddedServletContainerFactory servletContainer() {
	  TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
	      @Override
	      protected void postProcessContext(Context context) {
	        SecurityConstraint securityConstraint = new SecurityConstraint();
	        securityConstraint.setUserConstraint("CONFIDENTIAL");
	        SecurityCollection collection = new SecurityCollection();
	        collection.addPattern("/*");
	        securityConstraint.addCollection(collection);
	        context.addConstraint(securityConstraint);
	      }
	    };
	   
	  tomcat.addAdditionalTomcatConnectors(redirectConnector());
	  return tomcat;
	}*/
	 //callwith above bean
/*	private Connector redirectConnector() {
	  Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
	  connector.setScheme("http");
	  connector.setPort(8080);
	  connector.setSecure(false);
	  connector.setRedirectPort(8443);
	   
	  return connector;
	}*/
	
	@Bean
	public SpringBootServletInitializer jerseyConfig() {
		SpringBootServletInitializer sb=	new SpringBootServletInitializer() {
			 @Override
			    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			        return application.sources(MainApplication.class);
			    }
		};
		
		return sb ;
	}
	
	/*extends SpringBootServletInitializer {
		 
	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SpringBootWebApplication.class);
	    }*/
	
	
	//jetty,jersey, devctool, sop webservices, sop client
	
	//command line bean runner, for sop client
	/* @Bean
	    CommandLineRunner lookup(SOAPConnector soapConnector) {
	        return args -> {
	            String name = "Sajal";//Default Name
	            if(args.length>0){
	                name = args[0];
	            }
	            com.howtodoinjava.xml.student.StudentDetailsRequest request = new com.howtodoinjava.xml.student.StudentDetailsRequest();
	            request.setName(name);
	            com.howtodoinjava.xml.student.StudentDetailsResponse response =(com.howtodoinjava.xml.student.StudentDetailsResponse) soapConnector.callWebService("http://localhost:8080/service/student-details", request);
	            System.out.println("Got Response As below ========= : ");
	            System.out.println("Name : "+response.getStudent().getName());
	            System.out.println("Standard : "+response.getStudent().getStandard());
	            System.out.println("Address : "+response.getStudent().getAddress());
	        };
	    }*/
}


