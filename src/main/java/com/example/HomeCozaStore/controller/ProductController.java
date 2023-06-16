package com.example.HomeCozaStore.controller;

import com.example.HomeCozaStore.payload.request.ProductRequest;
import com.example.HomeCozaStore.payload.response.BaseResponse;
import com.example.HomeCozaStore.service.imp.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;
    @Value("D:/IT/Bootcamp Java 01/GitHub/HomeCoza/image")
    private String rootPath;

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById (@PathVariable int id){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iProductService.getProductByCategoryId(id));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addProduct(@Valid ProductRequest productRequest){

        return new ResponseEntity<>("",HttpStatus.OK);
    }
}
