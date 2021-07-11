package com.springboot.mysql.crudoperations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mysql.crudoperations.model.Employee;
import com.springboot.mysql.crudoperations.repository.EmployeeRepository;

@RestController
public class Controllers {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/showAllEmployees")
	public @ResponseBody Iterable<Employee> showAllEmployees() {		
		
		return employeeRepository.findAll();		
		
	}
	
	@GetMapping("/searchById/{eid}")
	public @ResponseBody Employee searchEmploy(@PathVariable int eid) {
		try {
		return employeeRepository.findById(eid).get();
		}
		catch(Exception e) {
			return null;
		}		
	}
	
	@PostMapping("/postEmployee")
	public @ResponseBody String addEmployee(@RequestBody Employee employee) {
		try {
		
		Employee emp = employeeRepository.findById(employee.getEmpid()).get();
		return "record already exists";
		
		}
		catch(Exception e ) {
			employeeRepository.save(employee);			
			return "successfully inserted";
		}
	}
	
	@DeleteMapping("deleteEmployee/{eid}")
	public @ResponseBody String deleteEmployee(@PathVariable int eid) {
		
		try {
			
			Employee emp = employeeRepository.findById(eid).get();
			
			employeeRepository.delete(emp);
			return "record sucessfully deleted";
			
			}
			catch(Exception e ) {
				return "no record found";
			}
	}
	
	@PutMapping("/updateById")
	public @ResponseBody String updateEmploy(@RequestBody Employee employee) {
		try {
			Employee emp = employeeRepository.findById(employee.getEmpid()).get();	
			
			emp.setEmpName(employee.getEmpName());
			emp.setEmpDesignation(employee.getEmpDesignation());
			emp.setEmpSalary(employee.getEmpSalary());
			
		    employeeRepository.save(emp);
		    return "Record updated sucessfully";
		}
		catch(Exception e) {
			return "no record found";
		}		
	}
	
	

}
