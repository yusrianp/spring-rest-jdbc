package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.process.DeleteEmployee;
import com.example.demo.process.DetailEmployee;
import com.example.demo.process.InsertEmployee;
import com.example.demo.process.ListEmployee;
import com.example.demo.process.UpdateEmployee;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class DemoController {
	
	@Autowired
	InsertEmployee insertEmployee;
	
	@Autowired
	UpdateEmployee updateEmployee;
	
	@Autowired
	ListEmployee listEmployee;
	
	@Autowired
	DeleteEmployee deleteEmployee;
	
	@Autowired
	DetailEmployee detailEmployee;
	
	@PostMapping("${demo.insert}")
	public HashMap<String, Object> insertEmp(@RequestBody HashMap<String, Object> param) {
		HashMap<String, Object> response = new HashMap<>();
		
		
		response = insertEmployee.insert(param);
		
		return response;
		
	}
	
	@PutMapping("/employee/{id}")
	public HashMap<String, Object> updateEmp(@PathVariable int id, @RequestBody HashMap<String, Object> param) {
		HashMap<String, Object> response = new HashMap<>();
		
		response = updateEmployee.update(id, param);
		
		return response;
		
	}
	
	@PostMapping("${demo.list}")
	public HashMap<String, Object> listEmp(@RequestBody HashMap<String, Object> param) {
		HashMap<String, Object> response = new HashMap<>();
		
		response = listEmployee.list();
		
		return response;
		
	}
		
	@DeleteMapping("employee/{id}")
	public HashMap<String, Object> deleteEmp(@PathVariable int id) {
		HashMap<String, Object> response = new HashMap<>();
		
		response = deleteEmployee.delete(id);
		
		return response;
		
	}
	
	@GetMapping("/employee/{id}")
	public HashMap<String, Object> getdetailEmp(@PathVariable int id) {
		HashMap<String, Object> response = new HashMap<>();
		
		response = detailEmployee.detail(id);
		
		return response;
		
	}
	
	

}
