package com.myway.tok;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		// locale : 각 나라의 날짜를 표기하는 방식이 틀리다.
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";	// home.jsp 호출! 가능한 이유 : servlet-context.xml에 23~26번째에 의해서.
	}
	
	// @RequestParam("id") String id : HTML의 속성 중에 id라는 값을 가진 것을 String id 변수에 담는다.
	@RequestMapping(value = "/tok.do", method = RequestMethod.POST)
	public String tok(Locale locale, Model model, @RequestParam("id") String id) {
		logger.info("id >>> {}", id);

		model.addAttribute("serverTime", id );
		
		return "home";
	}
	
	@RequestMapping(value = "/sample.do", method = RequestMethod.GET)
	public String sample(Locale locale, Model model) {
		return "sample";
	}
}
