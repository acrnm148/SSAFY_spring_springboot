package com.mycom.mydb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.mydb.dto.User;
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
	@GetMapping(value="/userDetail/{id}")
	@ResponseBody
	public User userDetail(@PathVariable int id) {
		System.out.println(id);
		
		User dto = service.userDetail(id);
		return dto;
	}
	
	//응답이니까 get
	@GetMapping(value="/userList")
	@ResponseBody
	public List<User> userList() {
		List<User> list = service.userList();
		System.out.println(list);
		return list;
	}
	
	//요청이니까 post
	@PostMapping(value="/userInsert")
	@ResponseBody //숫자 하나라도 json으로 FE에 보내줘야 한다. 받아오는걸 responseBody로 전부 json으로 보내줬다.
	public int userInsert(User user) { //FE에서 JSON으로 데이터가 넘어오지 않는다??
		System.out.println(user);
		
		int ret = service.userInsert(user);
		return ret;
	}
	
	@PostMapping(value="/userUpdate")
	@ResponseBody
	public int userUpdate(User user) {
		System.out.println(user);
		int ret = service.userUpdate(user);
		return ret;
	}
	
	@PostMapping(value="/userDelete")
	@ResponseBody
	public int userDelete(int id) {
		System.out.println(id);
		int ret = service.userDelete(id);
		return ret;
	}
	
}
