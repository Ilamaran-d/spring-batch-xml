package com.pvinsoft.batch.csv2db;


import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.pvinsoft.batch.model.Employee;

public class DBItemWriter extends JdbcDaoSupport implements ItemWriter<Employee> {     

	private static final String QUERY_INSERT_EMPLOYEE = "insert into T_EMPINFO(ID,SALARY,AGE,STAFF_NAME,DOB) values (?, ?, ? ,? ,?)";
	
	  @Override 
	  public void write(List<? extends Employee> employees) throws Exception {
		  System.out.println("Data Saved to DB for Employees: " + employees);
		  List<Object[]> objList = new ArrayList<Object[]>();
		  for(Employee emp : employees) {
			  Object[] 	objArray = { emp.getId(), emp.getSalary(), emp.getAge(), emp.getStaffName(), emp.getDateOfBirth() };
			  objList.add(objArray);
		  }
		  getJdbcTemplate().batchUpdate(QUERY_INSERT_EMPLOYEE, objList);  
	  }
}
