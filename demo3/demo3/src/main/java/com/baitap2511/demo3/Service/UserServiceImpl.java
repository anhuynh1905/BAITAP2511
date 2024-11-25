package com.baitap2511.demo3.Service;

import com.baitap2511.demo3.Repository.UserRepository;
import com.baitap2511.demo3.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Users users = userRepository.getUserByUsername(username);
        if(users == null){
            throw new UsernameNotFoundException("khong itm thay");
        }
        return new MyUserService(users);
    }
}
