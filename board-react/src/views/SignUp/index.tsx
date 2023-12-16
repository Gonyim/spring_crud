import React, { useState } from 'react'
import axios from "axios"

export default function SignUp() {
        const [requestResult, setRequestResult] = useState<string>('');

    const signUpHandler = () => {
        const data = {
            "userEmail": "slsl@gmail.com",
            "userPassword": "qwer1234!!",
            "userPasswordCheck": "qwer1234!!",
            "userNickname": "John doe",
            "userPhoneNumber": "010-1111-1111",
            "userAddress": "대한민국 서울시",
            "userAddressDetail": "강남구"
                }
        axios
        .post('http://localhost:4000/api/auth/signUp', data)
        .then((response) => {
            setRequestResult('Succes!!')
        })
        .catch((error) => {
            setRequestResult('Failed!!')
        })
    };

  return (
    <div>
        <h3>{requestResult}</h3>
        <button onClick={() => signUpHandler()}>회원가입</button>
    </div>
  )
}
