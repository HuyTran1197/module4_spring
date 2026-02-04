package com.example.demo_borrow_books.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BorrowLogger {
    @AfterThrowing(pointcut = "execution(* com.example.demo_borrow_books.service.IBorrowService.*(..))",
            throwing = "ex")
    public void logBorrowError(JoinPoint joinPoint, Exception ex) {
        System.out.println("Lỗi xảy ra: " + ex.getMessage());
        System.out.println(joinPoint.getSignature().getName());
    }
}
