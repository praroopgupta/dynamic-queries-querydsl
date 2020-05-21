package com.pg.dynamicqueriesquerydsl.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private Date dob;
	
	private String birthCity;
	
	private String birthState;
	
	private String birthCountry;

	public Person(String firstName, String lastName, Date dob, String birthCity, String birthState,
			String birthCountry) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.birthCity = birthCity;
		this.birthState = birthState;
		this.birthCountry = birthCountry;
	}

}
