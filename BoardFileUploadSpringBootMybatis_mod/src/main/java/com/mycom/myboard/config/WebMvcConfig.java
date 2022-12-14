package com.mycom.myboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mycom.myboard.common.LoginInterceptor;

@Configuration //xml 설정을 대신 <- servlet-context.xml 의 설정 내용을 대체, interceptor 외에 다른 많은 설정 가능
public class WebMvcConfig implements WebMvcConfigurer{
	// interceptor 대한 정책
	// interceptor 객체 DI
	
	@Autowired
	private LoginInterceptor loginInterceptor; //DI로 주입
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry
		.addInterceptor(loginInterceptor) //인터셉터로 testInterceptor를 쓰겠다
			.addPathPatterns("/**") //유저로 시작하면 인터셉터 넣는다
			.excludePathPatterns("/","/index.html","/login.html","/register.html")
			.excludePathPatterns("/login/**", "/register/**", "/css/**", "/js/**", "/img/**"); //로그인으로 시작하면 인터셉터 뺀다
	}
	
}

// interface는 추상메소드만으로 구성, 바디를 가지는 default 메소드를 가질 수 없었음
// interface에 가령 20개의 추상 메소드가 있으면, 그걸 implements하는 클래스는 딱 2개만 구성하고 싶은데 18개를 다 구현해야 함 (빈 바디)
// 이게 불편해서 api에서 자주 사용되는 interface에 대해서는 클래스(...Adaptor) 를 제공
// ...Adaptor 클래스는 interface의 20개 메소드를 모두 구현(빈 바디) 함.
// A interface를 implements하는 것이 아니고, extends AAdaptor 해서 2개만 오버라이딩하면 되도록
// AAdaptor implements A로 구현
// => default로 구현이 되어있음