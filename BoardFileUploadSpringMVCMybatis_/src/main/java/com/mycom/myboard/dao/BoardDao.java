package com.mycom.myboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardParamDto;

// dao layer는 Controller, Service를 바라보고 코드를 작성하지 않는다. DB 등 Persistance를 보고 작성한다.
@Mapper
public interface BoardDao {
	// limit, offset
	List<BoardDto> boardList(BoardParamDto boardParamDto);
	int boardListTotalCount();
	
	// searchWord
	List<BoardDto> boardListSearchWord(BoardParamDto boardParamDto);
	int boardListSearchWordTotalCount(String searchWord);
}
