package com.pita_b2.employee.rest.service.serviceImpl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pita_b2.employee.rest.model.EmployeeModel;
import com.pita_b2.employee.rest.repository.EmployeeRepository;
import com.pita_b2.employee.rest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public int employeeDataAdd(EmployeeModel employeeModel) {
		return employeeRepository.employeeDataAdd(employeeModel);
	}

	@Override
	public int deleteEmployee(int employeeId) {
		return employeeRepository.deleteEmployee(employeeId);
	}

	@Override
	public int updateProcess(@Param("employeeId")int employeeId, @Param("employeeModel") EmployeeModel employeeModel) {
		return employeeRepository.updateProcess(employeeId,employeeModel);
	}

	@Override
	public List<EmployeeModel> selectAllData() {
		return employeeRepository.selectAllData();
	}
	
	@Override
	public List<EmployeeModel> searchById(int employeeId) {
		return employeeRepository.searchById(employeeId);
	}
	
	@Override
	public List<EmployeeModel> searchByName(String employeeName) {
		return employeeRepository.searchByName(employeeName);
	}

}
