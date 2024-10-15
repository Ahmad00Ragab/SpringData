package com.example.demo;

import com.example.demo.Person;
import org.springframework.data.repository.ListCrudRepository;

public interface PersonListCrudRepository extends ListCrudRepository<Person, Long> {
}
