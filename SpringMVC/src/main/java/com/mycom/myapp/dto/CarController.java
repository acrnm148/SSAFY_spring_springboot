package com.mycom.myapp.dto;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CarController {

	@PostMapping(value="/car")
	public void getData(@RequestBody CarDto dto) {
		System.out.println(dto);
		System.out.println("FE=>BE 받기 완료");
	}
	
	@PostMapping(value="/carList")
	public void getDataList(@RequestBody List<CarDto> dtoList) {
		System.out.println(dtoList);
		System.out.println("FE=>BE list 받기 완료");
	}
}
