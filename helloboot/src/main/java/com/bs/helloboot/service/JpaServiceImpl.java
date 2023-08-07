package com.bs.helloboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bs.helloboot.dao.JpaBoardDao;
import com.bs.helloboot.dao.JpaMemberDao;
import com.bs.helloboot.dto.BoardEntity;
import com.bs.helloboot.dto.Member;
@Service
public class JpaServiceImpl implements JpaService {
	@Autowired
	private JpaMemberDao memberDao;
	@Autowired
	private JpaBoardDao boardDao;
	
	@Override
	public Member selectByUserId(String id) {
		return memberDao.findById(id).orElseThrow();
		//Optional 객체를 사용 orElseThrow를 작성해서 결과가 없으면 예외를 발생시킬 수 있다.
	}

	@Override
	public void insertMember(Member insertMember) {
		memberDao.save(insertMember);
	}

	@Override
	public List<BoardEntity> selectBoardAll() {
		return boardDao.findAll(PageRequest.of(0, 5,Sort.by("boardDate").descending())).get().toList();
		//List로 맞춰주거나 Page<BoardEntity>로 반환 타입을 변경한다.
	}

	@Override
	public List<BoardEntity> selectByTitle(String title) {
		return boardDao.findByBoardTitleLike(title);
	}

	@Override
	public List<BoardEntity> selectByTitleAndContent(String title, String content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void boardRemove(long boardNo) {
		// TODO Auto-generated method stub
		
	}
	
}
