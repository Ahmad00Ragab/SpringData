package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface PersonCrudRepository extends CrudRepository<Person, Long> {

}
