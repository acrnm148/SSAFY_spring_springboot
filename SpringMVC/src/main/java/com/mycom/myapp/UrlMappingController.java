package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/book")
public class UrlMappingController {
	//servlet에서는 /가 반드시 필요하나,  spring에서는 생략이 가능하다
//	@RequestMapping("hello")
//	public void m0() {
//		System.out.println("/hello");
//	}
	
	//servlet에서는 /* => *하나만 인식함. /** 가 없음
	@RequestMapping("/sub/*") //sub 바로 밑
	public void m01() {
		System.out.println("/sub*");
	}
	@RequestMapping("/sub/**") //sub 바로 밑 & 그 이하 전체 / 아무것도 없어도 얘가 커버함
	public void m02() {
		System.out.println("/sub**");
	}
	
	@RequestMapping("/hello")
	public void m1() {
		System.out.println("/hello");
	}
	
	@RequestMapping("/hello/ssafy")
	public void m2() {
		System.out.println("/hello/ssafy");
	}
	
	
	@RequestMapping(value={"/url1","/url2"})
	public void m3() {
		System.out.println("/url1, url2");
	}
	
	@RequestMapping(value="/method", method=RequestMethod.GET)
	public void m4() {
		System.out.println("/method/GET");
	}
	@RequestMapping(value="/method", method=RequestMethod.POST)
	public void m5() {
		System.out.println("/method/POST");
	}
	@RequestMapping(value="/method", method=RequestMethod.PUT)
	public void m6() {
		System.out.println("/method/PUT");
	}
	@RequestMapping(value="/method", method=RequestMethod.DELETE)
	public void m7() {
		System.out.println("/method/DELETE");
	}
	
	
	// book 수정
	// localhost:8080/myapp/book/123 PUT <= 123번 책을 수정
	@RequestMapping(value="/book/{bookNo}", method=RequestMethod.PUT)
	public void m8(@PathVariable String bookNo) {
		System.out.println("/method/PUT");
		System.out.println(bookNo);
	}
	// book 삭제
	// localhost:8080/myapp/book/123 DELETE <= 123번 책을 삭제
	@RequestMapping(value="/book/{bookNo}", method=RequestMethod.DELETE)
	public void m9(@PathVariable int bookNo) {
		System.out.println("/method/DELETE");
		System.out.println(bookNo);
	}
	
	// localhost:8080/myapp/book/123 GET <= bookNo, bookTitle 값으로 조회
	@RequestMapping(value = "/book/{writer}/and/{title}", method = RequestMethod.GET)
	public void m10(@PathVariable String writer, @PathVariable String title) {
		System.out.println("/method/GET");
		System.out.println(writer);
		System.out.println(title);
	}

	@GetMapping(value = "getmapping")
	public void m11() {
		System.out.println("/getmapping");
	}

	@PostMapping(value = "postmapping")
	public void m12() {
		System.out.println("/postmapping");
	}
}
