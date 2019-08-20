package com.example.mongodb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb.document.Employee;
import com.example.mongodb.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/all")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	@PatchMapping("/update/id/{id}/name/{name}")
	public Employee updateEmployee(@PathVariable("id") Integer id,@PathVariable("name") String name) {
		return employeeService.updateEmployee(id, name);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteEmployeeById(Integer id) {
		employeeService.deleteEmployeeById(id);
	}
	@GetMapping("/alltemplate")
	public List<Employee> findAllEmployeesWithTemplate(){
		return employeeService.getAllEmployeesWithTemplate();
	}
}
