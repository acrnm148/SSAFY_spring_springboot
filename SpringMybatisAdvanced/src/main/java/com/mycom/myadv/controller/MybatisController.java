package com.mycom.myadv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myadv.dto.StudentDto;
import com.mycom.myadv.service.MybatisService;

@RestController
public class MybatisController {

	@Autowired
	MybatisService service;
	
	@PostMapping(value="/insert")
	public ResponseEntity<Integer> insert(@RequestBody StudentDto dto) {
		System.out.println(dto);
		int ret = service.studentInsert(dto);
		//return ret; //성공여부 int 리턴
		return new ResponseEntity<Integer>(ret, HttpStatus.OK); //map으로 결과 데이터 리턴
	}
}
