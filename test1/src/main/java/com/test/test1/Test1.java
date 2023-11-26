package com.test.test1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.test1.persistence.TestDAO;


public class Test1 implements Controller{

	private TestDAO dao;
	
	
	public Test1(TestDAO dao) {
		this.dao=dao; //new TestDAO 는 context.xml 에서 관리 
	}

	
	//doGet/doPost == handleRequest
	//Controller 인터페이스에 있는 메소드
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//test1.do 주소 지정은 context.xml에서 bean으로 주소지정
		
		
		//JSP 연결 하기
		ModelAndView mv=new ModelAndView();
		
		int count=dao.getCount();
		
		mv.setViewName("test1");
		mv.addObject("count", count);
		
		return mv;//반환을 해야 jsp출력이됨
	}
}
