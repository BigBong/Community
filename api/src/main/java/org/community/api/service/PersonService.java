package org.community.api.service;

import org.community.core.model.pojo.Person;

import java.util.List;

public interface PersonService {
    Person getById(int id);

    int save(Person person);

    List<Person> getList();
}
