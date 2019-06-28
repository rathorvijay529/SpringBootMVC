package com.service;

import java.util.List;
import java.util.Optional;

import com.entity.Employee;
import com.model.EmployeeMO;

public interface EmployeeServicve {

	public EmployeeMO createEmployee(Employee employee);

	public String updateEmployee(Employee emp);

	public void deleteEmployee(Long empId);

	public List<Employee> getAllEmployees();

	public Optional<Employee> getAllEmployee(Long empId);

}
