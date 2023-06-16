package com.example.HomeCozaStore.controller;

import com.example.HomeCozaStore.payload.response.BaseResponse;
import com.example.HomeCozaStore.service.imp.ISizeService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/size")
public class SizeController {
    private Logger logger = LoggerFactory.getLogger(ColorController.class);
    Gson gson = new Gson();
    @Autowired
    private ISizeService iSizeService;
    @GetMapping("")
    public ResponseEntity <?> getAllSize(){
        BaseResponse response = new BaseResponse();
        response.setData(response.getData());

        String data = gson.toJson(response);
        logger.info(data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
