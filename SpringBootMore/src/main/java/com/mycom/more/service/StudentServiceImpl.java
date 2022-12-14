package com.mycom.more.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.more.dao.StudentDao;
import com.mycom.more.dto.StudentDto;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao dao;

	@Override
	public List<StudentDto> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public StudentDto detail(int studentId) {
		// TODO Auto-generated method stub
		return dao.detail(studentId);
	}

	@Override
//	@Transactional //비싼 어노테이션 => 반드시 필요한 경우에만 사용
	public int insert(StudentDto dto) {
//		dao.insert(dto);
//		String str = null;
//		str.length();
		return dao.insert(dto);
	}

	@Override
//	@Transactional
	public int update(StudentDto dto) {
//		dao.update(dto); //A
//		
//		String str = null;
//		str.length();
//		
//		dto.setEmail("트랜잭션 되면 롤백돼서 A도 B도 아닌 상태가 되어야 함"); //B
		return dao.update(dto);
	}

	@Override
	public int delete(int studentId) {
		// TODO Auto-generated method stub
		return dao.delete(studentId);
	}
}
