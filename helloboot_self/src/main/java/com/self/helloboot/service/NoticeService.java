package com.self.helloboot.service;

import java.util.List;

import com.self.helloboot.model.dto.Notice;

public interface NoticeService {
	List<Notice> selectAll();
}
