package com.mycom.myadv.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myadv.dto.StudentDto;

@Mapper
public interface MybatisDao {
	int studentInsert(StudentDto studentDto);
}
