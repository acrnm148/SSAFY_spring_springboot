package com.mycom.mydb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.mydb.dto.EmpDto;
import com.mycom.mydb.service.DBService;

@Controller
public class DBController {

	@Autowired
	DBService service;
	
	
	@GetMapping(value="/")
	public String dbTest() {
		System.out.println("DBController / ");
		return "dbTest"; //prefix, suffix가 붙음
	}
	
	
	//응답이니까 get
	@GetMapping(value="/empDetail/{employeeId}")
	@ResponseBody
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println(employeeId);
		
		EmpDto dto = service.empDetail(employeeId);
		return dto;
	}
	
	//응답이니까 get
	@GetMapping(value="/empList")
	@ResponseBody
	public List<EmpDto> empList() {
		List<EmpDto> list = service.empList();
		System.out.println(list);
		return list;
	}
	
	//요청이니까 post
	@PostMapping(value="/empInsert")
	@ResponseBody //숫자 하나라도 json으로 FE에 보내줘야 한다. 받아오는걸 responseBody로 전부 json으로 보내줬다.
	public int empInsert(EmpDto empDto) { //FE에서 JSON으로 데이터가 넘어오지 않는다??
		System.out.println(empDto);
		
		int ret = service.empInsert(empDto);
		return ret;
	}
	
	@PostMapping(value="/empUpdate")
	@ResponseBody
	public int empUpdate(EmpDto empDto) {
		System.out.println(empDto);
		int ret = service.empUpdate(empDto);
		return ret;
	}
	
	@PostMapping(value="/empDelete")
	@ResponseBody
	public int empDelete(int employeeId) {
		System.out.println(employeeId);
		int ret = service.empDelete(employeeId);
		return ret;
	}
	
}
