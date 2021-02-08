package com.example.surfdemo.repo;

import com.example.surfdemo.model.Expression;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ExpressionRepo extends JpaRepository<Expression,Integer> {
    List<Expression> findExpressionsByDate(Date date);
    List<Expression> findExpressionsByStart(String s);
}
