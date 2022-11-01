package com.mycom.myboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myboard.dao.BoardDao;
import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardParamDto;
import com.mycom.myboard.dto.BoardResultDto;

// Controller의 요청에 의해 필요한 파라미터는 받고, 원하는 결과 데이터를 만들어서 리턴해 준다.
// Business Logic의 핵심은 바로 Service Layer에서!!
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	private final int SUCCESS = 1;
	private final int FAIL = -11;
	
	@Override
	public BoardResultDto boardList(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		try {
			// 목록, 총 건수 가져오기
			List<BoardDto> list = boardDao.boardList(boardParamDto);
			int count = boardDao.boardListTotalCount();
			boardResultDto.setList(list);
			boardResultDto.setCount(count);
			boardResultDto.setResult(SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardListSearchWord(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			// 목록, 총 건수 가져오기
			List<BoardDto> list = boardDao.boardListSearchWord(boardParamDto);
			int count = boardDao.boardListSearchWordTotalCount(boardParamDto.getSearchWord());
			boardResultDto.setList(list);
			boardResultDto.setCount(count);
			boardResultDto.setResult(SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}


}
