package com.cykj.hospitalsystem.controller.hospitalinfo;

import com.cykj.hospitalsystem.bean.Tbladmininfo;
import com.cykj.hospitalsystem.bean.Tblhospitalinfo;
import com.cykj.hospitalsystem.service.TbladmininfoService;
import com.cykj.hospitalsystem.service.TblhospitalinfoService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/hospital")
public class hospitalinfoController {
    @Autowired
    private TblhospitalinfoService tblhospitalinfoService;
    @Autowired
    private TbladmininfoService tbladmininfoService;

    @RequestMapping("/find")
    @ResponseBody //跳过视图
    public Map<String,Object> find(@RequestBody Map<String,Object> map){
        return tblhospitalinfoService.find(map);
    }

    @RequestMapping("/updatehospital")
    @ResponseBody //跳过视图
    public Map<String,Object> updatehospital(@RequestBody Map<String,Object> map){
        return tblhospitalinfoService.updatehospital(map);
    }

    @RequestMapping("/upstate")
    @ResponseBody
    public Map<String,Object> upstate(@RequestBody Map<String,Object> map){
        return tblhospitalinfoService.upstate(map);
    }

    @RequestMapping("/upinfo")
    @ResponseBody
    public void upinfo(HttpServletRequest request){
        System.out.println(request.getParameter("uname"));
        System.out.println(request.getParameter("phone"));
        System.out.println(request.getParameter("uemail"));
        System.out.println(request.getParameter("ucardid"));
        System.out.println(request.getParameter("uaddressid"));
        System.out.println(request.getParameter("integral"));
        System.out.println(request.getParameter("photourl"));
    }

    @RequestMapping("/addhosinfo")
    @ResponseBody
    public Map<String,Object> addhosinfoandadmin(@RequestBody Map<String,Object> map){
        tblhospitalinfoService.addhospital(map);
        String hname = map.get("hname").toString();
        String huscc = map.get("huscc").toString();
        Tblhospitalinfo tblhospitalinfo = tblhospitalinfoService.selectid(hname,huscc);
        map.put("hid",tblhospitalinfo.getHid());
        tbladmininfoService.addadmin(map);
        return KTool.codeToclient(map);
    }

    @RequestMapping("/check")
    @ResponseBody
    public Map<String,Object> check(@RequestBody Map<String,Object> map){
        Tbladmininfo tbladmininfo = tbladmininfoService.check(String.valueOf(map.get("ajobnum")),null);
        if(tbladmininfo != null){
            map.put("sign",0);
        }else {
            map.put("sign",1);
        }
        return KTool.codeToclient(map);
    }
    @RequestMapping("/check2")
    @ResponseBody
    public Map<String,Object> check2(@RequestBody Map<String,Object> map){
        Tbladmininfo tbladmininfo = tbladmininfoService.check(null,String.valueOf(map.get("aphone")));
        if(tbladmininfo != null){
            map.put("sign",0);
        }else {
            map.put("sign",1);
        }
        return KTool.codeToclient(map);
    }

    @RequestMapping("/checkhname")
    @ResponseBody
    public Map<String,Object> checkhname(@RequestBody Map<String,Object> map){
        Tblhospitalinfo tblhospitalinfo = tblhospitalinfoService.check(String.valueOf(map.get("hname")),null);
        if(tblhospitalinfo != null){
            map.put("sign",0);
        }else {
            map.put("sign",1);
        }
        return KTool.codeToclient(map);
    }
    @RequestMapping("/checkhuscc")
    @ResponseBody
    public Map<String,Object> checkhuscc(@RequestBody Map<String,Object> map){
        Tblhospitalinfo tblhospitalinfo = tblhospitalinfoService.check(null,String.valueOf(map.get("huscc")));
        if(tblhospitalinfo != null){
            map.put("sign",0);
        }else {
            map.put("sign",1);
        }
        return KTool.codeToclient(map);
    }
}
