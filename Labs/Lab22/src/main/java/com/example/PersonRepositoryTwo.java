package com.example;

import com.example.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

/*
* CrudRepository have a lot of function that can be used that made my Repo as marker
* It Return List as CRUD return iteratable */
public interface PersonRepositoryTwo extends ListCrudRepository<Person, Long> {

}
