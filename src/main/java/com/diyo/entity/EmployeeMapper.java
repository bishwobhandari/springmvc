package com.diyo.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee aContact = new Employee();
		 
        aContact.setId(rs.getInt("id"));
        aContact.setName(rs.getString("name"));
        aContact.setAge(rs.getInt("age"));


        return aContact;

	}
	
	

}
