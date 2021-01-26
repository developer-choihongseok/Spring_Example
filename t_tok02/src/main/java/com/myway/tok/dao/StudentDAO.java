package com.myway.tok.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myway.tok.mapper.StudentMapper;
import com.myway.tok.model.Student;

// @Component : DAO를 사용하겠다!!
@Component
public class StudentDAO {
	private JdbcTemplate jdbcTemplate;
	
	// setter 주입 방법 -> DI
	// @Autowired : 자동으로 주입할 녀석을 찾는다!!
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 학생 등록 메서드
	public void create(Student student) {
		String sql = "INSERT INTO Student(id, name, age) values(?, ?, ?)";
		
		jdbcTemplate.update(sql, student.getId(), student.getName(), student.getAge());
	}
	
	// 학생 조회 메서드 - 리스트
	public List<Student> select() {
		String sql = "SELECT * FROM student";
		
		List<Student> students = jdbcTemplate.query(sql, new StudentMapper());
//		System.out.println("students>>dao>>" + students);
		return students;
	}
	
	// 학생 조회 메서드 - 단건
	// 다형성
	public Student select(Integer seq) {
		String sql = "SELECT * FROM student WHERE seq = ?";
		
		// 2번째 인자값으로, ?에 들어갈 객체를 넣어주면 된다.
		// 2번째 인자값이 어떤 데이터 형이 올지 모르기 때문에, Object 타입의 배열 형태로 넣어줘야 한다.
		Student students = jdbcTemplate.queryForObject(sql, new Object[] {seq}, new StudentMapper());
//		System.out.println("students>>dao>>" + students);
		return students;
	}
	
	// 학생 수정 메서드
	public void update(Student student) {
		String sql = "INSERT INTO Student_Bad(id, name, age) values(?, ?, ?)";
		
		jdbcTemplate.update(sql, student.getId(), student.getName(), student.getAge());
	}
	
	// 학생 삭제 메서드
	public void delete() {
		
	}
	
	// 학생 입력 후, 에러가 발생하는 학생 수정을 호출하는 상황.
	// @Transactional : 해당 메서드 안에서 실행되는 작업은 전부 다 하나의 작업으로 처리된다!
	@Transactional
	public void sampleTransaction(Student student) {
		this.create(student);
		this.update(student);
	}
}
