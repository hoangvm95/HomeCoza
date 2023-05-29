package com.example.HomeCozaStore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="color")
public class ColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "color")
    private Set<ProductEntity> listProduct;

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

    public Set<ProductEntity> getListProduct() {
        return listProduct;
    }

    public void setListProduct(Set<ProductEntity> listProduct) {
        this.listProduct = listProduct;
    }
}
