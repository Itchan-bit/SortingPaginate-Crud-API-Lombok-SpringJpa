package com.christianproject.crud.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.christianproject.crud.model.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	
//	Page<Employee> findAll(Pageable pageable);
//	
}
