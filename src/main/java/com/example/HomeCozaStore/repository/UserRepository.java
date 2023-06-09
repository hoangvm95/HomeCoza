package com.example.HomeCozaStore.repository;

import com.example.HomeCozaStore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    public List<UserEntity> findByUsernameAndPassword(String username, String password);

    public UserEntity findByUsername (String username);
}
