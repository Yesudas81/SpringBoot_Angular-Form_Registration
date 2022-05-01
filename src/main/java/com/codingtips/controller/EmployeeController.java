package com.codingtips.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingtips.model.EmployeeModel;
import com.codingtips.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/register")
	public String showRegister()
	{
		return "EmployeeRegister";
	}
	
	@PostMapping("/save")
	public  String saveEmployee(@RequestBody EmployeeModel e,Model m )
	{
		Integer id = service.saveEmployee(e);
		String msg="Employee saved"+id;
		m.addAttribute("message", msg);
		return "EmployeeRegister";
	}
	
	@GetMapping("/all")
	public String showAll(Model m)
	{
		List<EmployeeModel> list = service.getAllEmployees();
		m.addAttribute("list", list);
		return "EmployeeData";
	}
	
	@DeleteMapping("/delete")
	public String deleteEmp(Model m,@PathVariable Integer id)
	{
		service.deleteEmployee(id);
		return "redirect:all";
	}
	
	@GetMapping("/edit")
	public String showEdit(@PathVariable Integer id,Model m)
	{
		EmployeeModel e = service.getOneEmployee(id);
		m.addAttribute("employee", e);
		return "EmployeeEdit";
	}
	
	@PutMapping("/update")
	public String updateEmp(@RequestBody EmployeeModel e,Model m)
	{
		service.updateEmployee(e);
		return "redirect:all";
	}

}
