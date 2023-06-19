package com.example.HomeCozaStore.service;

import com.example.HomeCozaStore.entity.CategoryEntity;
import com.example.HomeCozaStore.entity.ColorEntity;
import com.example.HomeCozaStore.entity.ProductEntity;
import com.example.HomeCozaStore.entity.SizeEntity;
import com.example.HomeCozaStore.payload.request.ProductRequest;
import com.example.HomeCozaStore.payload.response.ProductResponse;
import com.example.HomeCozaStore.repository.ProductRepository;
import com.example.HomeCozaStore.service.imp.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<ProductResponse> getProductByCategoryId(String host,int id) {
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
        try {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(productRequest.getName());
            productEntity.setDescription(productRequest.getDesc());
            productEntity.setPrice(productRequest.getPrice());
            productEntity.setQuantity(productRequest.getQuantity());

            SizeEntity sizeEntity = new SizeEntity();
            sizeEntity.setId(productRequest.getSizeId());

            ColorEntity colorEntity = new ColorEntity();
            colorEntity.setId(productRequest.getColorId());

            CategoryEntity categoryEntity = new CategoryEntity();
            categoryEntity.setId(productRequest.getCategoryId());

            productEntity.setColor(colorEntity);
            productEntity.setSize(sizeEntity);
            productEntity.setCategory(categoryEntity);

            productRepository.save(productEntity);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public ProductResponse getDetailProduct(int id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        ProductResponse productResponse = new ProductResponse();
        if (product.isPresent()){
            productResponse.setId(product.get().getId());
            productResponse.setName(product.get().getName());
            productResponse.setImageDetail(product.get().getImageDetail());
            productResponse.setPrice(product.get().getPrice());
            productResponse.setDesc(product.get().getDescription());

        }
        return productResponse;
    }
}
