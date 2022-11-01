package com.mycom.myboard.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycom.myboard.dto.UserDto;

@Component
public class LoginInterCeptor implements HandlerInterceptor {
	
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
		
		System.out.println("LoginInterceptor : preHandle !!!");
		
		// #1 무조건 통과 true
		//return true;
		// #2 로그인
//		HttpSession session = request.getSession();
//		UserDto userDto = (UserDto)session.getAttribute("userDto");
//		
//		
//		//로그인 상태
//		//async에 대한 처리 미구현!!
//		//=>
//		if (userDto == null) {
//			response.sendRedirect("/login");
//			return false; //미통과 // 단디 return false만 하면 아무런 반응이 없다 <= response 필요
//		} 
		return true; //통과 //클라이언트가 가고자 하는 요청으로 넘어간다
	}
}
