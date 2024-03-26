package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
	
public HelloController() {
		super();
		// TODO Auto-generated constructor stub
	}

@GetMapping("/")
	public String reading () {
		return "Hello world";
	}
	



@GetMapping("/secured")
public String Secured () {
	return "if u see this,  then you're  Logged in ";
}






}
