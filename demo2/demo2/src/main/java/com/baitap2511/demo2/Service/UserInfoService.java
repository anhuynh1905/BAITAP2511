package com.baitap2511.demo2.Service;

import com.baitap2511.demo2.Entity.UserInfo;
import com.baitap2511.demo2.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.baitap2511.demo2.Config.UserInfoUserDetails;

import java.util.Optional;

public class UserInfoService implements UserDetailsService {
    @Autowired
    UserInfoRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<UserInfo> userInfo = repository.findByName(username);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found: " + username));
    }

    public UserInfoService(UserInfoRepository userInfoRepository){
        this.repository = userInfoRepository;
    }
}
