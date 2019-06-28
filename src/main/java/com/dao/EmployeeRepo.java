package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Employee;

@Repository("repo")
public interface EmployeeRepo extends CrudRepository<Employee, Long> {

	public Employee findByEmail(String email);
}
