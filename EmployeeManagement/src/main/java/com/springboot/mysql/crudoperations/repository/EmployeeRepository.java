package com.springboot.mysql.crudoperations.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.mysql.crudoperations.model.Employee;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//OKKKK ADDED
//ADd to Remote repog

//bshre3New update to check on Remote repo bshre3New

//New update
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}



