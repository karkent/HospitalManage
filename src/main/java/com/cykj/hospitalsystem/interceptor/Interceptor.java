package com.cykj.hospitalsystem.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor implements HandlerInterceptor {
    //在方法将在处理请求之前调用
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {
        System.out.println(1);
//        Tbluser user= (Tbluser) req.getSession().getAttribute("user");
//        if(user != null){
//            return true;
//        }
        return false;
    }

    //在当前处理请求之后调用，也就是在Controller方法调用之后执行的
    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println(2);
    }

    //必须在preHandle方法返回值为true的时候才会执行
    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object o, Exception e) throws Exception {
        System.out.println(3);
    }
}
