package com.example.demo;

import com.example.demo.Person;
import com.example.demo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Insert data into the database
        Person person1 = new Person();
        person1.setName("John");
        personRepository.save(person1);

        Person person2 = new Person();
        person2.setName("Jane");
        personRepository.save(person2);

        // Query data from the database
        System.out.println("Find all persons:");
        personRepository.findAll().forEach(System.out::println);

        // Testing a custom query method
        System.out.println("Find person by name 'John':");
        personRepository.findByName("John").forEach(System.out::println);
    }
}
