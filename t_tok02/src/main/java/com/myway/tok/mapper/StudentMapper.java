package com.myway.tok.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myway.tok.model.Student;
/*
  ResultSet : DB에서 select 이후에 리턴되는 객체.
  
  DB의 자료형들과 JAVA의 자료형들이 다르다. 그러므로, 두 객체를 매핑해주는 Mapper클래스가 필요하다.
   그러면, DB를 수신 받아서 데이터를 받아올 수 있다.
*/
public class StudentMapper implements RowMapper<Student>{
	// DB의 타입과 JAVA의 타입을 매핑!!
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		
		student.setSeq(rs.getInt("seq"));
		student.setId(rs.getString("id"));
		student.setName(rs.getString("name"));
		student.setAge(rs.getInt("age"));
		
		return student;
	}
	
}
