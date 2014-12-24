package org.community.api.service.impl;

import org.community.core.dao.PersonDao;
import org.community.core.model.pojo.Person;
import org.community.api.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

	@Resource(name = "personDao")
	private PersonDao personDao;

	@Override
	public Person getById(int id) {
		return personDao.getPersonById(id);
	}
	
	@Override
	public int save(Person person) {
		return personDao.save(person);
	}

	@Override
	public List<Person> getList() {
		return personDao.getPersons();
	}
}
