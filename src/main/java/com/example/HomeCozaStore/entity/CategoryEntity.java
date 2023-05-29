package com.example.HomeCozaStore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<ProductEntity> listProduct;

    @OneToMany(mappedBy = "category")
    private Set<CategoryTagEntity> listCategoryTag;

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

    public Set<CategoryTagEntity> getListCategoryTag() {
        return listCategoryTag;
    }

    public void setListCategoryTag(Set<CategoryTagEntity> listCategoryTag) {
        this.listCategoryTag = listCategoryTag;
    }
}
