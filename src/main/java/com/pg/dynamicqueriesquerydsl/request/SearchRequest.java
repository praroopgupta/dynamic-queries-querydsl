package com.pg.dynamicqueriesquerydsl.request;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
	
	@Positive
	@NotNull
	private Integer limit;
	
	@PositiveOrZero
	@NotNull
	private Integer offset;
	
	private String dobFrom;
	
	private String dobTo;
	
	private String country;
	
	private String lastname;
	
	private String city;
	
	private String state;

}
