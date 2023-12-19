package com.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.domain.BookDTO;
import com.test.persistence.BookDAO;
import com.test.persistence.BookRepository;


@Controller
public class BookController {
	
	@Autowired
	BookDAO dao;
	
	@Autowired
	BookRepository reop;

	//목록보기
	@GetMapping(value = "/list.do")
	public String list(Model model, String word) {

		System.out.println(word);
		if(word == null || word.equals("")) { 
			//검색(x) > 목록보기 > 오라클 조회
			List<BookDTO> list=dao.list();
			model.addAttribute("list", list);
		}else {
			//검색(o) > 검색하기 > 엘라스틱서치 조회
			List<Map<String,Object>> list= reop.search(word);
			model.addAttribute("list", list);
		}
		
		List<BookDTO> list=dao.list();
		System.out.println(list.toString());
		model.addAttribute("list", list);
		model.addAttribute("word", word);
		
		System.out.println(list.toString());
		
		return "list";
	}
	
	
	@GetMapping(value = "/add.do")
	public String add(Model model) {

		
		
		return "add";
	}

	//추가하기(처리)
	@PostMapping(value = "/addok.do")
	public String addok(Model model, BookDTO dto) {

		reop.add(dto); //DB >seq 발생
		
		String seq=dao.getSeq();
		dto.setSeq(seq);
		
		dao.add(dto);
		
		return "redirect:/list.do";
	}
	
	//상세보기
	@GetMapping(value = "/view.do")
	public String view(Model model, String seq) {

		
		BookDTO dto=dao.get(seq);
		model.addAttribute("dto", dto);
		
		return "view";
	}
	
}
