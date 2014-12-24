package org.community.core.dao.impl;

import org.community.core.dao.PersonDao;
import org.community.core.model.mapper.PersonMapper;
import org.community.core.model.pojo.Person;
import org.community.core.model.pojo.PersonExample;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by frodoking on 2014/12/23.
 */
public class PersonDaoImpl extends SqlSessionDaoSupport implements PersonDao {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public Person getPersonById(int id) {
        PersonExample example = new PersonExample();
        PersonExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return personMapper.selectByExample(example).get(0);
    }

    @Override
    public Person getPersonByName(String name) {
        PersonExample example = new PersonExample();
        PersonExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        return personMapper.selectByExample(example).get(0);
    }

    @Override
    public List<Person> getPersons() {
        PersonExample example = new PersonExample();
        return personMapper.selectByExample(example);
    }

    @Override
    public int save(Person person) {
       return personMapper.insertSelective(person);
    }
}
