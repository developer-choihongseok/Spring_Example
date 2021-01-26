package com.myway.tok.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myway.tok.dao.StudentDAO;
import com.myway.tok.model.Student;

@Controller
public class StudentController {
	// Logging을 할 수 있는 LoggerFactory 클래스를 선언해서 사용하는 방법을 주로 사용!!
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentDAO studentDAO;
	
	// 방법 1. return 값을 String형으로 만들어주고, Model을 따로 장착 시키는 방법.
	// 	- return은 view의 이름을 명시해주고, view에서 사용될 model은 따로 주입을 하는 방법.
	@RequestMapping(value="/student01.do", method=RequestMethod.GET)
	public String student01(Model model) {
		model.addAttribute("student", new Student());
		return "student/student";
	}
	
	// 방법2. ModelAndView 활용하는 방식
	// 	- 방법1의 단계를 1개로 합치는 방법
	@RequestMapping(value="/student02.do", method=RequestMethod.GET)
	public ModelAndView student02() {
		// 학생 조회
		studentDAO.select();
		
		return new ModelAndView("student/student", "student", new Student());
	}
	
	// student.jsp의 요청에서 입력 값을 받아서 result.jsp로 전달하는 매핑
	// @ModelAttribute : "값을 자동으로 매핑을 시켜라" 라는 뜻!!
	@RequestMapping(value="/add/student.do", method=RequestMethod.POST)
	public String addStudent(@ModelAttribute Student student, Model model) {
		model.addAttribute("student", student);
		
		// 학생 객체를 DB에 입력
//		studentDAO.create(student);
		studentDAO.sampleTransaction(student);

		return "student/result";
	}
	
	/*
	 student 조회 요청
	 
	 seq 파라미터가 있을 경우에는, 단건 조회를 실행해서 한 건에 대한 것만 가지고 result 페이지로 이동 할 것이다.
	 seq 파라미터가 없을 경우에는, 학생 리스트 전체를 조회해서 list 페이지로 이동할 것이다.
	 
	 defaultValue는 무조건 String 값만 가능하다. 인자값을 Integer로 주었기 때문에 자동으로 변환시켜서,
	 seq에 숫자 형태로 비교가 가능해진다.
	*/
	@RequestMapping(value="/student_list", method=RequestMethod.GET)
	public String getStudents(Model model, @RequestParam(value = "seq", required = false, defaultValue = "0") Integer seq) {
		if(seq == 0) {
			// 학생 리스트 조회
			List<Student> students = studentDAO.select();
//			logger.info("students:::::" + students);
			model.addAttribute("students", students);
			
			return "student/list";
			
		}else {
			// 학생 단건 조회
			// 아래 2줄을 합친 것이 83번째 줄.
//			Student student = studentDAO.select(seq);
//			model.addAttribute("students", student);
//			logger.info("students:::::" + students);
			model.addAttribute("student", studentDAO.select(seq));
			
			return "student/result";
		}

	}
}
