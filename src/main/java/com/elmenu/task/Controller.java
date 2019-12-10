package com.elmenu.task;

import java.util.List;
import java.util.UUID;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entities.Restaurant;

@EnableAutoConfiguration
@RestController
public class Controller {

	@GetMapping(path = "/")
	public String sayHello() {
		return "Hello!! from Java Hungry";
	}
	
	 @PutMapping("/employees/{uuid}")
	  void replaceRestaurant(@RequestBody Restaurant newRestaurant, @PathVariable UUID id) {
		 
	 }
	 
	 @GetMapping("/employees")
	  List<Restaurant> all() {
	    return null;
	  }

	  @PostMapping("/employees")
	  Restaurant newEmployee(@RequestBody Restaurant newEmployee) {
	    return null;
	  }

	
	
	
}
