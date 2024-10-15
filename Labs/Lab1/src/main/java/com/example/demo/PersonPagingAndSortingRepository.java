package com.example.demo;

import com.example.demo.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonPagingAndSortingRepository extends PagingAndSortingRepository<Person, Long> {
    // Sorting and paging methods are built-in
}
