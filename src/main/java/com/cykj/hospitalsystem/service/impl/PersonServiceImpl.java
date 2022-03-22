package com.cykj.hospitalsystem.service.impl;



import com.cykj.hospitalsystem.bean.*;
import com.cykj.hospitalsystem.mapper.PersonMapper;
import com.cykj.hospitalsystem.service.PersonService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private   PersonMapper personMapper;
    @Override
    public Map<String, Object> select(HashMap<String,Object> map) {
        int total ;
        String info = map.get("info").toString().trim();
        System.out.println("输入的信息是"+info);
        if (map.get("state").toString().equals("4") || map.get("state").toString().equals("18")){
            map.put("state","");
        }
        // 判断是否有搜索查询
        if (info!=null && info !=""){
            //判断是纯数字
//            if (KTool.isNumeric(info)) {
//                map.put("sphone",info);
//            } else {
                // 判断是纯中文
                if (KTool.checkNameChese(info) || KTool.ispinyin(info)){
                    // 名字查询
                    map.put("sname",info);

//                    // 角色查询
//                    map.put("rolename",info);
                    // 既不是纯中文也不是纯数字 工号查询
                } else {
                    // 判断是纯字母
//                    if (KTool.ispinyin(info)) {
//                        // 拼音查询
//                        map.put("spinyin",info);
//                    } else {
                        // 工号查询 既不是纯 数字 中文 也不是 纯字母
                        map.put("sjobnum",info);
//                    }
                }
                //                    // 科室查询
                map.put("dname",info);
//            }
            total = personMapper.total(map);
        } else {
            total = personMapper.alltotal(map);
        }



        List<TblView> filterList = personMapper.select(map);
        Map<String,Object> maplist = new HashMap<>();
        maplist.put("tableData",filterList);
        maplist.put("totalCum",total);
        maplist.put("code",1);
        return maplist;
    }


    @Override
    public Map<String, Object> personBan(List<Integer> list) {
        int i = personMapper.personBan(list);
        Map<String,Object> maplist = new HashMap<>();
        if(i>1){
            maplist.put("code",1);
            return maplist;
        } else {
            maplist.put("code",2000);
            return maplist;
        }
    }


    @Override
    public Map<String, Object> personEnable(List<Integer> list) {
        int i = personMapper.personEnable(list);
        Map<String,Object> maplist = new HashMap<>();
        if(i>0){
            maplist.put("code",1);
            return maplist;
        } else {
            maplist.put("code",2000);
            return maplist;
        }
    }

    @Override
    @Transactional
    public Map<String, Object> addPerson(Map<String,Object> map) {
        Map<String,Object> maplist = new HashMap<>();
        //获取新增人员所选角色
        List<Integer> roleList = (List<Integer>) map.get("value");
        // 获取新增人员所选附属科室
        List<Integer> departmentList  = (List<Integer>) map.get("TreeSelect");
        System.out.println(departmentList);
        System.out.println("附属科室是"+departmentList);
        map.put("roleList", roleList);
        map.put("departmentList", departmentList);
        // 姓名转换生成拼音
        String pinyin = KTool.getPinyin(String.valueOf(map.get("sname")));
        map.put("pinyin",pinyin);
        // 插入人员信息
        int i =  personMapper.addPerson(map);
        System.out.println("主键是"+map.get("staffid"));
        // 插入人员角色
        i+=  personMapper.addRole(map);
        // 插入附属科室
        if (departmentList.size()>0){
            i+=  personMapper.adddepartment(map);
        }
        if (null!= map.get("staffid") && i> 0){
            maplist.put("code",1);
            return maplist;
        }else {
            maplist.put("code",2000);
            return maplist;
        }
    }

    @Override
    @Transactional
    public Map<String, Object> UpdataPerson(Map<String, Object> map) {
        Map<String,Object> maplist = new HashMap<>();
        //获取修改人员所选角色
        List<Integer> roleList = (List<Integer>) map.get("value");
        //获取修改人员所选科室
        List<Integer> departmentList  = (List<Integer>) map.get("TreeSelect");
        System.out.println("附属科室是"+departmentList);
        map.put("roleList", roleList);
        map.put("departmentList", departmentList);
        // 更改基础信息
        int i = personMapper.UpdataPerson(map);
        // 先删除原有角色
        i += personMapper.deleteRole(map);
        // 删除原有附属科室
        i += personMapper.deleteDep(map);
        // 添加角色
        i += personMapper.addRole(map);
        // 添加附属科室
        if (departmentList.size()>0){
            i += personMapper.adddepartment(map);
        }
        if (i>0){
            maplist.put("code",1);
            return maplist;
        }else {
            maplist.put("code",2000);
            return maplist;
        }
    }

    @Override
    public Map<String, Object> allDepartment() {
        Map<String,Object> maplist = new HashMap<>();
        List<Tbldepartrment> list = personMapper.allDepartment();
        System.out.println(list);
        if (list!=null){
            maplist.put("code",1);
            maplist.put("data",list);
            return maplist;
        } else {
            maplist.put("code",2000);
            return maplist;
        }
    }

    @Override
    public Map<String, Object> getPersonDepartment(int id) {
        Map<String,Object> maplist = new HashMap<>();
        List<TbldepartmentStaff> list = personMapper.getPersonDepartment(id);
        List<Integer> arrlist = new ArrayList<>();
        for (TbldepartmentStaff tbldepartmentStaff : list) {
            arrlist.add((int) tbldepartmentStaff.getDid());
        }
        System.out.println(list);
        if (list!=null && arrlist !=null){
            maplist.put("code",1);
            maplist.put("data",arrlist);
            return maplist;
        } else {
            maplist.put("code",2000);
            return maplist;
        }
    }

    @Override
    public Map<String, Object> restpwd(Map<String, Object> map) {
        Map<String,Object> maplist = new HashMap<>();
        int i = personMapper.restpwd(map);
        if (i>0){
            maplist.put("code",1);
            return maplist;
        }else {
            maplist.put("code",2000);
            return maplist;
        }

    }

    @Override
    public Map<String, Object> getAllRole() {
        Map<String,Object> maplist = new HashMap<>();
        maplist.put("roleList", personMapper.getAllRole());
        maplist.put("code",1);
        return maplist;
    }


    @Override
    public Map<String, Object> getAdmin(Map<String, Object> map) {
        int total;
        if (map.get("astate").toString().equals("4") || map.get("astate").toString().equals("18")){
            map.put("astate","");
        }
        List<Tbladmininfo> tbladmininfos = personMapper.getAdmin(map);
        System.out.println(tbladmininfos);
        total = personMapper.adminTotal(map);
        HashMap<String,Object> maplist = new HashMap<>();
        maplist.put("totalCum",total);
        maplist.put("adminList", tbladmininfos);
        maplist.put("code",1);
        return maplist;
    }


    @Override
    public Map<String, Object> addAdmin(Map<String, Object> map) {

//        int i = personMapper.addAdmin(map);
        Map<String,Object> maplist = new HashMap<>();
//        String id = (String) map.get("role");
//        System.out.println("测试的ID"+id);
        System.out.println(map);
        maplist.put("code",personMapper.addAdmin(map));
        return maplist;
    }

    @Override
    public Map<String, Object> getHospital() {
        List<Tblhospitalinfo> list = personMapper.getHospital();
        Map<String,Object> maplist = new HashMap<>();
        maplist.put("hospital", list);
        maplist.put("code",1);
        return maplist;
    }

    @Override
    public Map<String, Object> updataAdmin(Map<String, Object> map) {
        System.out.println("更改管理员！！！！！！！！！！");
        Map<String,Object> maplist = new HashMap<>();
        maplist.put("code",personMapper.updataAdmin(map));
        return maplist;
    }

    @Override
    public Map<String, Object> restAdmin(Map<String, Object> map) {
        Map<String,Object> maplist = new HashMap<>();
        maplist.put("code",personMapper.restAdmin(map));
        return maplist;
    }
}

