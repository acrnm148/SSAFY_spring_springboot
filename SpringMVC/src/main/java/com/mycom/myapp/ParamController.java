package com.mycom.myapp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycom.myapp.dto.CarDto;

@Controller
public class ParamController {

	@GetMapping("/param1") //seq param
	public void m1(HttpServletRequest request) {
		String seq = request.getParameter("seq");
		System.out.println(seq);
		
	}
	
	@GetMapping("/param2") //seq param //seq 필수
	public void m2(String seq) {
		System.out.println(seq);
		
	}
	
	@GetMapping("/param3") //seq param
	public void m3(@RequestParam(name="seq",required=true) String seq) {
		System.out.println(seq);
		
	}
	
	@GetMapping("/param4") //seq param
	public void m3(String name, int price) {
		System.out.println(name);
		System.out.println(price);
		
		CarDto dto = new CarDto();
		dto.setPrice(price);
		
	}
	
	@GetMapping("/car1") //seq param
	public void m5(CarDto dto, HttpServletRequest request) {// primitive type은 처리가 안됨 -> null처리
		System.out.println(dto);
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("Name"));
	}
	
	@GetMapping("/map") //seq param
	public void m6(@RequestParam Map<String, String> params) {// primitive type은 처리가 안됨 -> null처리
		System.out.println(params.get("name"));
		System.out.println(params.get("price"));
		System.out.println(params.get("owner"));
	}
	
	@GetMapping("/header") //seq param
	public void m7(
			@RequestHeader (value="Accept") String accept,
			@RequestHeader (value="Host") String host
		) {// primitive type은 처리가 안됨 -> null처리
		System.out.println(accept);
		System.out.println(host);
	}
	
	@GetMapping("/session") //seq param
	public void m8(HttpSession session, String msg) {// primitive type은 처리가 안됨 -> null처리
		System.out.println(msg);
		session.setAttribute("msg", msg); //다양한 용도로 session 객체를 활용
	}
}
