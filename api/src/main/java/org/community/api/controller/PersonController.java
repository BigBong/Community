package org.community.api.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.community.core.model.pojo.Person;
import org.community.api.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("person")
public class PersonController {
	public static final Logger logger = Logger.getLogger(PersonController.class);

	@Resource(name = "personService")
	private PersonService personService;

	@RequestMapping(params="id")
	@ResponseBody
	public Person getByIdFromParam(@RequestParam("id") Integer id) {
		logger.info("getByIdFromParam >> id:" + id);
		return personService.getById(id);
	}

	@RequestMapping(value="list")
	@ResponseBody
	public List<Person> getPersons() {
		logger.info("getPersons");
		return personService.getList();
	}

	@RequestMapping(value="random")
	@ResponseBody
	public Person getRandomPerson() {
		logger.info("getRandomPerson");
		Person person = new Person();
		person.setId(1);
		person.setAge(12);
		person.setName("frodoking");
		return person;
	}
}
