package com.example.HomeCozaStore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="country")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="price_ship")
    private double priceShip;

    @OneToMany(mappedBy = "country")
    private Set<OrderEntity> listOrder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceShip() {
        return priceShip;
    }

    public void setPriceShip(double priceShip) {
        this.priceShip = priceShip;
    }

    public Set<OrderEntity> getListOrder() {
        return listOrder;
    }

    public void setListOrder(Set<OrderEntity> listOrder) {
        this.listOrder = listOrder;
    }
}
