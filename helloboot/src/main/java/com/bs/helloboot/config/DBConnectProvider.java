package com.bs.helloboot.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.bs.helloboot.dao.MemberDao;
import com.bs.helloboot.dto.Member;
@Component
public class DBConnectProvider implements AuthenticationProvider{
	
	private MemberDao dao;
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	public DBConnectProvider(MemberDao dao) { //의존성 주입
		this.dao=dao;
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userId=authentication.getName();
		String password=(String)authentication.getCredentials();
		
		Member loginMember=dao.selectMemberById(userId);
		if(loginMember==null||encoder.matches(password, loginMember.getPassword())) {
			//로그인 실패
			throw new BadCredentialsException("인증 실패");
		}
		return new UsernamePasswordAuthenticationToken(
				loginMember, loginMember.getPassword(), loginMember.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		//UsernamePasswordAhthenticationToken을 사용할 수 있게 함
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
}
