package com.example;

import java.util.List;
import java.util.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// Repository<User, Long>
// ListCrudRepository<Person, Long>
// PagingAndSortingRepository<Person, Long>
public interface PersonRepository extends JpaRepository<Person, Long>, CustomPersonRepository {
    
    /*  Query methods based on method name and  projection at the same time  */
    List<NamesOnly>  findByLastname(String lastname);

    /*  Pagination */
    Page<Person> findAll(Pageable pageable);

    /*  Stream results */
    @Query("SELECT p FROM Person p")
    Stream<Person> streamAll();
}
