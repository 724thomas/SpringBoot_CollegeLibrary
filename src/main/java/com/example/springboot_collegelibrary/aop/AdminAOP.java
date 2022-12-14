package com.example.springboot_collegelibrary.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

import static jdk.nashorn.internal.objects.Global.print;

@Component
@Aspect
public class AdminAOP {

    @Pointcut("execution(* com.example.springboot_collegelibrary.controller..*.*(..))")
    public void PageControlEmailCheck(){}

    @Around("PageControlEmailCheck() && !@annotation(com.example.springboot_collegelibrary.aop.SkipLoginCheck)")
    public Object PageControlEmailCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpSession session=((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        if (session.getAttribute("email")==null){
            return "redirect:/";
        }else{
            return joinPoint.proceed();
        }
    }

    @Pointcut("execution(* com.example.springboot_collegelibrary..*.*(..))")
    public void MethodRunCheck(){}

    @Around("MethodRunCheck()")
    public Object MethodRunCheck(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println(joinPoint.getSignature().toString().replace("com.example.springboot_collegelibrary.","") + " : Run Success");
        return joinPoint.proceed();
    }

    @AfterReturning(value = "execution(* com.example.springboot_collegelibrary.controller..*(..))", returning = "returnValue")
    public void writeSuccessLog(JoinPoint joinPoint, Object returnValue) throws RuntimeException {
        System.out.println("Returning to : " + returnValue);
        System.out.println("--------------------------------------------------");
    }
}

