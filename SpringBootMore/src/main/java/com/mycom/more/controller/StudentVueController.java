package com.mycom.more.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.more.dto.StudentDto;
import com.mycom.more.service.StudentService;

@CrossOrigin(
		origins="http://127.0.0.1:5500", //여기서 CORS 오류날 VSCode 포트번호 지정해줌
		//origins="*",
		allowCredentials="true",
		//sessionid를 기존처럼 고정 => server session 계속 사용
		allowedHeaders="*",
		methods= {
					RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
					RequestMethod.OPTIONS, RequestMethod.HEAD 
				}
)

@RestController //(value="/vue") //이러면 전체 붙는다
@RequestMapping("/vue")
public class StudentVueController {

	@Autowired
	StudentService service;
	
	@GetMapping(value="/students")
	public List<StudentDto> list(){
		List<StudentDto> list = service.list();
		for (StudentDto studentDto : list) {
			System.out.println(studentDto);
		}
		
		return list;
	}
	
	@GetMapping(value="/students/{studentId}")
	public StudentDto detail(@PathVariable int studentId){
		System.out.println("detail : studentId : " + studentId);
		
		return service.detail(studentId);
	}
	
	//등록 json from client by axios
	@PostMapping(value="/students")
	public int insert(@RequestBody StudentDto dto) {
		System.out.println("insert");
		System.out.println(dto);
		
		return service.insert(dto);
	}
	
	//수정 json from client by axios
	@PutMapping(value="/students/{studentId}")
	public int update(StudentDto dto) {
		System.out.println("update");
		System.out.println(dto);
		
		return service.update(dto);
	}
	
	//삭제
	@DeleteMapping(value="/students/{studentId}")
	public int delete(@PathVariable int studentId) {
		System.out.println("delete : " + studentId);

		return service.delete(studentId);
	}
}








