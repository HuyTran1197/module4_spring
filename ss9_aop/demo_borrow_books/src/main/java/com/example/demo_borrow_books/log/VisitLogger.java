package com.example.demo_borrow_books.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VisitLogger {
    int visitTimes = 0;

    @Before("execution(* com.example.demo_borrow_books.controller.BookController.*(..))")
    public void countVisit(JoinPoint joinPoint){
        visitTimes++;
        System.out.println("----------Số lượng truy cập---------");
        System.out.println(visitTimes);
        System.out.println(joinPoint.getSignature().getName());
    }
}
