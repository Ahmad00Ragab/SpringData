package com.example;

import jakarta.persistence.*;
import java.util.*;



public class CustomPersonRepositoryImpl implements CustomPersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> findPersonsWithAgeAbove(int age) {
        TypedQuery<Person> query = entityManager.createQuery(
                "SELECT p FROM Person p WHERE p.age > :age", Person.class);
        query.setParameter("age", age);
        return query.getResultList();
    }
}
