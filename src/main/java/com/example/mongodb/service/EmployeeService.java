package com.example.mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ExecutableFindOperation.ExecutableFind;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.mongodb.document.Employee;
import com.example.mongodb.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	@Autowired
	private MongoTemplate mongoTemplate;
	public List<Employee> getAllEmployeesWithTemplate(){
		ExecutableFind<Employee> query = mongoTemplate.query(Employee.class);
		return query.all();
	}
	public Employee addEmployee(Employee employee) {
		return employeeRepository.insert(employee);
	}
	public Employee updateEmployee(Integer id,String name) {
		Optional<Employee> emp =employeeRepository.findById(id);
		if(emp.isPresent()) {
			Employee employee =emp.get();
			employee.setName(name);
			employeeRepository.save(employee);
		}
		return null;
	}
	public void deleteEmployeeById(Integer id) {
		employeeRepository.deleteById(id);
	}
}
