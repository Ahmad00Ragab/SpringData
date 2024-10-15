// package com.example.demo;

// import com.example.demo.Person;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.ListCrudRepository;

// import java.util.List;

// public interface PersonRepository extends ListCrudRepository<Person, Long> {

//     // Deriving query from method name
//     List<Person> findByName(String name);

//     // Manually defined query
//     @Query("SELECT p FROM Person p WHERE p.name = ?1")
//     List<Person> findByNameWithQuery(String name);
// }
