package com.example;

import com.example.Person;
import org.springframework.data.jpa.domain.Specification;


public class PersonSpecifications {
   
    public static Specification<Person> hasName(String name) {
        return (root, query, builder) -> builder.equal(root.get("name"), name);
    }

    public static Specification<Person> hasCity(String city) {
        return (root, query, builder) -> {
            var addressJoin = root.join("address");
            return builder.like(builder.lower(addressJoin.get("city")), "%" + city.toLowerCase() + "%");
        };
    }
}
