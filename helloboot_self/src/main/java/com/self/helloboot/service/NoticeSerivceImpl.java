package com.self.helloboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.self.helloboot.dao.NoticeDao;
import com.self.helloboot.model.dto.Notice;
@Service
public class NoticeSerivceImpl implements NoticeService {
	private NoticeDao dao;
	
	@Override
	public List<Notice> selectAll() {
		return dao.selectAll();
	}

}
