package com.example.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodb.document.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

}
