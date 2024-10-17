package com.example;

import com.example.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import java.util.List;

public interface PersonPagingAndSorting extends ListPagingAndSortingRepository<Person,Long> {

}
