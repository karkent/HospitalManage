package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.Tbladmininfo;
import com.cykj.hospitalsystem.bean.Tblhospitalinfo;
import com.cykj.hospitalsystem.bean.Tblstaff;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface TbladmininfoMapper {
    int addadmin(Map<String, Object> map);
    //新增的管理员 登录方法
    Tbladmininfo getLoginCheck(Map<String,Object> map);
    //新增的通过用户名获取角色id
    Tbladmininfo byUserNameGetAdmin(Map map);
    //自强
    Tbladmininfo check(@Param(value = "ajobnum") String ajobnum,
                       @Param(value = "aphone") String aphone);
    // 员工的 登录方法
    Tblstaff loginStaff(Map<String,Object> map);

    // 登录前判断 医院是否过期和启用
    Tblhospitalinfo loginCheckHospital(Map<String,Object> map);

    // 修改管理员的密码
    int updatePWd(Map<String,Object> map);

    // 修改员工的密码
    int updatePWdstaff(Map<String,Object> map);

    String getHname(Map<String,Object> map);
}
