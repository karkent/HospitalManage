package com.cykj.hospitalsystem.controller.authority;

import com.cykj.hospitalsystem.mapper.PDAroleMapper;
import com.cykj.hospitalsystem.service.PDAmenuService;
import com.cykj.hospitalsystem.service.RoleService;
import com.cykj.hospitalsystem.service.RolepowerService;
import com.cykj.hospitalsystem.service.RoutesService;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/authority")
public class AuthorityController {
    @Autowired
    private RoleService roleServiceImpl;
    @Autowired
    private RoutesService routesServiceImpl;
    @Autowired
    private RolepowerService rolepowerServiceImpl;
    @Autowired
    private PDAmenuService pdAmenuServiceImpl;
    // 获取所有的角色信息
    @RequestMapping("/findRole")
    @ResponseBody
    public Map<String, Object> findRole(@RequestBody Map<String, Object> map) {
        return roleServiceImpl.findRole(map);
    }

    // 批量修改角色
    @RequestMapping("/updateRole")
    @ResponseBody
    public Map<String, Object> updateRole(@RequestBody Map<String, Object> map) {
        return roleServiceImpl.updateRole(map);
    }


    // 启用角色
    @RequestMapping("/EnableRole")
    @ResponseBody
    public Map<String, Object> EnableRole(@RequestBody Map<String, Object> map) {
        return roleServiceImpl.EnableRole(map);
    }

    // 禁用角色
    @RequestMapping("/DisableRole")
    @ResponseBody
    public Map<String, Object> DisableRole(@RequestBody Map<String, Object> map) {
        return roleServiceImpl.DisableRole(map);
    }

    // 废除角色
    @RequestMapping("/deleteRole")
    @ResponseBody
    public Map<String, Object> deleteRole(@RequestBody Map<String, Object> map) {
        return roleServiceImpl.deleteRole(map);
    }

    // 获得路由（菜单）的id
    @RequestMapping("/getRoutesId")
    @ResponseBody
    public Map<String, Object> getRoutesId(@RequestBody Map<String, Object> map) {
        return routesServiceImpl.getRoutesId(map);
    }

    // 选中权限tree表，分配权限
    @RequestMapping("/SelectAuthority")
    @ResponseBody
    public Map<String, Object> SelectAuthority(@RequestBody Map<String, int[]> map) {
        int roleidArray[] = map.get("roleid");
        int treeArray[] = map.get("treeArray");
        String treeStr = "";
        for (int i = 0; i < treeArray.length; i++) {
            System.out.println(treeArray[i]);
            if (treeArray[i] != 0) {
                treeStr += treeArray[i] + "-";
            }
        }
        String treeStrArray[] = treeStr.split("-");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("treeArray", treeStrArray);
        map1.put("roleid", roleidArray[0]);
        return rolepowerServiceImpl.setAuthority(map1);
    }

    // 新增角色的时候，分配权限
    @RequestMapping("/newRoleAndAuthority")
    @ResponseBody
    public Map<String, Object> newRoleAndAuthority(@RequestBody Map<String, String[]> map) {
        String treeArray[] = map.get("treeArray");
        String rolename[] = map.get("rolename");
        String rremarks[] = map.get("rremarks");
        String treeArrayPDA[] = map.get("treeArrayPDA");
        String treeStr = "";
        for (int i = 0; i < treeArray.length; i++) {
            if (!("0".equals(treeArray[i]))) {
                treeStr += treeArray[i] + "-";
            }
        }
        String treeStrArray[] = treeStr.split("-");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("treeArray", treeStrArray);
        treeStr = "";
        for (int i = 0; i < treeArrayPDA.length; i++) {
            if (!("0".equals(treeArrayPDA[i]))) {
                treeStr += treeArrayPDA[i] + "-";
            }
        }
        String treeStrArrayPDA[] = treeStr.split("-");
        map1.put("treeStrArrayPDA", treeStrArrayPDA); // pda端的数组
        map1.put("rolename", rolename[0]);
        map1.put("rremarks", rremarks[0]);
        return rolepowerServiceImpl.newRoleAndAuthority(map1);
    }

    @RequestMapping("/setBatchState")
    @ResponseBody
    public Map<String, Object> setBatchState(@RequestBody Map<String, Object> map) {
        return roleServiceImpl.setBatchState(map);
    }

    @RequestMapping("/authorityMenuPDA")
    @ResponseBody
    public Map<String,Object> authorityMenuPDA(@RequestBody Map<String,Object> map){
        // 获取 pda所有权限 除了作废的

        return pdAmenuServiceImpl.authorityMenuPDA(map);
    }


    // 选中权限tree表，分配权限
    @RequestMapping("/SelectAuthorityPDA")
    @ResponseBody
    public Map<String, Object> SelectAuthorityPDA(@RequestBody Map<String, int[]> map) {
        int roleidArray[] = map.get("roleid");
        int treeArray[] = map.get("treeArray");
        String treeStr = "";
        for (int i = 0; i < treeArray.length; i++) {
            System.out.println(treeArray[i]);
            if (treeArray[i] != 0) {
                treeStr += treeArray[i] + "-";
            }
        }
        String treeStrArray[] = treeStr.split("-");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("treeArray", treeStrArray);
        map1.put("roleid", roleidArray[0]);
        return pdAmenuServiceImpl.SelectAuthorityPDA(map1);
    }

    // 获得（菜单）的id，通过角色id
    @RequestMapping("/getPDAId")
    @ResponseBody
    public Map<String, Object> getPDAId(@RequestBody Map<String, Object> map) {
        return pdAmenuServiceImpl.getPDAId(map);
    }
    /*批量操作*/
    @RequestMapping("/setPDAmenuState")
    @ResponseBody
    public Map setPDAmenuState(@RequestBody Map<String, Object> map){
        return pdAmenuServiceImpl.setPDAmenuState(map);
    }

    /*修改菜单数据*/
    @RequestMapping("/setPDAmenuData")
    @ResponseBody
    public Map setPDAmenuData(@RequestBody Map<String, Object> map){
        return pdAmenuServiceImpl.setPDAmenuData(map);
    }
    /*新增菜单*/
    @RequestMapping("/addPDAmenu")
    @ResponseBody
    public Map<String, Object> addPDAmenu(@RequestBody Map<String, Object> map) {
        return pdAmenuServiceImpl.addPDAmenu(map);
    }

    /*根据名称，查询角色*/
    @RequestMapping("/getRoleByName")
    @ResponseBody
    public Map<String, Object> getRoleByName(@RequestBody Map<String, Object> map){

        return roleServiceImpl.getRoleByName(map);
    }

    /*根据名称，查询角色*/
    @RequestMapping("/getMenuIdByRoleId")
    @ResponseBody
    public Map<String, Object> getMenuIdByRoleId(@RequestBody Map<String, Object> map){

        return this.rolepowerServiceImpl.getMenuIdByRoleId(map);
    }
    // 批量修改角色
    @RequestMapping("/updateRoleAndAuthority")
    @ResponseBody
    public Map<String, Object> updateRoleAndAuthority(@RequestBody Map<String, Object> map) {
        return rolepowerServiceImpl.updateRoleAndAuthority(map);
    }
}
