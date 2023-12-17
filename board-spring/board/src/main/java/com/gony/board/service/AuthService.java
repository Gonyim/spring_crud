package com.gony.board.service;

import com.gony.board.dto.ResponseDto;
import com.gony.board.dto.SignInDto;
import com.gony.board.dto.SignInResponseDto;
import com.gony.board.dto.SignUpDto;
import com.gony.board.entity.UserEntity;
import com.gony.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gony.board.security.TokenProvider;

@Service
public class AuthService {

    @Autowired UserRepository userRepository;
    @Autowired TokenProvider tokenProvider;

    public ResponseDto<?> signUp(SignUpDto dto) {
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        String userPasswordCheck = dto.getUserPasswordCheck();

        // email 중복 확인
        try {
            if (userRepository.existsById(userEmail))
                return ResponseDto.setFailed("Existed Eamil!");
        } catch (Exception error) {
            return ResponseDto.setFailed("Data Base Error!");
        }
        // 비밀번호가 서로 다르면 failed response 반환
        if (!userPassword.equals(userPasswordCheck))
            return ResponseDto.setFailed("password does not matched!");

        // UserEntity 생성
        UserEntity userEntity = new UserEntity(dto);
        // UserRepository를 이용해서 데이터베이스에 Entity 저장!!

        try {
            userRepository.save(userEntity);
        } catch (Exception error) {
            return ResponseDto.setFailed("Data Base Error!");
        }
        
        // 성공 시, success response 반환
        return ResponseDto.setSuccess("SignUp Success!", null);
    }

    public ResponseDto<SignInResponseDto> signIn(SignInDto dto) {
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        try {
            boolean existed = userRepository.existsByUserEmailAndUserPassword(userEmail, userPassword);
            if (!existed) return ResponseDto.setFailed("Sign In Information does not Match!");
        } catch (Exception error) {
            return ResponseDto.setFailed("Database Error");
        }
        UserEntity userEntity = null;
        try {
            userEntity = userRepository.findById(userEmail).get();
        } catch (Exception error) {
            return ResponseDto.setFailed("Database Error");
        }

        userEntity.setUserPassword("");

        String token = tokenProvider.create(userEmail);
        int exprTime = 3600000;

        SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, userEntity);
        return ResponseDto.setSuccess("Sign In Succes!", signInResponseDto);
    }
}
