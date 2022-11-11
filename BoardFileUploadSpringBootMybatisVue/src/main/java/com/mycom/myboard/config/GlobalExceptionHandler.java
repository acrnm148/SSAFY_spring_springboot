package com.mycom.myboard.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mycom.myboard.dto.BoardResultDto;

// 개별 컨트롤러에서 처리되지 않은 예외에 대한 글로벌한 처리
@ControllerAdvice
public class GlobalExceptionHandler {
	
	// 모든 예외를 전부 처리
	@ExceptionHandler(Exception.class)
	public ResponseEntity<BoardResultDto> handleErrorResponseEntity(Exception e) {
		e.printStackTrace();
		
		System.out.println("GlobalExceptionHandler!!");
		
		BoardResultDto boardResultDto = new BoardResultDto();
		boardResultDto.setResult(-1); // 1 성공, -1 실패
		return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
