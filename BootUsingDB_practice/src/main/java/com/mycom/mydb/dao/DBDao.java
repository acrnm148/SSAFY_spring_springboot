package com.mycom.mydb.dao;

import java.util.List;

import com.mycom.mydb.dto.EmpDto;

public interface DBDao {
	List<EmpDto> empList();
	EmpDto empDetail(int employeeId);
	int empInsert(EmpDto dto); 
	int empUpdate(EmpDto dto);
	int empDelete(int employeeId);
}
