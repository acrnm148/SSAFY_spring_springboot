package com.mycom.basic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class BasicController {

	@RequestMapping(value="/")
	public String home() { //return 되는 문자열 앞 뒤에 prefix suffix 붙여서 jsp를 찾아가는 처리가 Spring MVC
		return "home";
	}
}
