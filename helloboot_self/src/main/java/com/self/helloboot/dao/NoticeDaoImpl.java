package com.self.helloboot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.self.helloboot.common.mapper.NoticeMapper;
import com.self.helloboot.model.dto.Notice;
@Repository
public class NoticeDaoImpl implements NoticeDao {
	private NoticeMapper mapper;
	
	@Override
	public List<Notice> selectAll() {
		return mapper.selectAll();
	}

}
