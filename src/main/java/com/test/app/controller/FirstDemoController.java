package com.test.app.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstDemoController {
	
		@RequestMapping("/")
	    public String index() {
	        return "index";//"Greetings from Spring Boot!";
	    }

		 @RequestMapping("/home")
		    public String home(Map<String, Object> model) {
		        model.put("message", "HowToDoInJava Reader !!");
		        return "home";
		    }
		     
		    @RequestMapping("/next")
		    public String next(Map<String, Object> model) {
		        model.put("message", "You are in new page !!");
		        return "next";
		    }
		    
		    @RequestMapping("/register")
		    public String register(Map<String, Object> model) {
		        model.put("message", "You are in new page !!");
		        return "registration";
		    }
}
