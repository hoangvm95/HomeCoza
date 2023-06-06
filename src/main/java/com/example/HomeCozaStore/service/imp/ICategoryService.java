package com.example.HomeCozaStore.service.imp;

import com.example.HomeCozaStore.payload.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponse> getAllCategory();
}
