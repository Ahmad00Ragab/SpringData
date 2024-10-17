package com.example;


import com.example.Person;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@NoRepositoryBean
public interface CustomRepository<T, ID> extends Repository<T, ID> {
    T save(T person);
    Optional<T> findById(ID id);
}
