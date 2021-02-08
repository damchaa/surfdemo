package com.example.surfdemo.service;

import com.example.surfdemo.model.Expression;
import com.example.surfdemo.model.User;
import com.example.surfdemo.repo.ExpressionRepo;
import com.example.surfdemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Service
public class CalcService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ExpressionRepo expressionRepo;
    public void mainVoid(String s){
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        try {
            engine.eval("var result = "+s +";");
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        String result = engine.get("result").toString();

        Expression expression = new Expression(s,result);
        expressionRepo.save(expression);

    }
}
