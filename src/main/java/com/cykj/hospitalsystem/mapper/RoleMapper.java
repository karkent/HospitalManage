package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.Tblrole;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface RoleMapper {
    List<Tblrole> find(Map<String,Object> map);
    int totalCum(Map<String,Object> map);
    int updateRole(Map<String,Object> map);
    //查找最大的roleid
    int findMaxId();
    int addRole(Map<String,Object> map);
    //根据用户内码
    int getId(Map<String,Object> map);
    int setBatchState(@Param(value = "map") Map<String,Object> map);
    //获取所有角色
    List<Tblrole> getAllRole();
    // 获取角色下的所有员工
    List<Tblrole> RoleStaff();

    /***
     *@Description 根据roleName，获取角色
     *@Author chengfurong
     *@Date 2021/12/18 23:10
     *@Param [map]
     *@return com.cykj.hospitalsystem.bean.Tblrole
     **/
    int getRoleByName(@Param("rolename") String rolename);
}
