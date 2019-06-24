package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.EmployeeRepo;
import com.model.Employee;

@Controller
public class ControllerClass {

	@Autowired
	EmployeeRepo employeeRepo;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("employee", new Employee());
		return "index";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String addPagePerson(@ModelAttribute Employee employee, Model model) {

		model.addAttribute("employees", employee);
		return "result";
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ResponseEntity<Employee> create(@RequestBody Employee emp) {
		Employee employee = null;
		try {
			employee = employeeRepo.save(emp);
		} catch (Exception ex) {
			return null;
		}
		return null;
	}

	@RequestMapping("/delete")
	public String delete(long id) {
		try {
			Employee Employee = new Employee(id);
			employeeRepo.delete(Employee);
		} catch (Exception ex) {
			return "Error deleting the Employee: " + ex.toString();
		}
		return "Employee successfully deleted!";
	}

	@RequestMapping("/get-by-email")
	@ResponseBody
	public String getByEmail(String email) {
		String EmployeeId;
		try {
			Employee Employee = employeeRepo.findByEmail(email);
			EmployeeId = String.valueOf(Employee.getId());
		} catch (Exception ex) {
			return "Employee not found";
		}
		return "The Employee id is: " + EmployeeId;
	}

	/*
	 * @RequestMapping("/update")
	 * 
	 * @ResponseBody public String updateEmployee(long id, String email, String
	 * name) { try { Employee Employee = employeeRepo.findOne(id);
	 * Employee.setEmail(email); Employee.setName(name);
	 * employeeRepo.save(Employee); } catch (Exception ex) { return
	 * "Error updating the Employee: " + ex.toString(); } return
	 * "Employee successfully updated!"; }
	 */

}
