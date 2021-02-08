package com.example.surfdemo.controller;

import com.example.surfdemo.model.Expression;
import com.example.surfdemo.pojo.CalcRequest;
import com.example.surfdemo.repo.ExpressionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ExpressionController {
    @Autowired
    private ExpressionRepo expressionRepo;
    @GetMapping("/expresion")
    public List<Expression> getByExpression(){
        List<Expression> list = expressionRepo.findAll();
        return list;
    }
    @GetMapping("/date/{date}")
    public List<Expression> getByDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        List<Expression> list = expressionRepo.findExpressionsByDate(date);
        return list;
    }
}
