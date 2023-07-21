package com.self.helloboot.dao;

import java.util.List;

import com.self.helloboot.model.dto.Notice;

public interface NoticeDao {
	List<Notice> selectAll();
}
