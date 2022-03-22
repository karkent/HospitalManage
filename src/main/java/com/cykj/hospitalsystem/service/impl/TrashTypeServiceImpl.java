package com.cykj.hospitalsystem.service.impl;

import com.cykj.hospitalsystem.bean.Tbltypeprint;
import com.cykj.hospitalsystem.mapper.TrashTypeMapper;
import com.cykj.hospitalsystem.service.TrashTypeService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class TrashTypeServiceImpl implements TrashTypeService {
    @Autowired
    private TrashTypeMapper trashTypeMapper;

    @Override
    public Map<String, Object> seltype(Map<String, Object> map) {
        List<Tbltypeprint> trashTypeList=trashTypeMapper.seltype(map);
        map.put("trashTypeList",trashTypeList);
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> selTrashList(Map<String, Object> map) {
        System.out.println("得到前台的数据"+map.get("tstate"));
        String dstateStr = KTool.dataid18tonull(map.get("tstate"));
        System.out.println("处理后的值"+dstateStr);
        map.put("dstateStr",dstateStr);
        map.put("tname",map.get("searchStr"));
        List<Tbltypeprint> trashList=trashTypeMapper.selTrashList(map);
        map.put("list",trashList);
        map.put("totalCum",trashTypeMapper.selTrashListCount(map));
        return KTool.codeToclient(map);
    }

    @Override
    public Map addTrash(Map<String, Object> map) {
        map.put("tstate",2);
        int i = trashTypeMapper.addTrash(map);
        if(i>=1){
            map.put("sign", "1");
            map.put("msg", "新增成功");
        } else {
            map.put("sign", "2");
            map.put("msg", "新增异常，请重试！");
        }
        return KTool.codeToclient(map);
    }

    @Override
    public Map updateTrash(Map<String, Object> map) {
        int i = trashTypeMapper.updateTrash(map);
        if (i >= 1) {
            map.put("sign", "1");
            map.put("msg", "修改成功");
        } else {
            map.put("sign", "2");
            map.put("msg", "修改异常，请重试！");
        }
        return KTool.codeToclient(map);
    }
//修改状态
    @Override
    public int updateState(int tstate, int tid) {
        return trashTypeMapper.updateState(tstate,tid);
    }

    @Override
    public Map<String, Object> setTrashstate(Map<String, Object> map) {
        trashTypeMapper.setstate(map);
        String msg = "";
        switch (map.get("tstate").toString()){
            case "2":
                msg = "启用";
                break;
            case "3":
                msg = "禁用";
                break;
            case "4":
                msg = "废除";
                break;
        }
        map.put("msg","批量"+msg+"成功!");
        return KTool.codeToclient(map);
    }

    @Override
    public Tbltypeprint findExist(String tname) {
        return trashTypeMapper.findExist(tname);
    }

}
