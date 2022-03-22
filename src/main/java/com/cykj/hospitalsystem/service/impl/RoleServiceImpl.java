package com.cykj.hospitalsystem.service.impl;

import com.cykj.hospitalsystem.bean.Tblrole;
import com.cykj.hospitalsystem.mapper.RoleMapper;
import com.cykj.hospitalsystem.service.RoleService;
import com.cykj.hospitalsystem.until.KTool;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Map<String, Object> findRole(Map<String, Object> map) {
        if (map.get("type") != null) { //专门设置一个入口给 下拉列表需要 返回的角色集合
            if (map.get("type").toString().equals("getAllrole")) {
                map.put("roleList", roleMapper.getAllRole());
            }
        } else {
            // 进行数据的处理
            String stateStr = KTool.dataid18tonull(map.get("rolestate"));
            map.put("rolestateStr", stateStr);
            String str = map.get("searchStr").toString().trim();
            if (KTool.isNumeric(str)) { // 是纯数字
                map.put("rolecode", str);
            } else { // 不是纯数字
                map.put("rolename", str);
                map.put("rremarks", str);
            }
            map.put("roleList", roleMapper.find(map));
            map.put("totalCum", roleMapper.totalCum(map));
        }
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> EnableRole(Map<String, Object> map) {
        map.put("rolestate", 2);
        int i = roleMapper.updateRole(map);
        if (i >= 1) {
            map.put("code", 1);
            map.put("msg", "启用成功");
        } else {
            map.put("code", 0);
            map.put("msg", "启用异常，请重试");
        }
        return map;
    }

    @Override
    public Map<String, Object> DisableRole(Map<String, Object> map) {
        map.put("rolestate", 3);
        int i = roleMapper.updateRole(map);
        if (i >= 1) {
            map.put("code", 1);
            map.put("msg", "禁用成功");
        } else {
            map.put("code", 0);
            map.put("msg", "禁用异常，请重试");
        }
        return map;
    }

    @Override
    public Map<String, Object> deleteRole(Map<String, Object> map) {
        map.put("rolestate", 4);
        int i = roleMapper.updateRole(map);
        if (i >= 1) {
            map.put("code", 1);
            map.put("msg", "作废成功");
        } else {
            map.put("code", 0);
            map.put("msg", "作废异常，请重试");
        }
        return map;
    }

    @Override
    public Map<String, Object> setBatchState(Map<String, Object> map) {
        int i = roleMapper.setBatchState(map);
        String msg = "";
        switch (map.get("rolestate").toString()) {
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
        if (i >= 1) {
            map.put("code", 1);
            map.put("msg", "批量" + msg + "成功!");
        } else {
            map.put("code", 0);
            map.put("msg", "批量" + msg + "异常，请重试");
        }
        return map;
    }

    @Override
    public Map<String, Object> updateRole(Map<String, Object> map) {
        int i = roleMapper.updateRole(map);
        if (i >= 1) {
            map.put("code", 1);
            map.put("msg", "修改角色成功!");
        } else {
            map.put("code", 0);
            map.put("msg", "修改角色异常!请重试");
        }
        return map;
    }

    @Override
    public Map<String, Object> getRoleByName(Map<String, Object> map) {
        String rolename = (String) map.get("rolename");
        int count = roleMapper.getRoleByName(rolename);
        if(count>0){
            map.put("code", 1);
            map.put("msg", "已经存在!");
        }else{
            map.put("code", 1);
            map.put("msg", "不存在!");
        }
        return map;
    }


}
