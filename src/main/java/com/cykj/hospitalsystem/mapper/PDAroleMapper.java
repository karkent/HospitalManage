package com.cykj.hospitalsystem.mapper;

import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PDAroleMapper {
    // 插入选中的权限
    int addNewData(@Param(value = "map") Map<String,Object> map);
    // 清空这个角色权限-- 之后的操作就是插入选中的权限
    int delAllbyRoleid(Map<String,Object> map);

    List<Integer> getPdaMenuIdByRoleId(Map<String,Object> map);
}
