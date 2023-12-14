package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.domain.BookDTO;
import com.test.persistence.BookDAO;


@Controller
public class BookController {
	
	@Autowired
	BookDAO dao;

	//목록보기
	@GetMapping(value = "/list.do")
	public String list(Model model) {

		List<BookDTO> list=dao.list();
		System.out.println(list.toString());
		model.addAttribute("list", list);
		
		return "list";
	}
	
	
	@GetMapping(value = "/add.do")
	public String add(Model model) {

		
		
		return "add";
	}

	//추가하기(처리)
	@PostMapping(value = "/addok.do")
	public String addok(Model model, BookDTO dto) {

		dao.add(dto);
		
		return "addok";
	}
	
	//상세보기
	@GetMapping(value = "/view.do")
	public String view(Model model, String seq) {

		
		BookDTO dto=dao.get(seq);
		model.addAttribute("dto", dto);
		
		return "view";
	}
	
}
