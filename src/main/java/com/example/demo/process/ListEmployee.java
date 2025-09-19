package com.example.demo.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MySqlDao;

@Service
public class ListEmployee {

	@Autowired
	MySqlDao mySqlDao;
	
	public HashMap<String, Object> list(){
		
		HashMap<String, Object> response = new HashMap<>();
		
		try {
			
			
			List<Map<String, Object>> data = mySqlDao.getListEmployee();
			
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
