package com.example.HomeCozaStore.service;

import com.example.HomeCozaStore.entity.SizeEntity;
import com.example.HomeCozaStore.payload.response.SizeResponse;
import com.example.HomeCozaStore.repository.SizeRepository;
import com.example.HomeCozaStore.service.imp.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SizeService implements ISizeService {
    @Autowired
    private SizeRepository sizeRepository;
    @Override
    public List<SizeResponse> getAllSize() {
        List<SizeEntity> list = sizeRepository.findAll();
        List<SizeResponse> responseList = new ArrayList<>();

        for (SizeEntity data: list) {
            SizeResponse sizeResponse = new SizeResponse();
            sizeResponse.setName(data.getName());
            sizeResponse.setId(data.getId());

            responseList.add(sizeResponse);
        }
        return responseList;
    }
}
