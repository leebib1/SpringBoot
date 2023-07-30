package com.bs.helloboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bs.helloboot.dto.Member;
import com.bs.helloboot.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@CrossOrigin(origins = "http://localhost:8889") 
public class BasicController {
	//yml 파일에 지정해둔 데이터를 불러와서 사용 가능
	@Value("${linux.url}")
	private String url;
	@Value("${linux.baseDir}")
	private String baseDir;
	
	private MemberService service;
	public BasicController(MemberService service) {
		this.service=service;
	}
	
	@PostMapping("/fileUpload")
	public String fileUpload(MultipartFile[] upFile) {
//		log.debug(upFile.getOriginalFilename());
//		log.debug("{}",upFile.getSize());
		for(MultipartFile f:upFile) {
			log.debug(f.getOriginalFilename());
		}
		
		//upFile.transferTo(new File(file경로+renamedFileName));
		return "redirect:/";
	}
	
	@GetMapping("/values")
	public String valuesCheck() {
		log.debug(url);
		log.debug(baseDir);
		return "redirect:/";
	}
	
	@PostMapping("/datatest")
	public String datatest(String data) {
		log.debug(data);
		return "redirect:/";
	}
	
	@PostMapping("/memberId")
	@ResponseBody
	public Member selectMemberById(String userId) {
		return service.selectMemberById(userId);
	}
	
	@GetMapping("/membername")
	@ResponseBody
	public List<Member> selectMemberByName(String name){
		Map<String,Object> param=new HashMap<>();
		param.put("userName", name);
		return service.selectMemberByName(param);
	}
	
	@GetMapping("/ajax/memberAll")
	public List<Member> memberAll(){
		return service.selectMemberAll();
	}
	
	
	
	
	
	
}
