package com.mycom.myboard.service;

import java.util.List;

import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardParamDto;
import com.mycom.myboard.dto.BoardResultDto;

public interface BoardService {
	// 총 건수를 구현하는 부분이 boardList에 포함되어 있음
	BoardResultDto boardList(BoardParamDto boardParamDto);
	BoardResultDto boardListSearchWord(BoardParamDto boardParamDto);
}
