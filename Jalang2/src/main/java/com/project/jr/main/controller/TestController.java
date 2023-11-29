package com.project.jr.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/layout")
public class TestController {

	@GetMapping(value = "/test.do")
	public String test(Model model) {

		return "test";
	}
	
}
