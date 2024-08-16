package com.springboot.mysql.crudoperations.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.mysql.crudoperations.model.Employee;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//OKKKK ADDED
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}



