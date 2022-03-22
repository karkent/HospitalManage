package com.cykj.hospitalsystem.service;



import com.cykj.hospitalsystem.bean.TbldepartmentStaff;
import com.cykj.hospitalsystem.bean.Tbldepartrment;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PersonService {
    Map<String,Object> select(HashMap<String, Object> map);

    Map<String,Object> personBan(List<Integer> list);

    Map<String,Object> personEnable(List<Integer> list);

    Map<String,Object> addPerson(Map<String, Object> map);


    Map<String,Object> UpdataPerson(Map<String, Object> map);

    Map<String,Object> allDepartment();

    Map<String,Object> getPersonDepartment(int id);

    Map<String,Object> restpwd(Map<String, Object> map);

    Map<String,Object> getAllRole();

    Map<String,Object> getAdmin(Map<String, Object> map);

    Map<String,Object> addAdmin(Map<String, Object> map);

    Map<String,Object> getHospital();

    Map<String,Object> updataAdmin(Map<String, Object> map);

    Map<String,Object> restAdmin(Map<String, Object> map);
}
