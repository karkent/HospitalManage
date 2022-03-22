package com.cykj.hospitalsystem.aop.annotation;

import java.lang.annotation.*;

/*
用来说明该注解类的生命周期
RUNTIME：该注解在程序运行期间，此时可以通过反射获取定义在类上的所有注解
 */
@Retention(RetentionPolicy.RUNTIME)
/*
用来说明注解可以被声明在哪些元素之前
METHOD：说明该注解只能被声明在类的方法上面
 */
@Target(ElementType.METHOD)
/*
该注解说明可以被记录在javadoc中
 */
@Documented
public @interface Log {//注解方式 接口前面加@
    //功能模块
    String module() default "";
    //操作类型
    String action() default "";
    //操作详情
    String remark() default "";
}
