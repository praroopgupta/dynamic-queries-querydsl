package com.pg.dynamicqueriesquerydsl;

import java.sql.Date;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pg.dynamicqueriesquerydsl.entity.Person;
import com.pg.dynamicqueriesquerydsl.repository.PersonRepository;

@SpringBootApplication
public class DynamicQueriesQuerydslApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicQueriesQuerydslApplication.class, args);
	}
	
	@SuppressWarnings("deprecation")
	@Bean
    public CommandLineRunner specificationsDemo(PersonRepository personRepository) {
		
        return args -> {

            // create new persosn
        	/**
        	personRepository.saveAll(Arrays.asList(
                    new Person("Ram", "Sharma", new Date(1995-1900, 02, 10), "kochi", "kerala", "india"),
                    new Person("Shyam", "Sharma", new Date(2016-1900, 12, 15), "gandhinagar", "gujrat", "india"),
                    new Person("Hari", "Sharma", new Date(2020-1900, 02, 26), "kota", "rajasthan", "india"),
                    new Person("Shrey", "Sharma", new Date(2008-1900, 12, 30), "ernakulam", "kerala", "india"),
                    new Person("Shubham", "Sharma", new Date(1999-1900, 06, 10), "jaipur", "rajasthan", "india")
            ));
            */
        };
    }
}
