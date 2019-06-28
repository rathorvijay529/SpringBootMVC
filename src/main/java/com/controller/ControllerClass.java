package com.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Employee;
import com.exception.CustomException;
import com.service.EmployeeServicve;

@Controller
public class ControllerClass {

	private final static Logger logger = Logger
			.getLogger(ControllerClass.class);

	@Autowired
	private EmployeeServicve employeeServicve;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("employee", new Employee());
		return "index";
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody Employee employeeMO) {
		try {
			logger.debug("URI::/saveEmployee");
			logger.debug("Method::POST");
			logger.debug("Payload::" + employeeMO);
			return new ResponseEntity<>(
					employeeServicve.createEmployee(employeeMO),
					HttpStatus.CREATED);
		} catch (CustomException ex) {
			logger.error(ex);
			return new ResponseEntity<>(ex.getList(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// assignment: getEmployee,getEmployees,dleteEmployee,updateEmployee

}
