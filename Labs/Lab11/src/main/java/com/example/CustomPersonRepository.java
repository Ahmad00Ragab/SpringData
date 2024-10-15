package com.example;

import java.util.*;

public interface CustomPersonRepository {
    List<Person> findPersonsWithAgeAbove(int age);
}

