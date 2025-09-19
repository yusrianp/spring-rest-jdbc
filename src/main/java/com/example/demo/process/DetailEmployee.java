package com.example.demo.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MySqlDao;

@Service
public class DetailEmployee {


	@Autowired
	MySqlDao mySqlDao;
	
	public HashMap<String, Object> detail(int employee_id){
		
		HashMap<String, Object> response = new HashMap<>();
		Map<String, Object> data = new HashMap<>();
		try {
						
			data = mySqlDao.getDetailEmployee(employee_id);
			
			if(!data.isEmpty()) {
				response.put("RC", "00");
				response.put("RD", "SUCCESS");
				response.put("Data", data);
			}else {
				response.put("RC", "02");
				response.put("RD", "EMPTY");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.put("RC", "01");
			response.put("RD", "FAILED");
		}
		
		return response ; 
		
	}



}
