package com.baitap2511.demo2.Service;

import com.baitap2511.demo2.Entity.UserInfo;
import com.baitap2511.demo2.Repository.UserInfoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.baitap2511.demo2.Config.SecurityConfig;

@Service
public record UserService(UserInfoRepository repository,
                          PasswordEncoder passwordEncoder) {
    public String addUser(UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "Add user successfully";
    }
}
