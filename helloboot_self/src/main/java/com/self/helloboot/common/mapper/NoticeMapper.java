package com.self.helloboot.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.self.helloboot.model.dto.Notice;
@Mapper
public interface NoticeMapper {
	@Select("SELECT * FROM NOTICE")
	List<Notice> selectAll();
	
}
