package com.mycom.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.mybatis.dto.EmpDto;
import com.mycom.mybatis.service.MybatisService;

@RestController
public class MybatisController {

	@Autowired
	MybatisService service;
	
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
	
	
	@GetMapping(value="/empListParameterMap")
	public List<EmpDto> empListParameterMap(String firstName, String lastName) {
		Map<String, String> map = new HashMap<> ();
		map.put("firstName", firstName);
		map.put("lastName", lastName);
		List<EmpDto> list = service.empListParameterMap(map);
		return list;
	}
	
	@GetMapping(value="/empListParameterMap2")
	public List<EmpDto> empListParameterMap2(String firstName, String lastName) {
		
		List<EmpDto> list = service.empListParameterMap2(firstName, lastName);
		return list;
	}
	
	@GetMapping(value="/empListParameterMap3")
	public List<EmpDto> empListParameterMap3(EmpDto dto) {
		List<EmpDto> list = service.empListParameterMap3(dto);
		return list;
	}
	
	@GetMapping(value="/empListLike")
	public List<EmpDto> empListLike(String firstName) {
		List<EmpDto> list = service.empListLike(firstName);
		return list;
	}
	
}
