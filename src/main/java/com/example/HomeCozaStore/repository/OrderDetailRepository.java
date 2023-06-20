package com.example.HomeCozaStore.repository;

import com.example.HomeCozaStore.entity.OrderDetailEntity;
import com.example.HomeCozaStore.entity.keys.OrderDetailIds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailIds> {
}
