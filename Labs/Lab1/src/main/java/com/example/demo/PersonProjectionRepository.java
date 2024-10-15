package com.example.demo;

import java.util.*;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonProjectionRepository extends ListCrudRepository<Person, Long> {
    List<PersonNameProjection> findByName(@Param("name") String name);
}
