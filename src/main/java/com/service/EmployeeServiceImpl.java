package com.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.EmployeeRepo;
import com.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeServicve {

	@Autowired
	private EmployeeRepo emprepo;

	@Override
	public Employee createEmployee(Employee emp) {
		return emprepo.save(emp);
	}

	@Override
	public String updateEmployee(Employee emp) {

		return null;
	}

	@Override
	public void deleteEmployee(Long empId) {
		emprepo.deleteById(empId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return emprepo.findAll();
	}

	@Override
	public Optional<Employee> getAllEmployee(Long empId) {
		return emprepo.findById(empId);
	}

}
