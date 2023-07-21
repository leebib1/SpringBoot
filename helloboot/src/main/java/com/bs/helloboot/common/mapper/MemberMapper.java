package com.bs.helloboot.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.bs.helloboot.dto.Member;

@Mapper
public interface MemberMapper {
	
	@Select("SELECT * FROM MEMBER")
	List<Member> selectMemberAll();
	
	@Select("SELECT * FROM MEMBER WHERE USERID=#{id}")
	Member selectMemberById(String id);
	
	//@Select("SELECT * FROM MEMBER WHERE USERNAME LIKE '%'||#{name}||'%' AND")
	@SelectProvider(type=MemberSelectBuilder.class, method="selectMemberByWhere")
	List<Member> selectMemberByWhere(Map<String,Object> param);
}
