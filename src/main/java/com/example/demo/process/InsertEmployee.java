package com.example.demo.process;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MySqlDao;

@Service
public class InsertEmployee {
	
	@Autowired
	MySqlDao mySqlDao;
	
	public HashMap<String, Object> insert(HashMap<String, Object> param){
		
		HashMap<String, Object> response = new HashMap<>();
		
		try {
			
			String name = (String) param.get("name");
			String age = (String) param.get("age");
			String department = (String) param.get("department");
			String salary = (String) param.get("salary");
			
			
			
			int count = mySqlDao.insertDataEmp(name, age, department, salary);
			
			if(count > 0 ) {
				response.put("RC", "00");
				response.put("RD", "SUCCESS");
			}else {
				response.put("RC", "01");
				response.put("RD", "FAILED");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.put("RC", "01");
			response.put("RD", "FAILED");
		}
		
		return response ; 
		
	}

}
