package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.Tblrolepower;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RolepowerMapper {
    int setAuthority(@Param(value = "map") Map<String,Object> map);

    int setAuthorityNot(@Param(value = "map") Map<String,Object> map);

    int addNewData(@Param(value = "map") Map<String,Object> map);

    List<Tblrolepower> byRoleidGetmenuid(String roleid);
    // 根据员工id 获取权限关联表
    List<Tblrolepower> byRoleidListGetmenuid(String accid);

    List<Integer> getMenuIdByRoleId(Map<String,Object> map);
}
