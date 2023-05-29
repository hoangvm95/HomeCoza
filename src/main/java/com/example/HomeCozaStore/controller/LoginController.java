package com.example.HomeCozaStore.controller;

import com.example.HomeCozaStore.payload.request.SignupRequest;
import com.example.HomeCozaStore.payload.response.BaseResponse;
import com.example.HomeCozaStore.service.LoginService;
import com.example.HomeCozaStore.utils.JWTHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    JWTHelperUtils jwtHelperUtils;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username,@RequestParam String password){
//        boolean isSuccess = loginService.checkLogin(username,password);
        UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(username,password);
        authenticationManager.authenticate(user);
        String token = jwtHelperUtils.generateToken(username);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("Đăng nhập thành công");
        baseResponse.setData(token);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping("/signup")
        public ResponseEntity<?> signup(@RequestBody SignupRequest request){
        boolean isSuccess = loginService.insertUser(request);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage(isSuccess ? "Đăng ký thành công" : "Đăng ký thất bại");
        baseResponse.setData(isSuccess);
        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
        }

    @GetMapping("")
    public ResponseEntity<?> signin1(@RequestParam String username,@RequestParam String password){
        UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(username,password);
        authenticationManager.authenticate(user);
        String token = jwtHelperUtils.generateToken(username);
        return new ResponseEntity<>(token,HttpStatus.OK);
    }


}
