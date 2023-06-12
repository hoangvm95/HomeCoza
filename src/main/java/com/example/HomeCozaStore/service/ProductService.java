package com.example.HomeCozaStore.service;

import com.example.HomeCozaStore.entity.ProductEntity;
import com.example.HomeCozaStore.payload.request.ProductRequest;
import com.example.HomeCozaStore.payload.response.ProductResponse;
import com.example.HomeCozaStore.repository.ProductRepository;
import com.example.HomeCozaStore.service.imp.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<ProductResponse> getProductByCategoryId(int id) {
        List<ProductEntity> list = productRepository.findByCategoryId(id);
        List<ProductResponse> productResponses = new ArrayList<>();
        for (ProductEntity data : list) {
            ProductResponse response = new ProductResponse();
            response.setName(data.getName());
            response.setPrice(data.getPrice());
            response.setImage(data.getImage());

            productResponses.add(response);
        }
        return productResponses;
    }

    @Override
    public boolean addProduct(ProductRequest productRequest) {

        return false;
    }
}
