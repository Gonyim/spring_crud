package com.gony.board.controller;

import com.gony.board.dto.ResponseDto;
import com.gony.board.dto.SignInDto;
import com.gony.board.dto.SignInResponseDto;
import com.gony.board.dto.SignUpDto;
import com.gony.board.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.Socket;
import java.net.SocketOption;
import java.util.SortedMap;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired AuthService authService;

    @PostMapping("/signUp")
    public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody) {
        ResponseDto<?> result = authService.signUp(requestBody);
        return result;
    }

    @PostMapping("/signIn")
    public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInDto requestBody) {
        ResponseDto<SignInResponseDto> result = authService.signIn(requestBody);
        return result;
    }
}
