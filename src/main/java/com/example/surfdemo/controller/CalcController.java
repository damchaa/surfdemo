package com.example.surfdemo.controller;

import com.example.surfdemo.config.jwt.JwtFilter;
import com.example.surfdemo.config.jwt.JwtProvider;
import com.example.surfdemo.pojo.CalcRequest;
import com.example.surfdemo.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/")
public class CalcController {
    @Autowired
    private JwtFilter jwtFilter;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private CalcService calcService;

    @PostMapping("/calc")
    public void calculate(@RequestBody CalcRequest calcRequest){

        calcService.mainVoid(calcRequest.getS());
    }
}
