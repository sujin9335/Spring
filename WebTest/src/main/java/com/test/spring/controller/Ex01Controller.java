package com.test.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//서블릿(X) > 서블릿 > 컨트롤러 역할(O) == <bean>
public class Ex01Controller implements Controller{ //Controller 인터페이스 연결

	//doGet/doPost == handleRequest
	//Controller 인터페이스에 있는 메소드
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ex01.do 주소 지정은 context.xml에서 bean으로 주소지정
		
		
		//업무 진행..
		
		//뷰 호출(JSP)
		//- RequestDispatcher > forward()
		
		//- ModelAndView 사용
		//	- Model > 데이터 전송
		//	- View > JSP
		
		
		
		//JSP 연결 하기
		ModelAndView mv=new ModelAndView();
		//mv.setViewName("/WEB-INF/views/ex01.jsp"); 를 한것과 동일
		mv.setViewName("ex01");
		
		request.setAttribute("name", "홍길동"); //sevlet 방식
		
		mv.addObject("age", 20); //권장 스프링방식
		
		return mv;//반환을 해야 jsp출력이됨
	}

}










