package com.test.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/board") // /board/list.do 같은 주소 앞에 board를 먼저 선언 할 수 있음
public class BoardController {

	//- "/spring/board/list.do"
	//- "/spring/board/add.do"
	//- "/spring/board/addok.do"
	//- "/spring/board/view.do"
	
	//- doGet() 역할
	@RequestMapping(value = "/list.do", method= {RequestMethod.GET,RequestMethod.POST})
	public String list() {
		
		//WEB-INF/views/board/list.jsp : xml  에서 앞에 뒤에 는 붙혀줘서 board/list 만 쓰면된다
		return "board/list";
	}
	
	//- doGet() 역할
	@RequestMapping(value = "/add.do", method=RequestMethod.GET)
	public String add() {
		
		return "board/add";
	}
	
	//- doPost() 역할
	@RequestMapping(value = "/addok.do", method=RequestMethod.POST)
	public String addok() {
		
		return "board/addok";
	}
	
	//- doGet() 역할
	@RequestMapping(value = "/view.do", method=RequestMethod.GET)
	public String view() {
		
		return "board/view";
	}
	
}
