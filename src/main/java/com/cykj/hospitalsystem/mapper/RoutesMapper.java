package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.Routes;

import com.cykj.hospitalsystem.bean.Tblrolepower;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoutesMapper {
    List<Routes> authorityMenu(Map<String,Object> map);
    List<Routes> getRoutesId(Map<String,Object> map);
    List<Routes> roleGetNotInId(Map<String,Object> map);
    List<Routes> byRolepowerGetRoutes(List<Tblrolepower> list);

    /*批量修改状态*/
    int setRoutesState(@Param(value = "map") Map<String, Object> map);
    /*修改菜单数据*/
    int updateRoutesData(Map<String,Object> map);
    /*新增菜单*/
    int addMenu(Map<String, Object> map);

    List<Routes> menuValues(Map<String,Object> map);
}
