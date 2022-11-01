package com.mycom.myboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// JSP 3개의 이동에 대한 처리만
@Controller
public class HomeController {

	@GetMapping(value = {"/", "/board"})
	public String home() {
		return "/board/boardMain";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "/login";
	}
	
	@GetMapping(value = "/register")
	public String register() {
		return "/register";
	}
}
