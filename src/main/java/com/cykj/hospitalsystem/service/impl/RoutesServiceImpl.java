package com.cykj.hospitalsystem.service.impl;

import com.cykj.hospitalsystem.bean.Routes;
import com.cykj.hospitalsystem.bean.Tbladmininfo;
import com.cykj.hospitalsystem.bean.Tblrole;
import com.cykj.hospitalsystem.bean.Tblrolepower;
import com.cykj.hospitalsystem.mapper.RolepowerMapper;
import com.cykj.hospitalsystem.mapper.RoutesMapper;
import com.cykj.hospitalsystem.mapper.TbladmininfoMapper;
import com.cykj.hospitalsystem.service.RoutesService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RoutesServiceImpl implements RoutesService {
    @Autowired
    private RoutesMapper routesMapper;
    @Autowired
    private TbladmininfoMapper tbladmininfoMapper;
    @Autowired
    private RolepowerMapper rolepowerMapper;
    @Override
    public Map getRoutes(Map map) {
        String roletype = map.get("roletype").toString().trim();
        if (roletype.equals("admin")){
            //先根据username找到对应的角色id
            map.put("ajobnum", map.get("username"));
            map.put("aphone", map.get("username"));
            Tbladmininfo admin = tbladmininfoMapper.byUserNameGetAdmin(map);
            //根据角色id返回菜单（权限）集合
            List<Tblrolepower> listrp = rolepowerMapper.byRoleidGetmenuid(admin.getRoleid() + "");
            if (listrp.size() <= 0) {
                map.put("code", 0);
                map.put("msg","你没有权限");
                return map;
            } else {
                // 获取路由信息
                List<Routes> allRoutes = routesMapper.byRolepowerGetRoutes(listrp);
                //创建一个根节点
                map.put("routeslist", diguiTree(allRoutes, 0));
            }
        }else if (roletype.equals("staff")){ // 如果是员工账号
            List<Tblrolepower> listrp = rolepowerMapper.byRoleidListGetmenuid(map.get("accid").toString().trim());
            if (listrp.size() <= 0) {
                map.put("code", 0);
                map.put("msg","你没有权限");
                return map;
            }else {
                // 获取路由信息
                List<Routes> allRoutes = routesMapper.byRolepowerGetRoutes(listrp);
                //创建一个根节点
                map.put("routeslist", diguiTree(allRoutes, 0));
            }
        }
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> getRoutesId(Map<String, Object> map) {
        List<Routes> list = routesMapper.getRoutesId(map);
        for (int i = 0; i < list.size(); i++) {
            getRoutesArray(list, list.get(i).getPid());
        }
        String RoutesStr = "";
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getRid() + "," + list.get(i).getPid());
            if(list.get(i).getRid()!=-1){
                RoutesStr+=list.get(i).getRid()+"-";
            }
        }
        String RoutesArray[] = RoutesStr.split("-");
        map.put("RoutesArray", RoutesArray);
        return KTool.codeToclient(map);
    }

    @Override
    public Map authorityMenu(Map map) {
        List<Routes> allRoutes = routesMapper.authorityMenu(map);
        List<Routes> list = diguiTree(allRoutes, 0);
        if (map.get("nowPage") == null) {
            map.put("routeslist",list);
        }else {
            int nowPage = Integer.valueOf(map.get("nowPage").toString());
            int pageSize = Integer.valueOf(map.get("pageSize").toString());
            List<Routes> listPage = new ArrayList<>();
            for (int i = nowPage; i < list.size() && i < pageSize; i++) {
                listPage.add(list.get(i));
            }
            map.put("routeslist",listPage);
            map.put("totalCum",list.size());
        }
        return KTool.codeToclient(map);
    }

    @Override
    public Map setRoutesState(Map<String, Object> map) {
        routesMapper.setRoutesState(map);
        String msg = "";
        switch (map.get("rstate").toString()){
            case "2":
                msg = "启用";
                break;
            case "3":
                msg = "禁用";
                break;
            case "4":
                msg = "作废";
                break;
        }
        map.put("msg","批量"+msg+"成功!");
        return KTool.codeToclient(map);
    }

    @Override
    public Map setRoutesData(Map<String, Object> map) {
        System.out.println("pid："+map.get("pid"));
        int i = routesMapper.updateRoutesData(map);
        if (i >= 1) {
            map.put("sign", "1");
            map.put("msg", "修改成功");
        } else {
            map.put("sign", "2");
            map.put("msg", "修改异常，请重试！");
        }
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> addMenu(Map<String, Object> map) {
        System.out.println("menuValue:----------" + map.get("pid"));
        System.out.println(map.get("pid")+"集合");

        map.put("pid",map.get("pid"));
        map.put("icon",map.get("icon"));
        map.put("rstate",2);
        map.put("label",map.get("label"));
        map.put("path",map.get("path"));
        map.put("component",map.get("component"));
        map.put("rname",map.get("rname"));

        routesMapper.addMenu(map);
        map.put("msg","增加成功");
        return KTool.codeToclient(map);
    }

    @Override
    public Map menuValues(Map<String, Object> map) {
        List<Routes> allRoutes = routesMapper.menuValues(map);
        List<Routes> list = diguiTree(allRoutes, 0);
        if (map.get("nowPage") == null) {
            map.put("menuValues",list);
        }else {
            int nowPage = Integer.valueOf(map.get("nowPage").toString());
            int pageSize = Integer.valueOf(map.get("pageSize").toString());
            List<Routes> listPage = new ArrayList<>();
            for (int i = nowPage; i < list.size() && i < pageSize; i++) {
                listPage.add(list.get(i));
            }
            map.put("menuValues",listPage);
        }
        return KTool.codeToclient(map);
    }


    public void getRoutesArray(List<Routes> list, int ParentId) {
        for (int i = 0; i < list.size(); i++) {
            int rid = list.get(i).getRid(); // 获取id
            int pid = list.get(i).getPid(); // 获取它的父级id
            if (ParentId == rid) {
                list.get(i).setRid(-1); //并将这个父级的id，设置一个标识为为-1
                getRoutesArray(list, pid); //递归继续寻找父级的父级。
            }
        }
    }

    public List<Routes> diguiTree(List<Routes> allRoutes, int parentId) {
        List<Routes> newRoutes = new ArrayList<>();
        for (int i = 0; i < allRoutes.size(); i++) {
            int pid = allRoutes.get(i).getPid(); // 获取当前 tree的父级id
            int id = allRoutes.get(i).getRid(); // 获取当前 tree的id
            if (pid == parentId) { // 判断当前这个子id属于谁
                Routes routes = allRoutes.get(i);
                routes.setChildren(diguiTree(allRoutes, id));
                newRoutes.add(routes);
            }
        }
        return newRoutes;
    }



}
