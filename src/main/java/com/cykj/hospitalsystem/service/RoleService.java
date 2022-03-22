package com.cykj.hospitalsystem.service;

import java.util.Map;

public interface RoleService {
    Map<String,Object> findRole(Map<String,Object> map);
    Map<String,Object> EnableRole(Map<String,Object> map);
    Map<String,Object> DisableRole(Map<String,Object> map);
    Map<String,Object> deleteRole(Map<String,Object> map);
    Map<String,Object> setBatchState(Map<String,Object> map);
    Map<String,Object> updateRole(Map<String,Object> map);

    Map<String,Object> getRoleByName(Map<String,Object> map);

}
