package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;

@RestController
public class HelloWorldController {

	@GetMapping("/api")
	public String helloworld() {
		return "hello world";
	}
}
