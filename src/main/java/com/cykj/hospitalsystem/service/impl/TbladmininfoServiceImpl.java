package com.cykj.hospitalsystem.service.impl;

import com.cykj.hospitalsystem.bean.Tbladmininfo;
import com.cykj.hospitalsystem.bean.Tblhospitalinfo;
import com.cykj.hospitalsystem.bean.Tblstaff;
import com.cykj.hospitalsystem.mapper.TbladmininfoMapper;
import com.cykj.hospitalsystem.service.TbladmininfoService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TbladmininfoServiceImpl implements TbladmininfoService {

    @Autowired
    private TbladmininfoMapper tbladmininfoMapper;
    @Override
    public Map<String,Object> addadmin(Map<String,Object> map) {
        int i = tbladmininfoMapper.addadmin(map);
        if(i>=1){
            map.put("code","1");
            map.put("msg","新增成功");
        }else{
            map.put("code","0");
            map.put("msg","新增异常，请重试");
        }
        return map;
    }

    @Override
    public Map getLogin(Map<String, Object> map) {
        //检查账号密码是否正确  账号名可以是工号 也可以是 手机号码
        //处理数据 适应xml sql语句
        System.out.println("getLogin方法：" + map.get("username"));
        map.put("ajobnum", map.get("username"));
//        map.put("aphone", map.get("username"));
        Tbladmininfo admin = tbladmininfoMapper.getLoginCheck(map);
        //创建一个新的map 只传输 token 和 账号名
        Map<String, Object> tokenMap = new HashMap<>();
        if (admin != null) { // 账号密码正确
            map.put("hid", admin.getHid());
            if (!loginCheckHospital(map)) {
                tokenMap.put("code", 0);
                tokenMap.put("msg", "医院未启用，或授权的日期到期！");
            } else {
                KTool.codeToclient(tokenMap);
                tokenMap.put("token", "admin-token");
                tokenMap.put("username", map.get("username"));
                tokenMap.put("roletype", "admin");
                tokenMap.put("accid", admin.getAdminid());
                tokenMap.put("hospitalid", admin.getHid());
                tokenMap.put("name", admin.getAname());
                tokenMap.put("hospitalName",tbladmininfoMapper.getHname(map));
            }
        } else {
            // 如果不是管理员 tbladmininfo 表
            // 判断是不是员工账号
            Tblstaff tblstaff = tbladmininfoMapper.loginStaff(map);
            if (tblstaff != null) { // 账号或密码正确
                map.put("hid", tblstaff.getHid());
                if (!loginCheckHospital(map)) {
                    tokenMap.put("code", 0);
                    tokenMap.put("msg", "医院未启用，或授权的日期到期！");
                } else {
                    KTool.codeToclient(tokenMap);
                    tokenMap.put("token", "admin-token");
                    tokenMap.put("username", map.get("username"));
                    tokenMap.put("roletype", "staff");
                    tokenMap.put("accid", tblstaff.getStaffid());
                    tokenMap.put("hospitalid", tblstaff.getHid());
                    tokenMap.put("name", tblstaff.getSname());
                    tokenMap.put("hospitalName",tbladmininfoMapper.getHname(map));
                }
            } else {
                tokenMap.put("code", 0);
                tokenMap.put("msg", "账号或密码不正确");
            }
        }
        return tokenMap;
    }

    @Override
    public Tbladmininfo check(String ajobnum, String aphone) {
        return tbladmininfoMapper.check(ajobnum,aphone);
    }

    @Override
    public Map<String, Object> updatePWd(Map<String, Object> map) {
        Map<String, Object> map1 = new HashMap<>();
        if (map.get("roletype").toString().equals("admin")) {
            Tbladmininfo admin = tbladmininfoMapper.getLoginCheck(map);
            if (admin != null) {
                tbladmininfoMapper.updatePWd(map);
                map1.put("msg", "密码修改成功");
                map1.put("sign", 1);
            }else {
                map1.put("msg", "修改异常，请重试");
                map1.put("sign", 0);
            }
        }else if (map.get("roletype").toString().equals("staff")){
            map.put("staffid",map.get("adminid"));
            Tblstaff staff = tbladmininfoMapper.loginStaff(map);
            if (staff != null) {
                tbladmininfoMapper.updatePWdstaff(map);
                map1.put("msg", "密码修改成功");
                map1.put("sign", 1);
            }else {
                map1.put("msg", "修改异常，请重试");
                map1.put("sign", 0);
            }
        }else {
            map1.put("msg", "请输入正确的旧密码");
            map1.put("sign", 0);
        }
        return KTool.codeToclient(map1);
    }


    public boolean loginCheckHospital(Map<String,Object> map){
        Date date = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowdate = sdf.format(date);
        map.put("nowDate",nowdate);
        Tblhospitalinfo tblhospitalinfo = tbladmininfoMapper.loginCheckHospital(map);
        if (tblhospitalinfo==null){
            // 医院未启用，或者授权时间到期
            return false;
        }else {
            return true;
        }
    }
}
