package com.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class BookAspect {
    private static int count = 1;
    @AfterReturning(pointcut = "execution(* com.codegym.controller.BookController.*(..))")
    public static void processing(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.err.println("method " + methodName + " đã chạy xong!");
        System.err.println(args);
        count++;
        System.err.println("thống kê sử dụng: " + count +" lần!");
    }
}
