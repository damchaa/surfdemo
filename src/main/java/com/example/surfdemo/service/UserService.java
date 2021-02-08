package com.example.surfdemo.service;

import com.example.surfdemo.model.Role;
import com.example.surfdemo.model.User;
import com.example.surfdemo.repo.RoleRepo;
import com.example.surfdemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public User saveUser(User userEntity) {
        Role userRole = roleRepo.findByName("ROLE_USER");
        userEntity.setRole(userRole);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepo.save(userEntity);
    }
    public User findByUsername(String username){
        return userRepo.findByUsername(username);
    }
    public User findByUsernameAndPassword(String username,String password){
        User user = findByUsername(username);
        if (user != null){
            if (passwordEncoder.matches(password, user.getPassword())){
                return user;
            }
        }
        return null;
    }
}