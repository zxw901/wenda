package com.nowcoder.wendaFreemarker.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.function.ObjIntConsumer;

@Aspect         //面向切面，所有业务都要处理的业务
@Component
public class LogAspect {
    private static final Logger logger= LoggerFactory.getLogger(LogAspect.class);
    @Before("execution(* com.nowcoder.wendaFreemarker.controller.*Controller.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        StringBuilder sb =new StringBuilder();
        for(Object arg:joinPoint.getArgs()){
            sb.append("arg:"+arg.toString()+"|");
        }
        logger.info("before method: "+ sb.toString());
    }
    @After("execution(* com.nowcoder.wendaFreemarker.controller.IndexController.*(..))")
    public void afterMethod(){
        logger.info("after method"+ new Date());
    }
}
