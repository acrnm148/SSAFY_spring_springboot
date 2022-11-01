package com.mycom.more.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TestInterceptor implements HandlerInterceptor {
	
	// DispatcherServlet 이후 다른 Controller의 메소드를 실행하기 직전에 호출
	// 뭔가 테스트를 진행하고 그 결과에 따라 return true하면 Controller로 진행
	// return false 하면 Controller로 진행 X => empty한 response를 Client에게 보낸다.
	
	// 테스트하려는 항목이 뭔가!! => 이곳 코드 안에서 처리, 판단
	// 이걸 누구에게 적용할 것인가!! => 설정을 통해서 servlet-context.xml 지정
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) throws Exception {
		
		System.out.println("TestInterceptor : preHandle !!!");
		
		// #1 무조건 통과 true
		//return true;
		// #2 로그인
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("login");
		//로그인 상태
		if ("success".equals(login)) return true;
		//로그아웃 상태
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().write("login 이 필요합니다.");
		return false;
	}
}
