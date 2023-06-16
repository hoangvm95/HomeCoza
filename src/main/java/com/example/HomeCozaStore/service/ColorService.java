package com.example.HomeCozaStore.service;

import com.example.HomeCozaStore.entity.ColorEntity;
import com.example.HomeCozaStore.payload.response.ColorResponse;
import com.example.HomeCozaStore.repository.ColorRepository;
import com.example.HomeCozaStore.service.imp.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorService implements IColorService {
    @Autowired
    private ColorRepository colorRepository;
    @Override
    public List<ColorResponse> getAllColor() {
        List<ColorEntity> list = colorRepository.findAll();
        List<ColorResponse> responseList = new ArrayList<>();

        for (ColorEntity data:list) {
            ColorResponse colorResponse = new ColorResponse();
            colorResponse.setName(data.getName());
            colorResponse.setId(data.getId());

            responseList.add(colorResponse);
        }
        return responseList;
    }
}
