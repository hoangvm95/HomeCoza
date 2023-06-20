package com.example.HomeCozaStore.controller;

import com.example.HomeCozaStore.payload.request.OrderRequest;
import com.example.HomeCozaStore.payload.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @PostMapping("")
    public ResponseEntity<?> addOrder(@RequestBody OrderRequest orderRequest){
        BaseResponse response = new BaseResponse();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
