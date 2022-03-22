package com.cykj.hospitalsystem.controller.dataManagement;

import com.cykj.hospitalsystem.bean.Tbltypeprint;
import com.cykj.hospitalsystem.service.TrashTypeService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
/*废物分类管理*/
@Controller
@RequestMapping("/trash")
public class TrashController {
    @Autowired
    private TrashTypeService trashTypeService;

    @RequestMapping("/trashList")
    @ResponseBody
    public Map trashList(@RequestBody Map<String, Object> map){
        return trashTypeService.selTrashList(map);
    }

    @RequestMapping("/addTrash")
    @ResponseBody
    public Map addtrash(@RequestBody Map<String, Object> map) {
        return trashTypeService.addTrash(map);
    }

    @RequestMapping("/updateTrash")
    @ResponseBody
    public Map updateTrash(@RequestBody Map<String, Object> map) {
        return trashTypeService.updateTrash(map);
    }

//批量操作
    @RequestMapping("/setTrashstate")
    @ResponseBody
    public Map setTrashstate(@RequestBody Map<String, Object> map){
        return trashTypeService.setTrashstate(map);
    }

    @RequestMapping("/typeList")
    @ResponseBody
    public Map seltype(@RequestBody Map<String, Object> map){
        return trashTypeService.seltype(map);
    }

    /*查已存在*/
    @RequestMapping("/findtnameExsit")
    @ResponseBody
    public Map<String, Object> findsavenameExsit(@RequestBody Map<String, Object> map){
        Tbltypeprint tbltypeprint=trashTypeService.findExist(String.valueOf(map.get("tname")));
        if (tbltypeprint != null){
            map.put("sign",0);
        }else {
            map.put("sign",1);
        }
        return KTool.codeToclient(map);
    }

}
