package com.codingtips.service;

import java.util.List;

import com.codingtips.model.EmployeeModel;

public interface EmployeeService {
	
	Integer saveEmployee(EmployeeModel e);
	
	List<EmployeeModel> getAllEmployees();
	
	void deleteEmployee(Integer id);
	
	EmployeeModel getOneEmployee(Integer id);
	
	void updateEmployee(EmployeeModel emp);

}
