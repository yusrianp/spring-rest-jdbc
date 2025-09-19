package com.example.demo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class MySqlDao {
	
	@Autowired
	@Qualifier("jdbcDbDao")
	private JdbcTemplate jdbcDbDao;
	
	public int insertDataEmp(String name, String age, String department, String salary) {
		int rowcount = 0;

		try {

			String query = "insert into employees(name, age, department, salary, created_date) values(?,?,?,?,CURRENT_TIMESTAMP)";

			rowcount = jdbcDbDao.update(query, name, age, department, salary);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowcount;

	}
	
	public int updateDataEmp(int employee_id, String name, String age, String department, String salary) {
		int rowcount = 0;

		try {

			String query = "UPDATE employees SET name = ?, age = ?, department = ? , salary = ? , update_date = CURRENT_TIMESTAMP WHERE employee_id = ?";

			rowcount = jdbcDbDao.update(query, name, age, department, salary, employee_id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowcount;

	}
	
	public int deleteDataEmp(int employee_id) {
		int rowcount = 0;

		try {

			String query = "DELETE FROM employees WHERE employee_id=?";

			rowcount = jdbcDbDao.update(query, employee_id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowcount;

	}
	
	public List<Map<String, Object>> getListEmployee() {
		
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		
		try {
			
			String query = "SELECT * from employees";
			data = jdbcDbDao.queryForList(query);
			
		} catch (Exception e) {
			return data;
		}



		return data;
	}
	
	public Map<String, Object> getDetailEmployee(int employee_id) {
		Map<String, Object> data = new HashMap<>();

		try {
			
			String query = "SELECT * from employees WHERE employee_id = ?";
			data = jdbcDbDao.queryForMap(query, employee_id);
			
		} catch (Exception e) {
			return data;
		}
			
		return data;
	}
	
	

}
