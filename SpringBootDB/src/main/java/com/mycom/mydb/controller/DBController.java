package com.mycom.mydb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.mydb.dto.EmpDto;
import com.mycom.mydb.service.DBService;

@RestController
public class DBController {

	@Autowired
	DBService service;
	
	//응답이니까 get
	@GetMapping(value="/empDetail/{employeeId}")
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println(employeeId);
		
		EmpDto dto = service.empDetail(employeeId);
		return dto;
	}
	
	//응답이니까 get
	@GetMapping(value="/empList")
	public List<EmpDto> empList() {
		List<EmpDto> list = service.empList();
		System.out.println(list);
		return list;
	}
	
	//요청이니까 post
	@PostMapping(value="/empInsert")
	public int empInsert(EmpDto empDto) { //FE에서 JSON으로 데이터가 넘어오지 않는다??
		System.out.println(empDto);
		
		int ret = service.empInsert(empDto);
		return ret;
	}
	
	@PostMapping(value="/empUpdate")
	public int empUpdate(EmpDto empDto) {
		System.out.println(empDto);
		int ret = service.empUpdate(empDto);
		return ret;
	}
	
	@PostMapping(value="/empDelete")
	public int empDelete(int employeeId) {
		System.out.println(employeeId);
		int ret = service.empDelete(employeeId);
		return ret;
	}
	
}
