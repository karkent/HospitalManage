//package com.cykj.hospitalsystem.aop;
//
//
//import com.cykj.hospitalsystem.aop.annotation.Log;
//import com.cykj.hospitalsystem.service.LogService;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Map;
//
////定义切面
//@Aspect
//@Component     //被SpringMVC扫描
//public class SystemLogAspect {
//
//    @Autowired
//    private LogService logServiceImpl;
//    /*
//    切点
//    annotation.Log
//     */
//    @Pointcut("@annotation(com.cykj.hospitalsystem.aop.annotation.Log)")
//    public void logPointCut(){
//
//    }
//    /*
//        前置通知
//     */
//    @Before("logPointCut()")
//    public void before(JoinPoint joinPoint){
//        System.out.println("前置通知");
//    }
//    /*
//        后置通知
//     */
//    @After("logPointCut()")
//    public void after(JoinPoint joinPoint){
//        Map<String,Object> map=getLogInfo(joinPoint);
//        logServiceImpl.add(map);
//        System.out.println("后置通知");
//    }
//
//    //解析自定Log注解中的参数
//    private Map<String,Object> getLogInfo(JoinPoint joinPoint){
//        Map<String,Object> info = new HashMap<String,Object>();
//        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//        //通过反射机制拿到对象，调用方法 拿到方法里面的参数
//        Log log=method.getAnnotation(Log.class);
//        info.put("module",log.module());
//        info.put("action",log.action());
//        info.put("remark",log.remark());
//        return info;
//    }
//}
