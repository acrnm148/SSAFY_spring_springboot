package com.mycom.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycom.mybatis.dto.EmpDto;

@Mapper
public interface MybatisDao {
	List<EmpDto> empList();
	EmpDto empDetail(int employeeId);
	int empInsert(EmpDto dto); 
	int empUpdate(EmpDto dto);
	int empDelete(int employeeId);
	
	List<EmpDto> empListParameterMap(Map<String, String> map);
	List<EmpDto> empListParameterMap2(@Param("firstName") String firstName, @Param("lastName") String lastName);
	List<EmpDto> empListParameterMap3(EmpDto dto);	
	
	List<EmpDto> empListLike(String firstName);

}
