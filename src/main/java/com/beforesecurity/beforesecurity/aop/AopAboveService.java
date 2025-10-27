package com.beforesecurity.beforesecurity.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopAboveService {

  private static final Logger logger = LoggerFactory.getLogger(AopAboveService.class);

  @Around("servicesPointcut.ServicesLoggersPointcut()")
  public Object serviceAspect (ProceedingJoinPoint joinPoint) throws Throwable{

    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());

    Long initialtime = System.currentTimeMillis();

    Object result ;

    try {

      result = joinPoint.proceed();
      Long finalTime = System.currentTimeMillis();
      Long totalTime = finalTime - initialtime ;


       logger.info("Method name :{}, Args :{} , executiontime :{} ,information returned : \"{}\"", method,args,totalTime, result);
      return  result;
    } catch (Throwable e) {

     logger.error("ERROR REAL capturado en aspecto:", e); // <- imprime stacktrace real
    throw e; // ! 
     
    }

  }

}
