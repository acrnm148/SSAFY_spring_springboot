package com.mycom.myboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mycom.myboard.dto.UserDto;
import com.mycom.myboard.service.LoginService;

@RestController
@CrossOrigin(
	    // localhost:5500 과 127.0.0.1 구분
	    origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
	    allowCredentials = "true", 
	    allowedHeaders = "*", 
	    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
	)
public class LoginController {
	
	@Autowired
	LoginService service;
	
	// "result":"success" / "fail"
	@PostMapping(value="/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody UserDto dto, HttpSession session) {
		// dto에는 client가 보낸 userEmail, userPassword가 자동으로 파라미터 처리되어진다.
		UserDto userDto = service.login(dto);
		Map<String, String> map = new HashMap<>();
		
		if (userDto != null) { // 로그인 성공
			// session에 userDto를 저장
			// client에게 성공 결과를 json으로 전달
			session.setAttribute("userDto", userDto);
			map.put("result", "success");

			map.put("userName", userDto.getUserName());
			map.put("userProfileImageUrl", userDto.getUserProfileImageUrl());
//			Gson gson = new Gson();
//            String jsonStr = gson.toJson(userDto, UserDto.class);
//            session.setAttribute("userDto", userDto);
//            map.put("userDto", jsonStr);
            map.put("result","success");
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		}
		// 로그인 실패
		map.put("result", "fail");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/userImg")
    public ResponseEntity<Map<String, String>> profile(HttpSession session) {
        String url = ((UserDto) session.getAttribute("userDto")).getUserProfileImageUrl();
        System.out.println(url);
        Map<String, String> map = new HashMap<>();
        map.put("result", url);
        
        return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
    }
	
}
