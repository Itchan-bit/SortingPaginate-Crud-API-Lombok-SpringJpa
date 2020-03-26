package com.christianproject.crud.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.christianproject.crud.model.Employee;
import com.christianproject.crud.repository.EmployeeRepository;
import com.christianproject.crud.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService  {

	
	private final EmployeeRepository employeeRepository;
	


	@Override
	public Optional<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}
	

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Page<Employee> findAll(int page, int size, String sortKey) {
		Pageable pageable = PageRequest.of(page, size , Sort.by(sortKey));
		Page<Employee> pageResult = employeeRepository.findAll(pageable);
		return pageResult;
	}

}
