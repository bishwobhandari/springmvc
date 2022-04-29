package com.diyo.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diyo.dao.EmployeeDao;
import com.diyo.entity.Employee;
import com.diyo.entity.EmployeeMapper;

@RestController
public class MyController  {
	

	private JdbcTemplate jdbcTemplate;
	
	DataSource dataSource;
	
	EmployeeDao em;
	
//	public MyController(DataSource dataSource,	EmployeeDao em ) {
//		 this.jdbcTemplate = new JdbcTemplate(dataSource);
//		 this.em=em;
//	}
	
	public void setEm(EmployeeDao em ) {
		this.em=em;
	}


	 
//
//    public void setEmployeeDao(EmployeeDao em) {
//		this.em = em;
//	}

	public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

//	EmployeeDao em = new EmployeeDaoImpl();
	
	
	@GetMapping(value="getemployees")
	public List<Employee> getEmployees(){
	return em.getAllEmployee();
	}
	
	
	
	
	
	@RequestMapping("hello")
	public String hello() {
		return "hello good morning";
	}
	
	@RequestMapping(value="getAllEmployee", produces="application/json")
	public List<Employee> getAllEmployee(){
		String sql = "SELECT * FROM employee";
	    List<Employee> listContact = jdbcTemplate.query(sql, new EmployeeMapper());
	        
	    return listContact;
		

	}
	
	
	
	@RequestMapping(value="post-employee", produces="application/json")
	public String postEmployee(@RequestBody Employee em){
		String sql = "insert into employee values(? , ?, ?)";
		
		System.out.println(em.toString());
		
		int id = em.getId();
		String name= em.getName();
		int age = em.getAge();
		
		
		
	    int result = jdbcTemplate.update(sql,id, name, age );
	    
	    System.out.println(result);
	        
	    return "success";
		
	}


	@RequestMapping(value="employee/{id}", produces="application/json")
	public Employee getEmployeebyId(@PathVariable int id){
		String sql = "select * from employee where id = ?";

		System.out.println(id);



//		Map<String, Object> result = jdbcTemplate.queryForMap(sql,new Object[]{id}, new EmployeeMapper() );
		Employee em = jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeMapper() );
		System.out.println(em);

		return em;

	}
	
	

	
	
	
	@RequestMapping(value="postemployee", consumes="application/json" , method=RequestMethod.POST)
	public String saveEmployee(@RequestBody Employee em){
		System.out.println("i am in save method");
		System.out.println(em.toString());
		
		return "hello";
	}
	
	@GetMapping(value="postid/{id}")
	public String saveEmployeeById(@PathVariable int id){
		System.out.println("i am in save method");
		System.out.println(id);
		
		return "hello";
	}
	
	
	
	@PostMapping(value="postid/{id}")
	public String saveEmployeeById(@RequestBody Employee em ){

		
		return "hello";
	}



}
