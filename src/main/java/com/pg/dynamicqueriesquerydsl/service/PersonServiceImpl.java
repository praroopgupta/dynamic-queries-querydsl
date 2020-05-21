package com.pg.dynamicqueriesquerydsl.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pg.dynamicqueriesquerydsl.entity.Person;
import com.pg.dynamicqueriesquerydsl.entity.QPerson;
import com.pg.dynamicqueriesquerydsl.filter.LimitOffsetPageRequestFilter;
import com.pg.dynamicqueriesquerydsl.repository.PersonRepository;
import com.pg.dynamicqueriesquerydsl.request.SearchRequest;
import com.pg.dynamicqueriesquerydsl.util.OptionalBooleanBuilderUtil;
import com.querydsl.core.types.Predicate;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository repository;

	@Override
	public List<Person> getPersonsDetails(SearchRequest request) throws ParseException {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Pageable pageable = new LimitOffsetPageRequestFilter(request.getLimit(), request.getOffset()); 
		final QPerson person = QPerson.person;
		Predicate query = new OptionalBooleanBuilderUtil(person.isNotNull())
                .notNullAnd(person.birthCity::containsIgnoreCase, request.getCity())
                .notNullAnd(person.birthCountry::containsIgnoreCase, request.getCountry())
                .notNullAnd(person.birthState::containsIgnoreCase, request.getState())
                .notNullAnd(person.lastName::containsIgnoreCase, request.getLastname())
                .notNullAnd(person.dob::after, !StringUtils.isEmpty(request.getDobFrom()) ? format.parse(request.getDobFrom()) : null)
                .notNullAnd(person.dob::before, !StringUtils.isEmpty(request.getDobTo()) ? format.parse(request.getDobTo()) : null)
                .build();
		return repository.findAll(query, pageable).getContent();
	}

}
