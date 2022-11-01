package com.mycom.myadv.service;

import org.springframework.stereotype.Service;

import com.mycom.myadv.dto.StudentDto;


public interface MybatisService {
	int studentInsert(StudentDto studentDto);
}
