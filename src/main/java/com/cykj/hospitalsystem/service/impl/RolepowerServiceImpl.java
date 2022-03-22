package com.cykj.hospitalsystem.service.impl;

import com.cykj.hospitalsystem.bean.Routes;
import com.cykj.hospitalsystem.bean.TblPdAmenu;
import com.cykj.hospitalsystem.mapper.*;
import com.cykj.hospitalsystem.service.RolepowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RolepowerServiceImpl implements RolepowerService {
    @Autowired
    private RolepowerMapper rolepowerMapper;
    @Autowired
    private RoutesMapper routesMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PDAmenuMapper pdAmenuMapper;
    @Autowired
    private PDAroleMapper pdAroleMapper;
    @Override
    public Map<String, Object> setAuthority(Map<String, Object> map) {
        //分配之前，先查询最新的路由表，如果路由表更新了最新的路由信息，则返回最新的路由id的list。
        List<Routes> list = routesMapper.roleGetNotInId(map); // 根据角色id
        if(list.size()>0){ // 当返回的结果集大于0时 则执行插入
            map.put("RoutesList",list);
            rolepowerMapper.addNewData(map);
        }
        int i = rolepowerMapper.setAuthority(map);
        int j = rolepowerMapper.setAuthorityNot(map);
        if(i>=1 || j>=1){
            map.put("code",1);
            map.put("msg","分配成功");
        }else {
            map.put("code",0);
            map.put("msg","分配异常，请重试");
        }
        return map;
    }

    @Override
    public Map<String, Object> newRoleAndAuthority(Map<String, Object> map) {
        // 系统生成 管理员内码 （编号）
        Date date = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nowDayStr = sdf.format(date);
        System.out.println(nowDayStr);
        //找到 role表中最大的roleid
        int roleMaxId = roleMapper.findMaxId(); // 用于生成 管理员内码
        map.put("rolecode",nowDayStr+(roleMaxId+""));
        int i = roleMapper.addRole(map); // 新增角色。
        map.put("roleid",roleMapper.getId(map));//根据角色rolecode，返回id
        //返回最新的路由（菜单权限表） 根据角色id
        List<Routes> list = routesMapper.roleGetNotInId(map);
        map.put("RoutesList",list);
        rolepowerMapper.addNewData(map); // 根据角色id 插入 角色权限关联表的数据
        int j = rolepowerMapper.setAuthority(map);
        int k = rolepowerMapper.setAuthorityNot(map);

        // pda权限的插入
        Map<String,Object> pdaMap = new HashMap<>();
        pdaMap.put("treeArray",map.get("treeStrArrayPDA"));
        pdaMap.put("roleid",map.get("roleid"));
        List<TblPdAmenu> PDAlist = pdAmenuMapper.getPDAidByArrayId(pdaMap);
        if(PDAlist.size()>0){
            pdaMap.put("PDAList",PDAlist);
            pdAroleMapper.addNewData(pdaMap);
        }
        if(i>=1 || j>=1 || k>=1){
            map.put("code",1);
            map.put("msg","新增角色成功");
        }else {
            map.put("code",0);
            map.put("msg","新增角色异常，请重试");
        }
        return map;
    }

    @Override
    public Map<String, Object> getMenuIdByRoleId(Map<String, Object> map){
        List<Integer> menuIds = this.rolepowerMapper.getMenuIdByRoleId(map);
        List<Integer> pdaMenuIds = this.pdAroleMapper.getPdaMenuIdByRoleId(map);

        map.put("menuList",menuIds);
        map.put("pdaMenuList",pdaMenuIds);
        map.put("code",1);
        return map;

    }

    @Override
    public Map<String, Object> updateRoleAndAuthority(Map<String, Object> map) {
        // 修改角色表
        int i = roleMapper.updateRole(map);
        // 将选中的权限state设置为1
        int j = rolepowerMapper.setAuthority(map);
        // 将未选中的权限state设置为0
        int k = rolepowerMapper.setAuthorityNot(map);
        // 先删除pda的权限
        int re = this.pdAroleMapper.delAllbyRoleid(map);
        // 再插入pda的权限
        Map<String,Object> pdaMap = new HashMap<>();
        pdaMap.put("treeArray",map.get("treeArrayPDA"));
        pdaMap.put("roleid",map.get("roleid"));
        List<TblPdAmenu> PDAlist = null;
        try {
            PDAlist = pdAmenuMapper.getPDAidByArrayId(pdaMap);
        }catch (Exception e){

            System.out.println(e+"!!"+pdaMap!=null);
        }
        if(PDAlist!=null && PDAlist.size()>0){
            pdaMap.put("PDAList",PDAlist);
            pdAroleMapper.addNewData(pdaMap);
        }
        if (i >= 1) {
            map.put("code", 1);
            map.put("msg", "修改角色成功!");
        } else {
            map.put("code", 0);
            map.put("msg", "修改角色异常!请重试");
        }
        return map;
    }
}
