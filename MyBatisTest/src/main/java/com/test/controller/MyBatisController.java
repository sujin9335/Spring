package com.test.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.domain.MyBatisDTO;
import com.test.persistence.MyBatisDAO;

@Controller
public class MyBatisController {

	@Autowired //=new MyBatisDAOImpl(); 이거를 대신해줌
	private MyBatisDAO dao;
	
	
	
	@GetMapping(value = "/test.do")
	public String test() {
		
		System.out.println("test");
		
		//의존 객체 > Sptring DI
		//MyBatisDAO dao=new MyBatisDAOImpl();
		
		dao.test();
		
		
		
		return "list";
	}
	
	@GetMapping(value = "/add.do")
	public String add() {
		
		
		
		return "add";
	}
	
	@PostMapping(value = "/addok.do")
	public String addok(MyBatisDTO dto, Model model) {
		
		
		int result=dao.add(dto);
		
		model.addAttribute("result", result);
		
		
		return "addok";
	}
	//----------------------11_24
	
	//반환값(X) 매개변수(X)
	//반환값(X) 매개변수(O)
	//반환값(O) 매개변수(X)
	// - 반환값: 단일값
	// - 반환값: 레코드 1줄
	// - 반환값: 레코드 N줄
	//반환값(O) 매개변수(O)
	// - 반환값: 단일값
	// - 반환값: 레코드 1줄
	// - 반환값: 레코드 N줄

	
	
	//1. 반환값(X), 매개변수(X)
	//- 정적 쿼리
	@GetMapping(value = "/m1.do")
	public String m1() {
		
		this.dao.m1();
		return "list";
	}
	
	
	//2. 반환값(X) 매개변수(O)
	@GetMapping(value = "/m2.do")
	public String m2(@RequestParam(name="seq") String seq, Model model) { //@RequestParam(name="seq") 생략가능
		
		//m2.do?seq=5
		
		//delete from tblMyBatis where seq = ?
		int result=this.dao.m2(seq);
		
		model.addAttribute("result", result);
		
		return "list";
	}
	
	//2. 반환값(X) 매개변수(O)
	@GetMapping(value = "/m3.do")
	public String m3(Model model) {
		
		MyBatisDTO dto=new MyBatisDTO();
		dto.setName("가가가");
		dto.setAge("25");
		dto.setAddress("서울시 강남구 대치동");
		dto.setGender("m");
		
		int result=this.dao.m3(dto);
				
		model.addAttribute("result", result);
		
		return "list";
	}
	
	//2. 반환값(X) 매개변수(O) 안됨 
	@GetMapping(value = "/m4.do")
	public String m4(Model model) {
		
		//update tblMyBatis set address = ? where seq = ?;
		HashMap<String, String> map=new HashMap<String, String>();
		
		map.put("seq", "3");
		map.put("address", "서울시 강남구 역삼동");
		
		int result=this.dao.m4(map);
		
		model.addAttribute("result", result);
		
		return "list";
	}
	
	//3. 반환값(O) 매개변수(X)
	//3.1 단일값 반환(1행 1열)
	//- select coutn(*) from tblMyBatis
	@GetMapping(value = "/m5.do")
	public String m5(Model model) {
		
		int count=this.dao.m5();
		
		model.addAttribute("count", count);
		
		return "list";
	}
	
	//3. 반환값(O) 매개변수(X)
	//3.2 레코드 1개 반환(컬럼 n개)
	//- select * from tblMyBatis where seq = ?
	@GetMapping(value = "/m6.do")
	public String m6(String seq, Model model) {
		
		MyBatisDTO dto=this.dao.m6(seq);
		
		model.addAttribute("dto", dto);
			
		
		return "list";
	}
	
	
	
	//3. 반환값(O) 매개변수(O,X)
	//3.3 레코드 n개 반환(컬럼 1개)
	//- select name from tblMyBatis;
	@GetMapping(value = "/m7.do")
	public String m7(Model model) {
		
		List<String> name=this.dao.m7();
		
		model.addAttribute("name", name);
			
		
		return "list";
	}
	
	//3. 반환값(O) 매개변수(O,X)
	// 3.4 레코드 n개 반환(컬럼 N개)
	// - select name from tblMyBatis;
	@GetMapping(value = "/m8.do")
	public String m8(Model model) {

		List<MyBatisDTO> list=this.dao.m8();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping(value = "/m9.do")
	public String m9(Model model, String table) {
		
		//m9.do?table=employees
		//select count(*) from employees
		
		//m9.do?table=tblMyBatis
		//select count(*) from tblMyBatis
		
		int count=this.dao.m9(table);
		
		model.addAttribute("count", count);
		
		return "list";
	}
	
	// '<' 이하 쿼리 처리 방법
	@GetMapping(value = "/m10.do")
	public String m10(Model model) {
		
		
		int count=this.dao.m10();
		
		model.addAttribute("count", count);
		
		return "list";
	}
	
	// 검색 '%역삼%' 쿼리 처리 방법
	@GetMapping(value = "/m11.do")
	public String m11(Model model, String word) {
		
		//주소검색
		List<MyBatisDTO> list=this.dao.m11(word);
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	
	@GetMapping(value = "/m12.do")
	public String m12(Model model, String type) {
		
		//동적 쿼리
		
		//m12.do?type=1 > select first_name from employees
		//m12.do?type=2 > select last_name from employees
		
		List<String> names=this.dao.m12(type);
		
		model.addAttribute("name", names);
		return "list";
	}
	
	
	@GetMapping(value = "/m13.do")
	public String m13(Model model, String word, String column) {
		
		//1. 이름 : m13.do?column=name&word=홍길동
		//2. 주소 : m13.do?column=address&word=역삼
		//3. 나이 : m13.do?column=age&word=25
		
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("column", column);
		map.put("word", word);
		
		List<MyBatisDTO> list=this.dao.m13(map);
		
		model.addAttribute("list", list);
		return "list";
	}
	
	
}



















