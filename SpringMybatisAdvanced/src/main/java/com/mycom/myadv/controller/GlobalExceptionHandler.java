package com.mycom.myadv.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//예외 처리 2가지
//#1. Controller별 처리
//#2. Global 처리

// 개별 Controller에서 처리되지 않는 예외에 대한 처리
@ControllerAdvice
public class GlobalExceptionHandler {
	
//	@ExceptionHandler
//	public ModelAndView erorrHandler(HttpServletRequest req, Exception e) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception", e);
//		mav.addObject("url", req.getRequestURL());
//		mav.setViewName("globalError");
//		return mav;
//	}
	
	
	@ExceptionHandler
	public ResponseEntity<Map<String, String>> erorrHandler(HttpServletRequest req, Exception e) {
		Map<String, String> map = new HashMap<> ();
		map.put("result", "ajax_exception");
		//e.printStackTrace(); //에러 내용 출력
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
