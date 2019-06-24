package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Employee;
import com.service.EmployeeServicve;

@Controller
public class ControllerClass {

	@Autowired
	private EmployeeServicve employeeServicve;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("employee", new Employee());
		return "greeting";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String addPagePerson(@ModelAttribute Employee employee, Model model) {

		model.addAttribute("employees", employee);
		return "result";
	}
}
