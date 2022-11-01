package com.mycom.myadv.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//rest 붙여서 무조건 json response

@RestController
public class InterceptorTestController {
	
	@GetMapping("/login") //login페이지 이동 효과
	public String m1() {
		System.out.println("/login");
		return "/login"; //jsp로 분기가 아니라, 그냥 문자열 그대로 json으로 response 하는 것.(restcontroller니까.)
	}
	
	@GetMapping("/login/ok") //login 성공 효과
	public String m2(HttpSession session) {
		System.out.println("/login/ok");
		session.setAttribute("login", "success");
		return "/login/ok"; //jsp로 분기가 아니라, 그냥 문자열 그대로 json으로 response 하는 것.(restcontroller니까.)
	}
	
	@GetMapping("/logout") //logout 성공 효과
	public String m3(HttpSession session) {
		System.out.println("/logout");
		session.invalidate();
		return "/logout"; //jsp로 분기가 아니라, 그냥 문자열 그대로 json으로 response 하는 것.(restcontroller니까.)
	}
	
	@GetMapping("/users") //일반 로그인 성공 후 갈 수 있는 페이지 효과
	public String m4() {
		System.out.println("/users");
		return "/users"; //jsp로 분기가 아니라, 그냥 문자열 그대로 json으로 response 하는 것.(restcontroller니까.)
	}
}
