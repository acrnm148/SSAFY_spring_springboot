package com.mycom.mydb.service;

import java.util.List;

import com.mycom.mydb.dto.User;

public interface DBService {
	List<User> userList();
	User userDetail(int id);
	int userInsert(User dto); 
	int userUpdate(User dto);
	int userDelete(int employeeId);
}
