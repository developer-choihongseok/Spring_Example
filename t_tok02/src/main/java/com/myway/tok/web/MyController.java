package com.myway.tok.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myway.tok.model.TokTok;

@Controller
public class MyController {
	// 1. 리턴 될 페이지를 명확하게 지정하는 String 리턴을 갖고 있는 방식.
	@RequestMapping(value="/my/my_string", method=RequestMethod.GET)
	public String MyString(Model model) {
		model.addAttribute("tok", new TokTok("my_string"));
		return "my/my_string";
	}
	
	// 2. ModelAndView를 이용한 방식.
	@RequestMapping(value="/my/my_ModelAndView", method=RequestMethod.GET)
	public ModelAndView MyString() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("my/my_ModelAndView");
		mav.addObject("tok", new TokTok("my_ModelAndView"));
		return mav;
	}
	
	// 3. void 방식 : URL을 기반으로 해서 파일을 찾아가서 실행.
	@RequestMapping(value="/my/my_void", method=RequestMethod.GET)
	public void myvoid(Model model) {
		model.addAttribute("tok", new TokTok("my_void"));
	}
	
	// 4. Model을 리턴하는 방식.
	@RequestMapping(value="/my/my_Model", method=RequestMethod.GET)
	public TokTok myTokTok() {
		return new TokTok("my_Model");
	}
	
	// ※ HTTP 본문 자체를 리턴하는 방식.
	// @ResponseBody : .jsp 파일없이 HTTP body 자체가 리턴이 된다.
	// 다른 방식과의 큰 차이점 : jsp 파일을 만들지 않는다!!
	// ResponseEntity 사용한 이유 : 한글 처리.
	@RequestMapping(value="/my/my_body", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> myBody() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		String html = "<h2>Korea</h2> \n <h2>코리아</h2>";
		return new ResponseEntity<String>(html, headers, HttpStatus.OK);
	}
}
