package com.bs.helloboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bs.helloboot.dto.BoardEntity;
import com.bs.helloboot.service.JpaService;

@RestController
@RequestMapping("/board")
public class BaordController {
	@Autowired
	private JpaService service;
	@GetMapping
	public List<BoardEntity> selectBaordAll(){
		return service.selectBoardAll();
	}
	
	@GetMapping(params="title") //title이라는 파라미터가 있으면 실행
	public List<BoardEntity> selectBoardByTitle(){
		return service.selectByTitle(null);
	}
}
