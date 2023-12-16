import React, { useState } from 'react'
import axios from "axios"

import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import { Button } from '@mui/material';

export default function SignUp() {
    const [userEmail, setUserEmail] = useState<string>('');
    const [userPassword, setuserPassword] = useState<string>('');
    const [userPasswordCheck, setuserPasswordCheck] = useState<string>('');
    const [userNickname, setuserNickname] = useState<string>('');
    const [userPhoneNumber, setuserPhoneNumber] = useState<string>('');
    const [userAddress, setuserAddress] = useState<string>('');
    const [userAddressDetail, setuserAddressDetail] = useState<string>('');

    const signUpHandler = () => {
        const data = {
            userEmail,
            userPassword,
            userPasswordCheck,
            userNickname,
            userPhoneNumber,
            userAddress,
            userAddressDetail,
        };
        axios
        .post('http://localhost:4000/api/auth/signUp', data)
        .then((response) => {})
        .catch((error) => {})
    };

  return (
    <Card sx={{ minWidth: 275, maxWidth: "50vw" }}>
        <CardContent>
        <Box>
            <TextField fullWidth label="이메일 주소" type="email" variant="standard" onChange={(e) => setUserEmail(e.target.value)} />
            <TextField fullWidth label="비밀번호" type="password" variant="standard" onChange={(e) => setuserPassword(e.target.value)} />
            <TextField fullWidth label="비밀번호 확인" type="password" variant="standard" onChange={(e) => setuserPasswordCheck(e.target.value)} />
            <TextField fullWidth label="닉네임" variant="standard" onChange={(e) => setuserNickname(e.target.value)} />
            <TextField fullWidth label="휴대폰번호" variant="standard" onChange={(e) => setuserPhoneNumber(e.target.value)} />
            <TextField fullWidth label="주소" variant="standard" onChange={(e) => setuserAddress(e.target.value)} />
            <TextField fullWidth label="상세주소" variant="standard" onChange={(e) => setuserAddressDetail(e.target.value)} />   
        </Box>
        </CardContent>
        <CardActions>
            <Button fullWidth onClick={() => signUpHandler()} variant="contained">회원가입</Button>
        </CardActions>
    </Card>
    
  )
}
