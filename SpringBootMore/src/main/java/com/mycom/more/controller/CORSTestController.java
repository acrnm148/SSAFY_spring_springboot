package com.mycom.more.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// vue - axios library <= http 통신 라이브러리
// axios library에서 http 요청을 보낼 때 credentials 설정 (true:기존세션유지/false:항상새로운 sessionId 전송)
// 이후, vue-cli로 개발 시 백엔드는 아래와 같이 origins= vue-cli 개발 서버 정보를, allowCredentials="true"로 설정해야 
//		sessionid가 지속되고 이를 통해서 로그인 등 서버세션을 사용할 수 있다.
// 서버세션을 사용하지 않으려면, jwt 등 별도의 state 저장 수단을 이용해야 함. 그럴 경우는 위 설정이 필요 X
//@CrossOrigin("*") // 모든 서버에대해 모든 처리를 허락한다. //서버세션(로그인..) <= 오류 발생. cookie를 통해서 전송되는 sessionid가 계속 변경됨, 로그인했는데도 깨짐
@CrossOrigin(
		origins="http://127.0.0.1:5500",
		//origins="*",
		allowCredentials="true",
		//sessionid를 기존처럼 고정 => server session 계속 사용
		allowedHeaders="*",
		methods= {
					RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
					RequestMethod.OPTIONS, RequestMethod.HEAD 
				}
)
@RestController
public class CORSTestController {

	@GetMapping("/getcors")
	public ResponseEntity<Map<String, String>> getCORS(String param) {
		System.out.println("getCORS : param : "+param);
		Map<String, String> map = new HashMap<> ();
		map.put("result", "success");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
	
	@PostMapping("/postcors")
	public ResponseEntity<Map<String, String>> postCORS(String param) {
		System.out.println("postCORS : param : "+param);
		Map<String, String> map = new HashMap<> ();
		map.put("result", "success");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
	
	@PutMapping("/putcors/{num}")
	public ResponseEntity<Map<String, String>> putCORS(@PathVariable int num) {
		System.out.println("postCORS : num : "+num);
		Map<String, String> map = new HashMap<> ();
		map.put("result", "success");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecors/{num}")
	public ResponseEntity<Map<String, String>> deleteCORS(@PathVariable int num) {
		System.out.println("deleteCORS : num : "+num);
		Map<String, String> map = new HashMap<> ();
		map.put("result", "success");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
}
