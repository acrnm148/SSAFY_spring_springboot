package com.mycom.mybatis.service;

import java.util.List;
import java.util.Map;

import com.mycom.mybatis.dto.EmpDto;

public interface MybatisService {
	List<EmpDto> empList();
	EmpDto empDetail(int employeeId);
	int empInsert(EmpDto dto); 
	int empUpdate(EmpDto dto);
	int empDelete(int employeeId);
	
	List<EmpDto> empListParameterMap(Map<String, String> map);
	List<EmpDto> empListParameterMap2(String firstName, String lastName);
	List<EmpDto> empListParameterMap3(EmpDto dto);

	List<EmpDto> empListLike(String firstName);
}
