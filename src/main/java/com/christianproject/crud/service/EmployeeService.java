package com.christianproject.crud.service;



import java.util.Optional;

import org.springframework.data.domain.Page;

import com.christianproject.crud.model.Employee;

public interface EmployeeService {
	
	public Page<Employee> findAll(int page, int size, String sortKey);
	
	public Optional<Employee> findById(Long id);
	
	public Employee save(Employee employee);
	
	public void deleteById(Long id);
}
