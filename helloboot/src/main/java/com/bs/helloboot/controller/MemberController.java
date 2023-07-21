package com.bs.helloboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bs.helloboot.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {
	
	private MemberService service;
	public MemberController(MemberService service) {
		this.service=service;
	}
	
//	@GetMapping("/")
//	public String index() {
//		return "index";
//	}
	
	@GetMapping("/memberAll")
	public String selectMemberAll(Model model) {
		model.addAttribute("members",service.selectMemberAll());
		return "member/memberList";
	}
}
