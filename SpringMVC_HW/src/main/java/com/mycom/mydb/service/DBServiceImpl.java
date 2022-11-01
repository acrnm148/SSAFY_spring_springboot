package com.mycom.mydb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.mydb.dao.DBDao;
import com.mycom.mydb.dto.User;

@Service
public class DBServiceImpl implements DBService{
	
	@Autowired
	DBDao dao;

	@Override
	public User userDetail(int id) {
		return dao.userDetail(id);
	}

	@Override
	public List<User> userList() {
		return dao.userList();
	}

	@Override
	public int userInsert(User dto) {
		return dao.userInsert(dto);
	}

	@Override
	public int userUpdate(User dto) {
		return dao.userUpdate(dto);
	}

	@Override
	public int userDelete(int id) {
		return dao.userDelete(id);
	}
}
