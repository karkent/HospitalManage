package com.cykj.hospitalsystem.controller.staffManage;

import com.cykj.hospitalsystem.service.PersonService;
import com.cykj.hospitalsystem.service.TblmedicaltypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personServiceImpl;
    @Autowired
    private TblmedicaltypeService tblmedicaltypeServiceImpl;

    // 获取人员列表数据
    @RequestMapping("/getPersonTbl")
    @ResponseBody
    public Map<String,Object> getPerson(@RequestBody HashMap<String,Object> map){
        System.out.println("访问 getPerson");
        Map<String,Object> maplist = personServiceImpl.select(map);
        return maplist;
    }

    // 人员禁用
    @RequestMapping("/personBan")
    @ResponseBody
    public Map<String,Object> personBan(@RequestBody Map<String,Object> map){
        List banlist;
        banlist = (List) map.get("pidarr");
        System.out.println(banlist);
        System.out.println("访问 personBan");
        return personServiceImpl.personBan(banlist);
    }
    // 人员启用
    @RequestMapping("/personEnable")
    @ResponseBody
    public Map<String,Object> personEnable(@RequestBody Map<String,Object> map){
        List enabelist ;
        System.out.println("访问 personEnable");
        enabelist = (List) map.get("pidarr");
        return personServiceImpl.personEnable(enabelist);
    }
    // 添加人员
    @RequestMapping("/AddPerson")
    @ResponseBody
    public Map<String,Object> addPerson(@RequestBody HashMap<String, Object> map){
        System.out.println("访问 AddPerson");
        return  personServiceImpl.addPerson(map);
    }

    // 修改人员
    @RequestMapping("/UpdataPerson")
    @ResponseBody
    public Map<String,Object> updataPerson(@RequestBody HashMap<String, Object> map){
        System.out.println("访问 UpdataPerson");
        return personServiceImpl.UpdataPerson(map);
    }

    // 获取科室
    @RequestMapping("/getDepartment")
    @ResponseBody
    public Map<String,Object> getDepartment(){
        System.out.println("访问getDepartment");
        return personServiceImpl.allDepartment();
    }

    // 获取所选人员科室
    @RequestMapping("/getPersonDepartment")
    @ResponseBody
    public Map<String,Object> getPersonDepartment(@RequestBody HashMap<String, Object> map){
        int id = Integer.parseInt(String.valueOf(map.get("id")));
        System.out.println("访问getPersonDepartment");
        return  personServiceImpl.getPersonDepartment(id);
    }

    //重置密码
    @RequestMapping("/restpwd")
    @ResponseBody
    public Map<String,Object> restpwd(@RequestBody HashMap<String, Object> map){
        System.out.println("restpwd");
        int id = Integer.parseInt(String.valueOf(map.get("pid")));
        return personServiceImpl.restpwd(map);
    }

    // 获取所有的角色信息
    @RequestMapping("/findRole")
    @ResponseBody
    public Map<String, Object> findRole() {
        return personServiceImpl.getAllRole();
    }

    // 获取管理员角色信息
    @RequestMapping("/getadmin")
    @ResponseBody
    public Map<String, Object> getadmin(@RequestBody HashMap<String, Object> map) {
        return personServiceImpl.getAdmin(map);
    }


    // 添加管理员角色信息
    @RequestMapping("/addAdmin")
    @ResponseBody
    public Map<String, Object> addAdmin(@RequestBody HashMap<String, Object> map) {
        return personServiceImpl.addAdmin(map);
    }

    // 获取医院信息
    @RequestMapping("/getHospital")
    @ResponseBody
    public Map<String, Object> getHospital() {
        return personServiceImpl.getHospital();
    }



    // 修改管理员信息
    @RequestMapping("/updataAdmin")
    @ResponseBody
    public Map<String, Object> updataAdmin(@RequestBody HashMap<String, Object> map) {
        return personServiceImpl.updataAdmin(map);
    }

    // 修改管理员信息
    @RequestMapping("/restAdmin")
    @ResponseBody
    public Map<String, Object> restAdmin(@RequestBody HashMap<String, Object> map) {
        return personServiceImpl.restAdmin(map);
    }
}
