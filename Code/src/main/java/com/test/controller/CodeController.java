package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.domain.CodeDTO;
import com.test.persistence.CodeDAO;

@Controller
public class CodeController {

	@Autowired
	private CodeDAO dao;
	
	@GetMapping(value = "/add.do")
	public String add() {
		
		return "add";
	}
	
	@PostMapping(value = "/addok.do")
	public String addok(CodeDTO dto) {
		
		int result=dao.add(dto);
		
		if(result == 1) {
			return "redirect:/list.do";
		}else {
			return "redirect:/add.do";
		}
		
		
	}
	
	@GetMapping(value="/list.do")
	public String list(Model model, @RequestParam(name="language", required = false) List<String> language) {
		
		//- list.do : 뒤에 아무것도 없을 때도 있어서 '@RequestParam' 에서 'required=false' 해야된다
		//- list.do?language=java
		//- list.do?language=java&language=css 배열이다
		
		List<CodeDTO> list=dao.list(language);
		
		model.addAttribute("list", list);
		model.addAttribute("language", language);
		
		return "list";
	}
	
	@GetMapping(value = "/view.do")
	public String view(Model model, String seq) {
		
		CodeDTO dto=dao.get(seq);
		
		model.addAttribute("dto", dto);
		
		return "view";
	}
	
}