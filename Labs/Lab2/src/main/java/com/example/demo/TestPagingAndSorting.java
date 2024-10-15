package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class TestPagingAndSorting implements CommandLineRunner {

    @Autowired
    private PersonPagingAndSortingRepository repository;

    @Override
    public void run(String... args) throws Exception {
        // Create Pageable object with page number, page size, and sorting
        Pageable pageable = PageRequest.of(0, 5, Sort.by("name").ascending());
        repository.findAll(pageable).forEach(System.out::println);
    }
}
