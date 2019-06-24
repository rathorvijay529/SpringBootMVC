package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Employee;

public interface EmployeeServicve {

	public Employee createEmployee(Employee emp);

	public String updateEmployee(Employee emp);

	public void deleteEmployee(Long empId);

	public List<Employee> getAllEmployees();

	public Optional<Employee> getAllEmployee(Long empId);

}
