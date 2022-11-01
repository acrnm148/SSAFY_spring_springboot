package com.mycom.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.rest.dto.StudentDto;

@RestController // @Controller + @ResponseBody
public class StudentController {
	
	//목록 => GET /students
	@GetMapping(value="/students")
	public List<StudentDto> list() {
		System.out.println("GET /students");
		List<StudentDto> list = new ArrayList<> ();
		list.add(new StudentDto(111, "홍길동", "hong@gildong", "010-1111-1111"));
		list.add(new StudentDto(222, "이길동", "lee@gildong", "010-2222-2222"));
		list.add(new StudentDto(333, "삼길동", "sam@gildong", "010-3333-3333"));
		return list; //json
	}
	
	//상세 => GET /students/123
	@GetMapping(value="/studnets/{studentId}")
	public StudentDto detail(@PathVariable int studentId) {
		System.out.println("GET /students/"+studentId);
		return new StudentDto(222, "이길동", "lee@gildong", "010-2222-2222");
	}
	
	//등록 => POST /students
	@PostMapping(value="/students")
	public int insert(StudentDto dto) { // x-www-form-urlencoded <= encoding
		System.out.println("POST /students");
		System.out.println(dto);
		return 1;
	}
	
	//수정 => PUT /students/123
	@PutMapping(value="/students/{studentId}")
	public int update(@PathVariable int studentId, @RequestBody StudentDto dto) { // x-www-form-urlencoded <= encoding 지원X
		System.out.println("PUT /students/"+studentId);
		System.out.println(dto);
		return 1;
	}
	
	//삭제 => DELETE /students/123
	@DeleteMapping(value="/students/{studentId}")
	public int delete(@PathVariable int studentId) {
		System.out.println("DELETE /students/"+studentId);
		return 1;
	}
}
