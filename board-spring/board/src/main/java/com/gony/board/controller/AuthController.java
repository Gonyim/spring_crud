package com.gony.board.controller;

import com.gony.board.dto.ResponseDto;
import com.gony.board.dto.SignUpDto;
import com.gony.board.dto.SignUpResponseDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/signUp")
    public ResponseDto<SignUpResponseDto> signUp(@RequestBody SignUpDto requestBody) {
        System.out.println(requestBody.toString());
        return null;
    }
}
