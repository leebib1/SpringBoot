package com.bs.helloboot.service;

import java.util.List;

import com.bs.helloboot.dto.BoardEntity;
import com.bs.helloboot.dto.Member;

public interface JpaService {
	Member selectByUserId(String id);

	void insertMember(Member insertMember);
	
	List<BoardEntity> selectBoardAll();
	
	List<BoardEntity> selectByTitle(String title);
	
	List<BoardEntity> selectByTitleAndContent(String title, String content);
	
	void boardRemove(long boardNo);
}
