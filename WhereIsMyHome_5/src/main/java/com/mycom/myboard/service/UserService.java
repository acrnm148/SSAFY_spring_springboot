package com.mycom.myboard.service;

import com.mycom.myboard.dto.UserDto;
import com.mycom.myboard.dto.UserResultDto;

public interface UserService {
	UserResultDto userRegister(UserDto userDto);
}
