package com.pita_b2.employee.rest.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pita_b2.employee.rest.model.EmployeeModel;

public interface EmployeeService {
	public int employeeDataAdd(EmployeeModel employeeModel);
	public int deleteEmployee(int employeeId);
	public int updateProcess(@Param("employeeId")int employeeId, @Param("employeeModel") EmployeeModel employeeModel);
	public List<EmployeeModel> selectAllData();
	public List<EmployeeModel> searchById(int employeeId);
	public List<EmployeeModel> searchByName(String employeeName);
}
