package com.bs.helloboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.bs.helloboot.dto.MyAuthority;

@Configuration //config 클래스로 등록
@EnableWebSecurity //security 설정
public class SecurityConfig {
	
	private DBConnectProvider provider;
	public SecurityConfig(DBConnectProvider provider) {
		this.provider=provider;
	}
	//spring boot에서 security 적용
	//1. 인증 처리할 bean 등록
	// 	인증 관련 설정을 하는 bean으로 SecurityFilterChain 객체를 반환한다.
	//2. 인증 처리 시, 인증 방법에 대한 설정을 하는 클래스 등록
	//	in memory, DB 연동방식 두가지로 나뉜다. 인메모리는 사용하지 않음
	//	클래스 방식으로 provider를 등록한다.
	
	@Bean
	public SecurityFilterChain authenticationPath(HttpSecurity http) throws Exception {
		//HttpSecurity를 셋팅해서 SecurityFilterChain을 반환
		//and()메소드를 사용하면 다시 HttpSecurity를 반환해서 접근해서 이어서 사용할 수 있다.
		return http.csrf().disable()
				.formLogin()
					.successForwardUrl("/successLogin")
					.failureForwardUrl("/errorLogin")
					.passwordParameter("pw")
					.loginProcessingUrl("/login.do")
					.loginPage("/loginpage")
				.and()
				.authorizeHttpRequests() //interceptor를 등록하는 것과 같은 기능
					.antMatchers("/loginpage").permitAll()
					.antMatchers("/errorLogin").permitAll()
					.antMatchers("/**").hasAnyAuthority(MyAuthority.ADMIN.name(),MyAuthority.USER.name())
				.and()
				.logout()
					.logoutSuccessUrl("/logout")
					.logoutUrl("/logout.do")
				.and()
				.authenticationProvider(provider)
				.build();
	}
}
