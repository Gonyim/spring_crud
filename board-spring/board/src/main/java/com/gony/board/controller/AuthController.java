package com.gony.board.controller;

import com.gony.board.dto.ResponseDto;
import com.gony.board.dto.SignUpDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/signUp")
    public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody) {
        return null;
    }
}
