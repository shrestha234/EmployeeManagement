package com.springboot.mysql.crudoperations.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.mysql.crudoperations.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
