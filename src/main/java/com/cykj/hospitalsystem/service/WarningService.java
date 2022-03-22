package com.cykj.hospitalsystem.service;


import java.util.Map;

public interface WarningService {
    Map<String,Object> warningconfig();

    Map<String,Object> departmentstaff();

    Map<String,Object> savaWarning(Map<String,Object> map);

}
