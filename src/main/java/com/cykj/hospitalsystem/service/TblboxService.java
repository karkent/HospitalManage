package com.cykj.hospitalsystem.service;


import java.util.Map;

public interface TblboxService {
    /*显示表格*/
    Map<String, Object> showTable(Map<String, Object> map);

    /*查询状态*/
    Map<String, Object> selTbldata(Map<String, Object> map);

    /*添加*/
    Map<String, Object> addbox(Map<String, Object> map);

    /*修改状态*/
    Map setBoxState(Map<String, Object> map);

}
