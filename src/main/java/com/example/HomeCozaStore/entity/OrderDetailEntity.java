package com.example.HomeCozaStore.entity;

import com.example.HomeCozaStore.entity.keys.OrderDetailIds;

import javax.persistence.*;

@Entity(name="order_detail")
public class OrderDetailEntity {

    @EmbeddedId
    private OrderDetailIds ids;

    @Column(name="price")
    private double price;

    @Column(name="quantity")
    private String quantity;

    @ManyToOne
    @JoinColumn(name="product_id",insertable = false,updatable = false)
    private ProductEntity product;
//    order_id int,
    @ManyToOne
    @JoinColumn(name = "order_id",insertable = false,updatable = false)
    private OrderEntity order;

    public OrderDetailIds getIds() {
        return ids;
    }

    public void setIds(OrderDetailIds ids) {
        this.ids = ids;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
