package com.bs.helloboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.helloboot.dto.Member;

@Repository
public interface JpaMemberDao extends JpaRepository<Member,String>{ 
	//스프링에서 제공하는 JpaRepository를 상속 받음
	//JpaRepository가 CRUD를 다 갖고있다.
	//사용할 엔티티와 PK의 자료형을 작성해준다.
	
}
