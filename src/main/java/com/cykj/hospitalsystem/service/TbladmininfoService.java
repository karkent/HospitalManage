package com.cykj.hospitalsystem.service;


import com.cykj.hospitalsystem.bean.Tbladmininfo;

import java.util.Map;


public interface TbladmininfoService {
    Map addadmin(Map<String, Object> map);

    //登录
    Map getLogin(Map<String,Object> map);

    //新增的时候检查是否重复
    Tbladmininfo check(String ajobnum, String aphone);

    // 修改密码 包括人员的
    Map<String,Object> updatePWd(Map<String,Object> map);
}
