package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	
	//String
	@GetMapping(value="/viewTest1")
	public String viewTest1() {
		System.out.println("viewTest1");
		return "viewTest1"; //prefix, suffix가 붙음
	}
	
	@GetMapping(value="/viewTest2")
	public String viewTest2() {
		System.out.println("viewTest2");
		return "sub/viewTest2"; //prefix, suffix가 붙음
	}
	
	// Model
	//addAttribute 이름 주의!!
	@GetMapping(value="/viewTest3")
	public String viewTest3(Model model) {
		System.out.println("viewTest3");
		
		model.addAttribute("seq","1234");
		model.addAttribute("empDto",new EmpDto(3000,"gildong","hong4","hong4@gildong.com", "2022-10-30"));
		return "viewTest3"; //prefix, suffix가 붙음
	}
	
	// ModelAndView 
	//addObject
	//model과 view를 한꺼번에 처리
	@GetMapping(value="/viewTest4")
	public ModelAndView viewTest3() {
		System.out.println("viewTest4");
		
		//ModelAndView mav = new ModelAndView();
		ModelAndView mav = new ModelAndView("viewTest4"); //생성자로 jsp이름 넣어줘도 가능
		//아래 2개는 데이터를 저장
		mav.addObject("seq","1234");
		mav.addObject("empDto",new EmpDto(3000,"gildong","hong4","hong4@gildong.com", "2022-10-30"));
		//jsp 이름 지정
		//mav.setViewName("viewTest4");
		return mav;
	}
	
	//위의 과정은 forward의 내용
	
	
	//redirect
	@GetMapping("/redirect")
	public String redirect() {
		System.out.println("redirect");
		return "viewTest1"; //이건 redirect가 아님 forward임
		//return "redirect:/viewTest1";
	}
	
}
