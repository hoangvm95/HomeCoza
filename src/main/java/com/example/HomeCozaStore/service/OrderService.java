package com.example.HomeCozaStore.service;

import com.example.HomeCozaStore.entity.CountryEntity;
import com.example.HomeCozaStore.entity.OrderDetailEntity;
import com.example.HomeCozaStore.entity.OrderEntity;
import com.example.HomeCozaStore.entity.keys.OrderDetailIds;
import com.example.HomeCozaStore.payload.request.OrderProductRequest;
import com.example.HomeCozaStore.payload.request.OrderRequest;
import com.example.HomeCozaStore.repository.OrderDetailRepository;
import com.example.HomeCozaStore.repository.OrderRepository;
import com.example.HomeCozaStore.service.imp.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public boolean addOrder(OrderRequest orderRequest) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(orderRequest.getCountryId());


        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCountry(countryEntity);

        orderRepository.save(orderEntity);

        for (OrderProductRequest data: orderRequest.getListProduct()) {
            OrderDetailIds ids = new OrderDetailIds();
            ids.setOrderId(orderEntity.getId());
            ids.setProductId(data.getId());

            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setIds(ids);
            orderDetailEntity.setPrice(data.getPrice());
            orderDetailEntity.setQuantity(String.valueOf(data.getQuantity()));

            orderDetailRepository.save(orderDetailEntity);

        }

        return false;
    }
}
