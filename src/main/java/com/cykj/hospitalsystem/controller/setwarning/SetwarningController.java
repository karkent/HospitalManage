package com.cykj.hospitalsystem.controller.setwarning;

import com.cykj.hospitalsystem.bean.Tblwarning;
import com.cykj.hospitalsystem.service.WarningService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/setwarning")
public class SetwarningController {
    @Autowired
    private WarningService warningServiceImpl;


    @RequestMapping("/savaWarning")
    @ResponseBody
    public Map<String,Object> savaWarning(@RequestBody Map<String,Object> map){
        return warningServiceImpl.savaWarning(map);
    }

    @RequestMapping("/config")
    @ResponseBody
    private Map<String,Object> warningconfig(){
        return warningServiceImpl.warningconfig();
    }

    @RequestMapping("/gettest")
    @ResponseBody //查询集合
    public Map<String,Object> testdeparment(){
        return warningServiceImpl.departmentstaff();
    }
}

