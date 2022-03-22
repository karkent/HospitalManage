package com.cykj.hospitalsystem.service;


import com.cykj.hospitalsystem.bean.Routes;

import java.util.List;
import java.util.Map;

public interface RoutesService {
    Map<String,Object> getRoutes(Map<String,Object> map);
    Map<String,Object> getRoutesId(Map<String,Object> map);
    Map<String,Object> authorityMenu(Map<String,Object> map);
    /*批量修改状态*/
    Map setRoutesState(Map<String,Object> map);
    /*修改菜单内容*/
    Map setRoutesData(Map<String,Object> map);
    /*新增菜单*/
    Map<String,Object> addMenu(Map<String, Object> map);

    /*  无PDA菜单*/
    Map menuValues(Map<String,Object> map);
}
