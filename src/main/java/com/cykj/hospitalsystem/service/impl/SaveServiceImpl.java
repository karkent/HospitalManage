package com.cykj.hospitalsystem.service.impl;

import com.alibaba.fastjson.JSON;
import com.cykj.hospitalsystem.bean.Tblbox;
import com.cykj.hospitalsystem.bean.Tblsave;
import com.cykj.hospitalsystem.mapper.SaveMapper;
import com.cykj.hospitalsystem.service.SaveService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class SaveServiceImpl implements SaveService {
    @Autowired
    public SaveMapper saveMapper;

    @Override
    public Map addSave(Map<String, Object> map) {
        map.put("savestate",2);
        int i = saveMapper.addSave(map);
        if (i >= 1) {
            map.put("sign", "1");
            map.put("msg", "新增成功");
        } else {
            map.put("sign", "2");
            map.put("msg", "新增异常，请重试！");
        }
        return KTool.codeToclient(map);
    }

    @Override
    public Map updateSave(Map<String, Object> map) {
        int i = saveMapper.updateSave(map);
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
    public Map selsavestate(Map<String, Object> map) {
        String saveStateValueStr = KTool.dataid18tonull(map.get("savestate"));
        map.put("saveStateValueStr",saveStateValueStr);

        String str = map.get("searchStr").toString().trim();
        if (KTool.isNumeric(str)){ // 是纯数字
            map.put("savecode",str);
        }else{ // 不是纯数字
            map.put("savename",str);
        }
        List<Tblsave> seltstateList=saveMapper.selsavestate(map);
        map.put("list",seltstateList);
        map.put("totalCum",saveMapper.countRows(map));
        return KTool.codeToclient(map);
    }

    @Override
    public Map setSaveState(Map<String, Object> map) {
        saveMapper.setstate(map);
        String msg = "";
        switch (map.get("savestate").toString()){
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
    public Tblsave findExist(String savename, String savecode) {
        return saveMapper.findExist(savename,savecode);
    }

}
