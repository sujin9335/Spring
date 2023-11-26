package com.test.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.spring.persistence.SpringDAO;
import com.test.spring.persistence.SpringDAOImpl;

public class Ex02Controller implements Controller{
	
	//1.
	private SpringDAO dao;
	
	//2.
	public Ex02Controller(SpringDAO dao) {
		this.dao=dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//Ex02Controller 객체 > (의존) > SpringDAO 객체
		
		
		//업무 중 일부 > DB 작업 > DAO 위임
		//SpringDAO dao=new SpringDAOImpl();
		
		int count=dao.getCount();//DB에서 처리 했다 하고 완료값 가져오기 return 100;
		
		ModelAndView mv=new ModelAndView();
		//mv.setViewName("/WEB-INF/views/test1.jsp"); 를 한것과 동일
		
		
		request.setAttribute("name", "홍길동"); //sevlet 방식
		
		mv.addObject("age", 20); //권장 스프링방식
		
		mv.addObject("count", count);
		mv.setViewName("ex02");
		
		
		return mv;
	}

}
