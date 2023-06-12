package com.example.HomeCozaStore.service.imp;

import com.example.HomeCozaStore.payload.request.ProductRequest;
import com.example.HomeCozaStore.payload.response.ProductResponse;

import java.util.List;

public interface IProductService {
    List<ProductResponse> getProductByCategoryId(int id);
    boolean addProduct(ProductRequest productRequest);
}
