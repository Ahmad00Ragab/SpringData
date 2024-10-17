package com.example;

import com.example.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PersonRepositoryThree extends JpaRepository<Person, Long> {
    @Query("SELECT p FROM Person p WHERE p.name LIKE %?1")
    List<Person> findByNameEndsWith(String name);

    @Query("SELECT p FROM Person p  where p.address.city LIKE LOWER(CONCAT('%', :city, '%'))")
    List<Person> findByAddress_City(@Param("city")String city);

    @Query(value = "SELECT * FROM PERSON WHERE NAME = ?1",
            countQuery = "SELECT count(*) FROM PERSON WHERE NAME = ?1",
            nativeQuery = true)
    Page<Person> findBy(String name, Pageable pageable);
    List<Person> findSpecific();
    Person findByName(String name);
    @Query("select u from #{#entityName} u where u.name = ?1")
    List<Person> findByLastname(String lastname);
    @Procedure(procedureName = "plus1inout")
    Integer explicitlyNamedPlus1inout(Integer arg);

}
