package com.christianproject.crud.crudapi;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.christianproject.crud.model.Employee;
import com.christianproject.crud.serviceimpl.EmployeeServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/employee")
@Slf4j
@RequiredArgsConstructor
public class CrudAPI {

	private final EmployeeServiceImpl employeeService;
	
	@GetMapping
	public ResponseEntity<Page<Employee>> findAll( 
			
	@RequestParam(value = "page", defaultValue = "0", required = false) int page,
	@RequestParam(value = "count", defaultValue = "10", required = false) int size, 
	@RequestParam(value="sortKey", defaultValue="name", required = false) String sortKey){
		
	return ResponseEntity.ok(employeeService.findAll(page,size,sortKey));
	}
	
	@PostMapping
	public ResponseEntity<Employee> create(@Valid Employee employee) {
		return ResponseEntity.ok(employeeService.save(employee));
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findByid(@PathVariable Long id){
		Optional<Employee> employee = employeeService.findById(id);
		
		if(!employee.isPresent()) {
			log.error("ID" + id + " is not existed");
			ResponseEntity.badRequest().build();
		}
		
		else if(employee.isPresent()) {
			return ResponseEntity.ok(employee.get());
		}
		
		return null;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateById(@PathVariable Long id, @Valid Employee employee){
		if(!employeeService.findById(id).isPresent()) {
			log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(employeeService.save(employee));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteById(@PathVariable Long id){
		
		if (!employeeService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
		
		employeeService.deleteById(id);
		
		return ResponseEntity.ok().build();
		
	}
	
	
}
