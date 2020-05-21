package com.pg.dynamicqueriesquerydsl.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pg.dynamicqueriesquerydsl.entity.Person;
import com.pg.dynamicqueriesquerydsl.request.SearchRequest;
import com.pg.dynamicqueriesquerydsl.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@PostMapping("/persons")
	public ResponseEntity<List<Person>> getPersonsDetails(@RequestBody SearchRequest request) throws ParseException {	
		List<Person> response =  service.getPersonsDetails(request);
		return new ResponseEntity<List<Person>>(response, HttpStatus.OK);
	}

}
