package org.community.core.dao;

import org.community.core.model.pojo.Person;

import java.util.List;

/**
 * Created by frodoking on 2014/12/23.
 */
public interface PersonDao {
    Person getPersonById(int id);
    Person getPersonByName(String name);
    List<Person> getPersons();
    int save(Person person);
}
