package com.pita_b2.employee.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.pita_b2.employee.rest.model.EmployeeModel;
import com.pita_b2.employee.rest.service.serviceImpl.EmployeeServiceImpl;

@RestController
public class StartRestController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = {"/","/index"}, method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeModel> index() {
		return employeeServiceImpl.selectAllData();
	}
	
	/**
	 * 
	 * @param employee
	 * @param bindResult
	 * @return
	 */
	@RequestMapping(value = {"/dataAdd"}, method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addEmployee(@Valid @RequestBody EmployeeModel employee, BindingResult bindResult) {
		if (bindResult.hasErrors()) {
	        Map<String, Object> errors = new HashMap<>();
	        errors.put("status", HttpStatus.BAD_REQUEST.value());
	        errors.put("message", "Validation Error");
	        errors.put("errors", bindResult.getFieldError());
	        
	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }

	    int result = employeeServiceImpl.employeeDataAdd(employee);
	    
	    Map<String, Object> successes = new HashMap<>();
	    successes.put("status", HttpStatus.OK.value());
	    successes.put("message", "Employee added successfully");
	    successes.put("result", result);
	    return new ResponseEntity<>(successes, HttpStatus.OK);
	}

	/**
	 * 
	 * @param employeeId
	 * @return
	 */
	@RequestMapping(value = "/delete/{employeeId}", method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int deleteEmployee(@PathVariable("employeeId") int employeeId) {
		return employeeServiceImpl.deleteEmployee(employeeId);
	}
	
	/**
	 * 
	 * @param employeeId
	 * @return
	 */
	@RequestMapping(value = "/searchById/{employeeId}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeModel> searchById(@PathVariable("employeeId") int employeeId) {
		return employeeServiceImpl.searchById(employeeId);
	}
	
	/**
	 * 
	 * @param employeeName
	 * @return
	 */
	@RequestMapping(value = "/searchByName/{employeeName}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeModel> searchByName(@PathVariable("employeeName") String employeeName) {
		return employeeServiceImpl.searchByName(employeeName);
	}
	
	/**
	 * 
	 * @param employeeId
	 * @param employeeModel
	 * @return
	 */
	@RequestMapping(value= {"/updateProcess/{employeeId}"}, method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public int updateProcess(@PathVariable("employeeId") int employeeId,@RequestBody EmployeeModel employeeModel) {
        return employeeServiceImpl.updateProcess(employeeId, employeeModel);
    }
}
