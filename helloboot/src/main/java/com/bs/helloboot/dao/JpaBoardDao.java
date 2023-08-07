package com.bs.helloboot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bs.helloboot.dto.BoardEntity;

@Repository
public interface JpaBoardDao extends JpaRepository<BoardEntity,Long>, PagingAndSortingRepository<BoardEntity, Long>{
	//필요한 컬럼에 대한 조회 메소드를 형식에 맞춰서 추상 메소드로 만들어준다.
	//select ->findBy필드명 : 필드와일치하는 값을 조회 where 필드명 : 매개변수값
	//부분일치 findBy필드명Like(값) : where 필드명 like '%'||값||'%'
	//다수 비교 findBy필드명And||Or필드명(값1, 값2) : where 필드명=값1 and||or 필드명=값2
	//null값 findBy필드명IsNull||IsNotNull
	//정렬 findBy필드명OrderBy필드명Asc||Desc(value)
	
	List<BoardEntity> findByBoardTitleLike(String title); //제목을 기준으로 부분일치 검색
	
	List<BoardEntity> findByBoardWriter(String boardWriter); //게시글 작성자로 검색
	
	//페이징처리
	//PagingAndSortingRepository<BoardEntity, Long>
	Page<BoardEntity> findAll(Pageable p); //springframework의 domain에 있는 것 임포트
	
	
}
