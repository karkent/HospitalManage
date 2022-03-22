package com.cykj.hospitalsystem.service;

import com.cykj.hospitalsystem.bean.Tblsave;

import java.util.Map;

public interface SaveService {
    //新增
    Map addSave(Map<String, Object> map);

    //修改
    Map updateSave(Map<String, Object> map);

    //查状态
    Map selsavestate(Map<String, Object> map);

//    Map start(Map<String, Object> map);
//    Map stop(Map<String, Object> map);
//    Map disable(Map<String, Object> map);
/*批量修改状态*/
    Map setSaveState(Map<String, Object> map);

    Tblsave findExist(String savename, String savecode);

}
