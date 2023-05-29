package com.example.HomeCozaStore.service;

import com.example.HomeCozaStore.entity.UserEntity;
import com.example.HomeCozaStore.payload.request.SignupRequest;
import com.example.HomeCozaStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    UserRepository userRepository;
    public boolean checkLogin(String username,String password){
        List<UserEntity> list = userRepository.findByUsernameAndPassword(username,password);
        return list.size()>0;
    }

    public boolean insertUser(SignupRequest request){
        try {
            UserEntity user = new UserEntity();
            user.setUsername(request.getUsername());
            user.setPassword(request.getPassword());
            user.setEmail(request.getEmail());

            userRepository.save(user);
            return true;

        }catch (Exception e){

            return false;
        }
    }
}

