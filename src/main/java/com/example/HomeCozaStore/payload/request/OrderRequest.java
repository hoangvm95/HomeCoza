package com.example.HomeCozaStore.payload.request;

import java.util.List;

public class OrderRequest {
    private int countryId;
    private List<OrderProductRequest> orderProductRequests;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public List<OrderProductRequest> getOrderProductRequests() {
        return orderProductRequests;
    }

    public void setOrderProductRequests(List<OrderProductRequest> orderProductRequests) {
        this.orderProductRequests = orderProductRequests;
    }
}
