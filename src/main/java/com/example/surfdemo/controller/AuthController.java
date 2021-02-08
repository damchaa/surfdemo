package com.example.surfdemo.controller;


import com.example.surfdemo.config.jwt.JwtProvider;
import com.example.surfdemo.model.User;
import com.example.surfdemo.pojo.AuthRequest;
import com.example.surfdemo.pojo.AuthResponse;
import com.example.surfdemo.pojo.RegistrationRequest;
import com.example.surfdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;
    @PostMapping("/register")
    public String registerUser(@RequestBody @Validated RegistrationRequest registrationRequest) {
        User u = new User();
        u.setPassword(registrationRequest.getPassword());
        u.setUsername(registrationRequest.getUsername());
        userService.saveUser(u);
        return "OK";
    }
    @PostMapping("/login")
    public AuthResponse auth(@RequestBody AuthRequest authRequest){
        System.out.println(authRequest);
        User user = userService.findByUsernameAndPassword(authRequest.getUsername(),authRequest.getPassword());
        String role = userService.findByUsername(authRequest.getUsername()).getRole().getName();
        String token = jwtProvider.generateToken(user.getUsername());
        return new AuthResponse(token,role);
    }
}
