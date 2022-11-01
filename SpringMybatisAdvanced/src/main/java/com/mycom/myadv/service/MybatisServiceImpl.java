package com.mycom.myadv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.myadv.dao.MybatisDao;
import com.mycom.myadv.dto.StudentDto;

@Service
public class MybatisServiceImpl implements MybatisService{

	@Autowired
	MybatisDao dao;
	
	@Override
	@Transactional
	public int studentInsert(StudentDto studentDto) {
		dao.studentInsert(studentDto); 
		
		//오류 - runtime Exception -> nullpointException
		String str = null;
		str.length();
		
		return dao.studentInsert(studentDto);
	}

}
