package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.UserLoginResponseDto;
import com.jojoldu.book.springboot.web.dto.UserLoginRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        String userId = userLoginRequestDto.getUserId();
        String password = userLoginRequestDto.getPassword();
        return new UserLoginResponseDto("200");
    }
}
