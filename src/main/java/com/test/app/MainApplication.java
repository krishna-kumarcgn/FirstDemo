/**
 * 
 */
package com.test.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.json.XML;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Arrays;
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

@Configuration
@ComponentScan
@EnableAutoConfiguration (excludeName = {"multipartResolver","mbeanServer"})
@SpringBootConfiguration
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
		String[] beanNames = ctx.getBeanDefinitionNames();
        
        Arrays.sort(beanNames);
 
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
		
		
/*
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

}


