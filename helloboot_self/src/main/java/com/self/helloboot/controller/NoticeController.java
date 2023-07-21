package com.self.helloboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.self.helloboot.service.NoticeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice")
@Slf4j
public class NoticeController {
	private NoticeService service;
	private NoticeController(NoticeService service) {
		this.service=service;
	}
	
	@GetMapping("/")
	public String selectNoticeAll(Model model) {
		model.addAttribute("notices",service.selectAll());
		return "notice/noticeList";
	}
}
