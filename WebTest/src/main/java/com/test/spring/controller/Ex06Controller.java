package com.test.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.spring.domain.SpringDTO;

@Controller
public class Ex06Controller {

	//요청 메서드의 반환 자료형
	//-1(***) > 가장 빈도 높음
	//-3(redirect)
	//-5
	
	
	
	//1.String 
	//- JSP 파일명
	//- ViewResolver 호출
//	@GetMapping(value = "/ex06.do")
//	public String test() {
//		
//		return "ex06";
//	}
	
	
	//2. void
	//- 자동으로 요청 주소와 동일한 이름의 JSP 페이지를 찾아서 호출한다
//	@GetMapping(value = "/ex06.do")
//	public void test() {
//		
//		
//	}
	
	
	//3. String(키워드)
	//- redirect:
	//- forward:
//	@GetMapping(value = "/ex06.do")
//	public String test() {
//		
//		//resp.sendRedirect("/ex05.do") 이거랑 같은 방식
//		//return "redirect:/ex05.do";
//		
//		//pageContext.forward()
//		return "forward:/ex05.do";
//	}
	
	
	//4. String(키워드) : 주소창에 키값으로 데이터 보내는 방식 
//		@GetMapping(value = "/ex06.do")
//		public String test(RedirectAttributes rttr) {
//			
//			String seq="5";
//			String type="2";
//			
//			rttr.addAttribute("seq", seq);
//			rttr.addAttribute("type", type);
//			
//			//이렇게 해도 됨 그러나 RedirectAttributes rttr를 쓰면됨
//			//return "redirect:/ex05.do?seq=" + seq + "&type=" + type;
//			
//			return "redirect:/ex05.do";
//		}
	
	
	//5. JSON 반환
	//- @ResponseBody : .jar 파일 하나 porm에 추가해야됨
//	@GetMapping(value = "/ex06.do")
//	public @ResponseBody SpringDTO test() {
//		
//		SpringDTO dto=new SpringDTO();
//		dto.setName("홍길동");
//		dto.setAge("20");
//		dto.setAddress("서울시");
//		
//		return dto;
//	}
	
	
	//6. JSON array
	@GetMapping(value = "/ex06.do")
	public @ResponseBody List<SpringDTO> test() {
		
		SpringDTO dto=new SpringDTO();
		dto.setName("홍길동");
		dto.setAge("20");
		dto.setAddress("서울시");
		
		SpringDTO dto2=new SpringDTO();
		dto2.setName("아무개");
		dto2.setAge("20");
		dto2.setAddress("서울시");
		
		List<SpringDTO> list=new ArrayList<SpringDTO>();
		list.add(dto);
		list.add(dto2);
		
		return list;
	}
	
	
	
	
	
}
