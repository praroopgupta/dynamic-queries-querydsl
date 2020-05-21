package com.pg.dynamicqueriesquerydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.pg.dynamicqueriesquerydsl.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> , QuerydslPredicateExecutor<Person> {

}
