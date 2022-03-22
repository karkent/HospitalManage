package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface PersonMapper {

    List<TblView> select(HashMap<String, Object> map);
    // 表格分类获取总数获取
    int total(HashMap<String, Object> map);
    // 表格总数获取
    int alltotal(HashMap<String, Object> map);
    // 人员禁用
    int personBan(List<Integer> list);

    // 人员启用
    int personEnable(List<Integer> list);
    // 添加人员
    int addPerson(Map<String, Object> map);
    // 添加人员时添加角色
    int addRole(Map<String, Object> map);
    // 添加人员时添加附属科室
    int adddepartment(Map<String, Object> map);

    // 获取科室列表
    List<Tbldepartrment> allDepartment();

    // 获取角色科室列表
    List<TbldepartmentStaff> getPersonDepartment(@Param("id") int id);

    // 重置密码
    int restpwd(Map<String, Object> map);

    // 修改人员
    int UpdataPerson(Map<String, Object> map);
    // 修改信息删除原有角色
    int deleteRole(Map<String, Object> map);
    // 修改信息删除原有附属科室
    int deleteDep(Map<String, Object> map);
    // 获取所有启用角色
    List<Tblrole> getAllRole();

    // 获取管理员信息
    List<Tbladmininfo> getAdmin(Map<String, Object> map);

    // 获取医院信息
    List<Tblhospitalinfo> getHospital();
    // 添加医院管理员
    int addAdmin(Map<String, Object> map);

    // 修改管理员
    int updataAdmin(Map<String, Object> map);

    // 管理员计数
    int adminTotal(Map<String, Object> map);

    // 管理员修改密码
    int restAdmin(Map<String, Object> map);
}
