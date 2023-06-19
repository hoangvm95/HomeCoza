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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;
    @Value("D:/IT/Bootcamp Java 01/GitHub/HomeCoza/image")
    private String rootPath;

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetailProduct(@PathVariable int id){
        BaseResponse response = new BaseResponse();
        response.setData(iProductService.getDetailProduct(id));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("category/{id}")
    public ResponseEntity<?> getProductById (HttpServletRequest request, @PathVariable int id){

        String host = request.getHeader("host");
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iProductService.getProductByCategoryId(host,id));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addProduct(@Valid ProductRequest productRequest){

        return new ResponseEntity<>("",HttpStatus.OK);
    }
}
