package com.mycom.mydb.dao;

import java.util.List;

import com.mycom.mydb.dto.User;

public interface DBDao {
	List<User> userList();
	User userDetail(int id);
	int userInsert(User dto); 
	int userUpdate(User dto);
	int userDelete(int employeeId);
}
