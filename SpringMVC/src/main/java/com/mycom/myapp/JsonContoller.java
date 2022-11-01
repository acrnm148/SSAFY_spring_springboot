package com.mycom.myapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonContoller {
	
	//get data
	@PostMapping(value="/emp")
	public void m1(@RequestBody EmpDto dto) {
		System.out.println(dto);
	}
	
	@PostMapping(value="/empList")
	public void m2(@RequestBody List<EmpDto> empList) {
		for (EmpDto empDto:empList) {
			System.out.println(empDto);
		}
	}
	
	//send data
	@GetMapping(value="/empDetail/{employeeId}")
	@ResponseBody
	public EmpDto m3(@PathVariable int employeeId) {
		System.out.println(employeeId);
		// employeeId에 맞는 EmpDto 객체를 만들어서 json으로 response
		EmpDto empDto = new EmpDto(2000, "길동4", "홍4", "hong4@gildong.com","2022-10-19");
		// 위에 만든 empDto를 json으로 어떻게 처리??
		return empDto;
	}
	
	@GetMapping(value="/empList")
	@ResponseBody
	public List<EmpDto> m4() {
		// EmpDto 객체 3~4개를 List로 만들어서 FE로 json 형태로 전송
		EmpDto empDto = new EmpDto(2000, "길동4", "홍4", "hong4@gildong.com","2022-10-19");
		EmpDto empDto2 = new EmpDto(2000, "길동4", "홍4", "hong4@gildong.com","2022-10-19");
		EmpDto empDto3 = new EmpDto(2000, "길동4", "홍4", "hong4@gildong.com","2022-10-19");
		List<EmpDto> list = new ArrayList<> ();
		list.add(empDto);
		list.add(empDto2);
		list.add(empDto3);
		// 위에 만든 empDto를 json으로 어떻게 처리??
		return list;
	}
	
	@GetMapping("/localDateTime")
	@ResponseBody //json으로 바껴서 날라감
	public LocalDateTime m5() {
		return LocalDateTime.now();
	}
}
