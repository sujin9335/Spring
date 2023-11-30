package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.domain.AddressDTO;
import com.test.persistence.AddressDAO;


@RestController // > 요청 메서드의 반환값에 자동으로 @ResponseBody가 적용된다 : public @ResponseBody int add
public class RESTController {

	@Autowired
	private AddressDAO dao;
	
	//CRUD + REST
	
	//추가하기
	//1. http://localhost/rest/address
	//2. POST
	//3. return int
	
	//@RequestMapping(value = "/address", method=RequestMethod.POST)
	@PostMapping(value = "/address")
	public int add(@RequestBody AddressDTO dto) {

		
		return dao.add(dto);
	}
	
	//목록보기
	//1. http://localhost:8090/rest/address
	//2. GET
	//3. return List<DTO> : json 형식
	@GetMapping(value = "/address")
	public List<AddressDTO> address() {

		return dao.list();
	}
	
	//수정하기 : 개별수정하면 비용이 크게들어 전체수정이라 PUT 으로 처리함(부분 수정이면 PATCH)
	//1. http://localhost:8090/rest/address/1 : 1 ?seq=1 같은 것 주소로 구분하려고, rest 방식임
	//2. PUT or PATCH
	//3. return int
	//@RequestMapping(value = "/address/{seq}", method=RequestMethod.PUT) //경로 변수(PathVariable
	@PutMapping(value = "/address/{seq}")
	public int edit(@RequestBody AddressDTO dto, @PathVariable("seq") String seq) { //@PathVariable : 주소의 seq값을 String seq에 지정해주세요 라는뜻
		
		dto.setSeq(seq);
		
		return dao.edit(dto);
	}
	
	
	//삭제하기
	//1. http://localhost:8090/rest/address/1
	//2. DELETE
	//3. return int
	
	@DeleteMapping(value = "/address/{seq}")
	public int delete(@PathVariable("seq") String seq) {
		
		return dao.del(seq);
	}
	
	//검색하기(=상세보기)
	//1. http://localhost:8090/rest/address/1
	//2. GET
	//3. return DTO
	
	@GetMapping(value = "/address/{seq}") //: 왜안됨?
	public AddressDTO get(@PathVariable("seq") String seq) {
		
		return dao.get(seq);
	}
	
	
	
	
	
	
	
	
	
	
}








