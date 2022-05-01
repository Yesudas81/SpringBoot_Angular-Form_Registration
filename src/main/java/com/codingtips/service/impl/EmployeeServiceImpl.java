package com.codingtips.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingtips.exception.EmployeeNotFoundException;
import com.codingtips.model.EmployeeModel;
import com.codingtips.repository.EmployeeRepository;
import com.codingtips.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Integer saveEmployee(EmployeeModel e) {
		
		return repo.save(e).getEId();
	}
	
	@Override
	public List<EmployeeModel> getAllEmployees() {
		List<EmployeeModel> list = repo.findAll();
		
		return list;
	}
	
	@Override
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
	}
	
	@Override
	public EmployeeModel getOneEmployee(Integer id) { 
		 return repo.findById(id).orElseThrow(
				()->
				new EmployeeNotFoundException("Employee not found"+id));
	}
	
	@Override
	public void updateEmployee(EmployeeModel emp) {
		repo.save(emp);	
	}
	
}
