package com.mycom.myboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myboard.dto.BoardParamDto;
import com.mycom.myboard.dto.BoardResultDto;
import com.mycom.myboard.service.BoardService;

// Client의 요청에 대해 파라미터 처리를 담당하고 그것을 처리할 적정한 service layer의 모듈을 찾아가서 호츌하고 결과를 Client에 보내준다.
@RestController
public class BoardController {
	
	@Autowired
	BoardService service;
	
	private final int SUCCESS = 1;
	
	@GetMapping(value="/boards")
	private ResponseEntity<BoardResultDto> boardList(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto;

		// service 호출할 때, searchWord 유무에 따라 분리해서 처리
		if (boardParamDto.getSearchWord() == null || boardParamDto.getSearchWord().isEmpty()) {
			boardResultDto = service.boardList(boardParamDto);
		} else {
			boardResultDto = service.boardListSearchWord(boardParamDto);
		}
		
		if (boardResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
