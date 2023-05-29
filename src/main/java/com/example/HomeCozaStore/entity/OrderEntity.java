package com.example.HomeCozaStore.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name="u_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="date")
    private Date date;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetailEntity> listOrderDetail;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="country_id")
    private CountryEntity country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<OrderDetailEntity> getListOrderDetail() {
        return listOrderDetail;
    }

    public void setListOrderDetail(Set<OrderDetailEntity> listOrderDetail) {
        this.listOrderDetail = listOrderDetail;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }
}
