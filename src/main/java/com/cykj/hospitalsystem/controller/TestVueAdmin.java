package com.cykj.hospitalsystem.controller;

import com.cykj.hospitalsystem.service.RoutesService;
import com.cykj.hospitalsystem.service.TbladmininfoService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestVueAdmin {
    @Autowired
    private RoutesService routesServiceImpl;
    @Autowired
    private TbladmininfoService tbladmininfoServiceImpl;
    @RequestMapping("/getLogin")
    @ResponseBody
    public Map getLogin(@RequestBody Map<String,Object> map){
        return tbladmininfoServiceImpl.getLogin(map);
    }


    @RequestMapping("/getRoutes")
    @ResponseBody
    public Map getRoutes(@RequestBody Map<String,Object> map){
        System.out.println("访问 getRoutes");
        return routesServiceImpl.getRoutes(map);
    }

    @RequestMapping("/authorityMenu") // 获得所有权限的菜单（路由菜单）
    @ResponseBody
    public Map authorityMenu(@RequestBody Map<String,Object> map){
        return routesServiceImpl.authorityMenu(map);
    }


    @RequestMapping("/getInfo")
    @ResponseBody
    public Map<String,Object> getInfo(@RequestBody Map<String,Object> map){
        System.out.println("访问 info");
        System.out.println(map.get("token"));
        System.out.println(map.get("username"));

        String roles[] ={"admin"};

        map.put("roles",roles);
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return KTool.codeToclient(map);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Map<String,Object> logout(){
        System.out.println("访问logout");
        Map<String,Object> map = new HashMap<>();
        return KTool.codeToclient(map);
    }

    /*批量操作*/
    @RequestMapping("/setRoutesState")
    @ResponseBody
    public Map setRoutesState(@RequestBody Map<String, Object> map){
        return routesServiceImpl.setRoutesState(map);
    }

    /*修改菜单数据*/
    @RequestMapping("/setRoutesData")
    @ResponseBody
    public Map setRoutesData(@RequestBody Map<String, Object> map){
        return routesServiceImpl.setRoutesData(map);
    }
    /*新增菜单*/
    @RequestMapping("/addMenu")
    @ResponseBody
    public Map<String, Object> addMenu(@RequestBody Map<String, Object> map) {
        return routesServiceImpl.addMenu(map);
    }

    // 账号修改密码
    @RequestMapping("/updatePWd")
    @ResponseBody
    public Map<String,Object> updatePWd(@RequestBody Map<String,Object> map){
        return tbladmininfoServiceImpl.updatePWd(map);
    }

    // 无PDA菜单
    @RequestMapping("/menuValues")
    @ResponseBody
    public Map<String,Object> menuValues(@RequestBody Map<String,Object> map){
        return routesServiceImpl.menuValues(map);
    }
}
