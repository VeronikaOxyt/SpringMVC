package com.oxytoca.mvc.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Around("execution(* com.oxytoca.mvc.management.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        MethodSignature methodSignature =
                (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println(methodName + " started work");
        Object targetMethodResult = joinPoint.proceed();
        System.out.println(methodName + " finished work");
        return targetMethodResult;
    }
}
