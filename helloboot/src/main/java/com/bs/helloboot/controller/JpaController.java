package com.bs.helloboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bs.helloboot.dto.Member;
import com.bs.helloboot.service.JpaService;

@RestController
@RequestMapping("/jpa/member")
public class JpaController {
	@Autowired
	private JpaService service;
	
	@GetMapping("/{id}") //주소에 들어온 값을 id로 이용
	public Member selectByUserId(@PathVariable("id") String id) {
		return null;
	}
	
	@GetMapping("/insertMember")
	public ResponseEntity<Member> insertMember(){
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(); //bean으로 등록해서 사용해도 된다.
		Member insertMember=Member.builder().userId("user01").password(encoder.encode("1234"))
				.address("서울시 금천구").age(19).gender("M").email("test@test.com").hobby("운동").name("추가유저").build();
		service.insertMember(insertMember);
		return ResponseEntity.ok(insertMember);
	}
}
