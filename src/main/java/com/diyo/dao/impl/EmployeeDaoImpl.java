package com.diyo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.diyo.dao.EmployeeDao;
import com.diyo.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {   
	
	

	@Override
	public List<Employee> getAllEmployee() {
		
		List<Employee> em = new ArrayList<Employee>();
		
		Employee m1 = new Employee(1,"hari",25);
		Employee m2 = new Employee(2,"sam",256);
		Employee m3 = new Employee(3,"naresh",996);
		Employee m4 = new Employee(4,"pat",85);
		Employee m5 = new Employee(5,"kayla",19);
		
		em.add(m1);
		em.add(m2);
		em.add(m3);
		em.add(m4);
		em.add(m5);
		
		
		 
		 return em;
	}

}
