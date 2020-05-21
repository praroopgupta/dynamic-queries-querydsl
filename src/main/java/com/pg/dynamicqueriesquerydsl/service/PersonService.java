package com.pg.dynamicqueriesquerydsl.service;

import java.text.ParseException;
import java.util.List;

import com.pg.dynamicqueriesquerydsl.entity.Person;
import com.pg.dynamicqueriesquerydsl.request.SearchRequest;

public interface PersonService {

	List<Person> getPersonsDetails(SearchRequest request) throws ParseException;

}
