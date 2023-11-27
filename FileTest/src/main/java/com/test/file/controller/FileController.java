package com.test.file.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

	@GetMapping(value = "/add.do")
	public String add(Model model) {

		return "add";
	}
	
	@PostMapping(value = "/addok.do")
	public String addok(Model model, String txt, MultipartFile attach, HttpServletRequest req) {

		//System.out.println(txt);
		System.out.println(attach.getName()); //form 태그의 name 값
		System.out.println(attach.getOriginalFilename()); //업로드한 파일명
		System.out.println(attach.getContentType()); //MIME
		System.out.println(attach.getSize());
		System.out.println(attach.isEmpty());
		
		//파일 webapp > resources > files 위치로 이동시키기
		try {
			
			//1. 파일을 업로드 폴더에 이동하기
			//2. 파일명 중복 방지
			// a. 숫자 붙이기
			// b. 고유 접두어 붙이기
			//		- 시간_파일명
			//		- 난수_파일명
			System.out.println(System.nanoTime() + " " + attach.getOriginalFilename());
			
			// c. UUID(Universally Unique ID)
			//		- 네트워크상에서 고유성이 보장되는 id를 만들기 위한 표준
			//		- 시간+난수 조합
			UUID uuid=UUID.randomUUID();
			System.out.println(uuid);
 			//747aaadf-258d-435a-9954-8b31ebd36e3b_파일명
			
			String path=req.getRealPath("/resources/files");
			System.out.println(path);
			
			File file=new File(path+"\\"+uuid+"_"+attach.getOriginalFilename());
			
			//임시 폴더 > (이동) > files 폴더
			attach.transferTo(file);
			
			model.addAttribute("txt", txt);
			model.addAttribute("filename", uuid+"_"+attach.getOriginalFilename());
			model.addAttribute("orgfilename", attach.getOriginalFilename());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return "addok";
	}
	
	//다운로드 처리 코드
	@GetMapping(value = "/download.do", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String filename, HttpServletRequest req) {

		String path = req.getRealPath("/resources/files");
		Resource resource = new FileSystemResource(path + "\\" + filename);

		if (resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		String resourceName = resource.getFilename();

		// remove UUID
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);

		HttpHeaders headers = new HttpHeaders();
		try {

			String downloadName = null;

			if (userAgent.contains("Trident")) {
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+", " ");
			} else if (userAgent.contains("Edge")) {
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8");
			} else {
				downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
			}


			headers.add("Content-Disposition", "attachment; filename=" + downloadName);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
}
