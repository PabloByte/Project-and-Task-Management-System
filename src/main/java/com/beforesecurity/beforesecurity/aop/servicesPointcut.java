package com.beforesecurity.beforesecurity.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class servicesPointcut {

    @Pointcut("execution(* com.beforesecurity.beforesecurity.service..*(..))") 
  public void ServicesLoggersPointcut(){};

}
