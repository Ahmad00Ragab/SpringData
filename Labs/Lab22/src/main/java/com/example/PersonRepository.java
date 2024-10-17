package com.example;

import com.example.Person;
import com.example.NamesOnly;
import org.hibernate.transform.ToListResultTransformer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.stream.Stream;

/*  Query Creation */
public interface PersonRepository extends CustomRepository<Person,Long>, JpaSpecificationExecutor<Person> {
    List<Person> findByAddress_City(String address_city);
    Person findFirstByOrderByNameAsc();
    Person findTopByOrderByNameDesc();
    Stream<Person> findAll();
    Page<Person> findAll(Pageable pageable);
    List<NamesOnly> findBy();
    List<Person> findAll(Specification<Person> specs);
}
