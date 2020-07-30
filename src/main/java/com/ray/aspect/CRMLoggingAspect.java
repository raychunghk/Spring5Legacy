package com.ray.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    //setup logger

    private static Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());

    //poincut
    @Pointcut("execution(* com.ray.controller.*.*(..))")
    public void BeforeControllerPointCut() {
    }

    @Pointcut("execution(* com.ray.service.*.*(..))")
    public void BeforeServicePointCut() {
    }

    @Pointcut("execution(* com.ray.dao.*.*(..))")
    public void BeforeDaoPointCut() {
    }

    @Pointcut("BeforeControllerPointCut() || BeforeServicePointCut()|| BeforeDaoPointCut()")
    public void forAppFlow() {

    }


    /*
       @Before("BeforeControllerPointCut()")
       public void beforeControllerAdvicer(JoinPoint jp) {

           logger.info("In @Before advicer for controller");
       }

       @Before("BeforeDaoPointCut()")
       public void BeforeDaoAdvicer(JoinPoint jp) {

           logger.info("In @Before advicer for DAO");
       }

       @Before("BeforeServicePointCut()")
       public void BeforeServiceAdvicer(JoinPoint jp) {

           logger.info("In @Before advicer for Service");
       }*/
    //before
    @Before("forAppFlow()")
    public void beforeLoggerController(JoinPoint jp) {
        String method = jp.getSignature().toShortString();
        logger.info("==>@Before Advicer here is in Method:" + method);
        Object[] args = jp.getArgs();
        Arrays.asList(args).stream().forEach(
                x -> {
                    logger.info("===> argument:" + x.toString());
                }
        );
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "rtnobj")
    public void AfterReturning(JoinPoint jp, Object rtnobj) {
        String method = jp.getSignature().toShortString();
        logger.info("==>@AfterReturning adviser here is in Method:" + method);

        logger.info("===>The returning object is :"+rtnobj.toString());
    }
    //after returning
}
