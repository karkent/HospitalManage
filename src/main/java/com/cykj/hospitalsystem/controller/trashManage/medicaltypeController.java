package com.cykj.hospitalsystem.controller.trashManage;

import com.alibaba.fastjson.JSONObject;
import com.cykj.hospitalsystem.service.TblmedicaltypeService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/medicaltype")
public class medicaltypeController {
    @Autowired
    private TblmedicaltypeService tblmedicaltypeService;

    @RequestMapping("/find")
    @ResponseBody //跳过视图
    public Map<String,Object> find(@RequestBody Map<String,Object> map){
        return tblmedicaltypeService.find(map);
    }

    @RequestMapping("/findAll")
    @ResponseBody //查询所有数据
    public Map<String,Object> findAll(@RequestBody Map<String,Object> map){
        return tblmedicaltypeService.findAll(map);
    }

    @RequestMapping("/table")
    @ResponseBody //查询所有数据
    public Map<String,Object> table(@RequestBody Map<String,Object> map){
        return tblmedicaltypeService.table(map);
    }

    @RequestMapping("/getdepartmentlist")
    @ResponseBody //查询集合
    public Map<String, Object> getdepartmentlist(@RequestBody Map<String, Object> map){
        return tblmedicaltypeService.selTbldpartment(map);
    }

    @RequestMapping("/trashTypeList")
    @ResponseBody //医废分类集合
    public Map<String, Object> trashTypeList(@RequestBody Map<String, Object> map){
        return tblmedicaltypeService.selTbltypeprin(map);
    }

    @RequestMapping("/hospitalList")
    @ResponseBody //查询集合
    public Map<String, Object> hospitalList(@RequestBody Map<String, Object> map){
        System.out.println(""+":医院集合");
        return tblmedicaltypeService.selTblhospitalinfo(map);
    }

    @RequestMapping("/trashStateList")
    @ResponseBody //查询集合
    public Map<String, Object> trashStateList(@RequestBody Map<String, Object> map){
        System.out.println(""+":状态集合");
        return tblmedicaltypeService.selTbldata(map);
    }

    @RequestMapping("/staffList")
    @ResponseBody //查询集合
    public Map<String, Object> staffList(@RequestBody Map<String, Object> map){
        System.out.println("交接人、收集人集合");
        return tblmedicaltypeService.selTblstaff(map);
    }

    @RequestMapping("/TblboxcodeList")
    @ResponseBody //查询集合
    public Map<String, Object> selTblboxcode(@RequestBody Map<String, Object> map){
        System.out.println("周转箱编号 未使用 集合");
        return tblmedicaltypeService.selTblboxcode(map);
    }

    @RequestMapping("/TblboxcodesList")
    @ResponseBody
    public Map<String, Object> selTblboxcodes(@RequestBody Map<String, Object> map){
        System.out.println("周转箱编号 已使用 集合");
        return tblmedicaltypeService.selTblboxcodes(map);
    }

    @RequestMapping("/upBoxcode")
    @ResponseBody //修改科室信息
    public Map<String, Object> upBoxcode(@RequestBody Map<String, Object> map){
        System.out.println("修改 箱条码 袋条码");
        return tblmedicaltypeService.upBoxcode(map);
    }

    @RequestMapping("/TblsaveList")
    @ResponseBody //查询集合
    public Map<String, Object> selTblsave(@RequestBody Map<String, Object> map){
        System.out.println("暂存点集合");
        return tblmedicaltypeService.selTblsave(map);
    }


    @RequestMapping("/upTrashType")
    @ResponseBody
    public Map<String, Object> upTrashType(@RequestBody Map<String, Object> map){
        System.out.println("修改医废类型");
        return tblmedicaltypeService.upTrashType(map);
    }

    @RequestMapping("/upTrashState")
    @ResponseBody
    public Map<String, Object> upTrashState(@RequestBody Map<String, Object> map){
        System.out.println("修改医废状态");
        return tblmedicaltypeService.upTrashState(map);
    }

    @RequestMapping("/upSaveid")
    @ResponseBody
    public Map<String, Object> upSaveid(@RequestBody Map<String, Object> map){
        System.out.println("修改暂存点");
        return tblmedicaltypeService.upSaveid(map);
    }

    @RequestMapping("/HandaddDate")
    @ResponseBody
    public Map<String, Object> HandaddDate(@RequestBody Map<String, Object> map){
        System.out.println(":手工登记增加:");
        return tblmedicaltypeService.HandaddDate(map);
    }

    @RequestMapping("/FindDpartPonser")
    @ResponseBody
    public Map<String, Object> FindDpartPonser(@RequestBody Map<String, Object> map){
        System.out.println("科室中的人员:");
        return tblmedicaltypeService.DpartPonser(map);
    }

    @RequestMapping("/FindcollectList")
    @ResponseBody
    public Map<String, Object> FindcollectList(@RequestBody Map<String, Object> map){
        System.out.println("后勤保障部中的收集人员:"+ JSONObject.toJSONString(map));
        return tblmedicaltypeService.collectList(map);
    }

    @RequestMapping("/hazardousWasteTable")
    @ResponseBody
    public Map<String, Object> hazardousWasteTable(@RequestBody Map<String, Object> map){
        return tblmedicaltypeService.hazardousWasteTable(map);
    }

    @RequestMapping("/findjiao")
    @ResponseBody
    public Map<String, Object> findjiao(@RequestBody Map<String, Object> map){
        System.out.println("打印交接单:");
        return tblmedicaltypeService.findjiao(map);
    }

    @RequestMapping("/kstable")
    @ResponseBody //查询所有数据
    public Map<String,Object> kstable(@RequestBody Map<String,Object> map){
        return tblmedicaltypeService.kstable(map);
    }

}
