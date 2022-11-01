package com.mycom.mydb.service;

import java.util.List;

import com.mycom.mydb.dto.EmpDto;

public interface DBService {
	List<EmpDto> empList();
	EmpDto empDetail(int employeeId);
	int empInsert(EmpDto dto); 
	int empUpdate(EmpDto dto);
	int empDelete(int employeeId);
}
