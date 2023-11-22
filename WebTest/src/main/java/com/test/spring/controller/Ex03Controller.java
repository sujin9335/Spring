package com.test.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러 구현
//1. Controller 인터페이스 구현
//2. @Controller 어노테이션 사용

//public class Ex03Controller implements Controller{
//
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		
//		
//		return null;
//	}
//	
//}

@Controller
@RequestMapping(value = "/ex03.do")	//context.xml 에서 맵핑 하던것, 서블릿에서 하는던것과 비슷
public class Ex03Controller {
	
	//요청 메서드(doGet/doPost/handleRequest) > 맘대로~
	//== 핸들러 : 여러개 만들면 요청 메소드가 뭔지 몰라서 @RequestMapping 을 붙혀준다
	@RequestMapping
	public String test() {
		
		//업무 코드
		//JSP 호출하기 > ModelAndView
		
		//1. ModelAndView 생서
		//2. ViewResolver 동작 : mv.setViewName("ex02"); return mv; 이거가 return "ex03"으로 해결
		return "ex03";
	}
	
	
	//@RequestMapping : 두개를 지정하면 안됨
	public int sum(int a, int b) {
		
		return a+b;
	}
	
	
}














