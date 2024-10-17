package com.example;

import com.example.PersonSpecifications;
import com.example.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.eti.SpringDataLab.Repository",queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND)
public class SpringDataLabApplication {

	private final PersonPagingAndSorting personPagingAndSorting;

	public SpringDataLabApplication(PersonPagingAndSorting personPagingAndSorting) {
		this.personPagingAndSorting = personPagingAndSorting;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataLabApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PersonRepository repository, PersonRepositoryTwo personRepositoryTwo, PersonPagingAndSorting personPagingAndSorting, PersonRepositoryThree personRepositoryThree) {
		return args -> {

			Pageable pageable = Pageable.ofSize(1);
			System.out.println(personRepositoryThree.findSpecific());
			System.out.println(personRepositoryThree.findByLastname("Waleed"));
			System.out.println(personRepositoryThree.explicitlyNamedPlus1inout(5));
			System.out.println(personRepositoryThree.findByName("Saber"));
			System.out.println(personRepositoryThree.findBy("Mohab",pageable));
			System.out.println(personRepositoryThree.findByAddress_City("e"));
			System.out.println(personRepositoryThree.findByNameEndsWith("n"));
			System.out.println(repository.findAll(PersonSpecifications.hasName("saber").and(PersonSpecifications.hasCity("Alexandria"))));
		};
	}

}
