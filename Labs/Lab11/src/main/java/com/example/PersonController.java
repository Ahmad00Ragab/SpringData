package com.example;



import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.data.domain.*;
import java.util.stream.*;


@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/paged")
    public Page<Person> getPersonsPaged(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return personService.getPersonsPaged(pageable);
    }

    @GetMapping("/names/{lastname}")
    public List<NamesOnly> getNamesByLastname(@PathVariable String lastname) {
        return personService.getNamesByLastname(lastname);
    }


    @GetMapping("/stream")
    public ResponseEntity<List<Person>> streamAllPersons() {
        List<Person> persons = personService.streamAllPersons().collect(Collectors.toList());
        return ResponseEntity.ok(persons);
    }


    /* For testing Custom Repo Interface */
    @GetMapping("/ageAbove/{age}")
    public ResponseEntity<List<Person>> findPersonsAboveAge(@PathVariable int age) {
        List<Person> persons = personService.findPersonsWithAgeAbove(age);
        return ResponseEntity.ok(persons);
    }

}



