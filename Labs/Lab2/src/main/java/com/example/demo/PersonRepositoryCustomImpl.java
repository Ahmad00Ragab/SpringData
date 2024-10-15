package com.example.demo;

import com.example.demo.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Person> findCustomPeople() {
        return em.createQuery("SELECT p FROM Person p WHERE p.name LIKE '%John%'", Person.class)
                 .getResultList();
    }
}
