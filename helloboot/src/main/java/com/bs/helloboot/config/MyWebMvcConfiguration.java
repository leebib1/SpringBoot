package com.bs.helloboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.bs.helloboot.common.interceptor.LoggerInterceptor;
import com.bs.helloboot.websocket.ChattingServer;

@Configuration //환경 설정
@EnableWebSocket //websocket을 불러옴
public class MyWebMvcConfiguration implements WebMvcConfigurer, WebSocketConfigurer{

	//WebMvcConfigurer 인터페이스를 재정의해서 사용
	//web.xml에 설정하던 서버 관련 설정을 작성할 수 있다.
	
	private ChattingServer chatting;
	public MyWebMvcConfiguration(ChattingServer chatting) {
		this.chatting=chatting;
	}
	
	//view에 대한 설정
	//기본 화면 전환에 대한 설정을 하는 메소드를 재정의할 수 있다.
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index"); //해당 주소에 index를 연결시킨다.
		registry.addViewController("/test").setViewName("test");
		registry.addViewController("/chattingpage").setViewName("chatting");
	}
	
	//Interceptor 설정
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/member/*");
	}

	//cors에 대한 허용 설정
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:3000");
	}

	//websocket 서버 등록
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(chatting, "/chatting");
		
	}
	
	
	
}
