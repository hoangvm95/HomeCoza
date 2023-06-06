package com.example.HomeCozaStore.service;

import com.example.HomeCozaStore.payload.response.CategoryResponse;
import com.example.HomeCozaStore.service.imp.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Override
    public List<CategoryResponse> getAllCategory() {
        return null;
    }
}
