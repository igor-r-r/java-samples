package com.study.interview.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Streams {

    private static List<Person> persons;

    static {
        persons = new ArrayList<>();

        persons.add(new Person(1L, 18, "Bob"));
        persons.add(new Person(2L, 16, "Jack"));
        persons.add(new Person(3L, 16, "Jack"));
        persons.add(new Person(4L, 21, "Steve"));

    }

    public static void main(String[] args) {
        getCountByField();
    }

    public static void getCountByField() {
        Map<String, Long> counts = persons.stream().collect(Collectors.groupingBy(Person::getName, Collectors.counting()));

        System.out.println(counts);
    }

    @Data
    @AllArgsConstructor
    private static class Person {
        private long id;
        private int age;
        private String name;
    }

}
