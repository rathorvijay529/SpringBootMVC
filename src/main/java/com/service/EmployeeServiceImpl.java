package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeRepo;
import com.entity.Employee;
import com.exception.CustomException;
import com.model.EmployeeMO;
import com.model.ErrorMO;

@Service
public class EmployeeServiceImpl implements EmployeeServicve {

	@Autowired
	private EmployeeRepo emprepo;

	@Override
	public EmployeeMO createEmployee(Employee employee) {
		if (validation(employee).size() == 0)
			return convertIntoModel(emprepo.save(employee));
		else
			throw new CustomException(validation(employee));
	}

	@Override
	public String updateEmployee(Employee emp) {

		return null;
	}

	@Override
	public void deleteEmployee(Long empId) {
		// emprepo.deleteById(empId);
	}

	@Override
	public Optional<Employee> getAllEmployee(Long empId) {
		// return emprepo.findById(empId);
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<ErrorMO> validation(Employee employee) {
		List<ErrorMO> list = new ArrayList<ErrorMO>();
		if (employee.getName() == null) {
			list.add(new ErrorMO(1000, "Employee Name is not available"));
		}
		if (employee.getEmail() == null) {
			list.add(new ErrorMO(1000, "Employee Email is not available"));
		}

		return list;
	}

	private EmployeeMO convertIntoModel(Employee employee) {
		EmployeeMO employeeMO = new EmployeeMO();
		employeeMO.setId(employee.getId());
		employeeMO.setName(employee.getName());
		employeeMO.setEmail(employee.getEmail());
		return employeeMO;

	}

}
