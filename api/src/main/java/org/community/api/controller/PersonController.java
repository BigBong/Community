package org.community.api.controller;

import org.community.core.model.pojo.Person;
import org.community.api.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("api")
public class PersonController {

	@Resource(name = "personService")
	private PersonService personService;

	@RequestMapping(value="person", params="id")
	@ResponseBody
	public Person getByIdFromParam(@RequestParam("id") Integer id) {
		return personService.getById(id);
	}

	@RequestMapping(value="persons")
	@ResponseBody
	public List<Person> getPersons() {
		return personService.getList();
	}
}
