package com.example;

import java.util.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional; // Ensure this import is present

import java.util.stream.Stream;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    public Page<Person> getPersonsPaged(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    public List<NamesOnly> getNamesByLastname(String lastname) {
        return personRepository.findByLastname(lastname);
    }

    /* @Transactional for streams */
    @Transactional(readOnly = true) 
    public Stream<Person> streamAllPersons() {
        return personRepository.streamAll();
    }

      // New method to find persons with age above a certain value
      public List<Person> findPersonsWithAgeAbove(int age) {
        return personRepository.findPersonsWithAgeAbove(age);
    }

}
