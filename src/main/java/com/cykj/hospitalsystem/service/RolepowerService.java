package com.cykj.hospitalsystem.service;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface RolepowerService {
    Map<String,Object> setAuthority(Map<String,Object> map);
    Map<String,Object> newRoleAndAuthority(Map<String,Object> map);
    Map<String, Object> getMenuIdByRoleId(Map<String, Object> map);
    Map<String, Object> updateRoleAndAuthority(Map<String, Object> map);
}
