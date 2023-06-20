package com.example.HomeCozaStore.service.imp;

import com.example.HomeCozaStore.payload.request.OrderRequest;

public interface IOrderService {
    boolean addOrder(OrderRequest orderRequest);
}
