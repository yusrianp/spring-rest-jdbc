package com.example.demo.process;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MySqlDao;

@Service
public class DeleteEmployee {
	
	@Autowired
	MySqlDao mySqlDao;
	
	public HashMap<String, Object> delete(int employee_id){
		
		HashMap<String, Object> response = new HashMap<>();
		
		try {
						
			int count = mySqlDao.deleteDataEmp(employee_id);
			
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
