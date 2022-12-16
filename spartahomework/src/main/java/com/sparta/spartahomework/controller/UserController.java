package com.sparta.spartahomework.controller;

import com.sparta.spartahomework.dto.LoginRequestDto;
import com.sparta.spartahomework.dto.SignupRequestDto;
import com.sparta.spartahomework.dto.StatusDto;
import com.sparta.spartahomework.dto.UserResponseDto;
import com.sparta.spartahomework.entity.StatusEnum;
import com.sparta.spartahomework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<StatusDto> signup(@RequestBody SignupRequestDto signupRequestDto) {
        UserResponseDto userResponseDto = userService.signup(signupRequestDto);
        StatusDto dto = new StatusDto();

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        dto.ChangeDto(StatusEnum.OK, "회원가입 완료", userResponseDto);

        return new ResponseEntity<>(dto, header, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<StatusDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        UserResponseDto userResponseDto = userService.login(loginRequestDto, response);
        StatusDto dto = new StatusDto();

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        dto.ChangeDto(StatusEnum.OK, "로그인 완료", userResponseDto);

        return new ResponseEntity<>(dto, header, HttpStatus.OK);
    }


}
