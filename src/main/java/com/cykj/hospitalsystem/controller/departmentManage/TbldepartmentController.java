package com.cykj.hospitalsystem.controller.departmentManage;

import com.cykj.hospitalsystem.bean.Tbldepartrment;
import com.cykj.hospitalsystem.service.TbldepartrmentService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/department")
public class TbldepartmentController {
    @Autowired
    private TbldepartrmentService tbldepartrmentService;

    @RequestMapping("/getdepartmentState")
    @ResponseBody //查询集合
    public Map<String, Object> getdepartmentState(@RequestBody Map<String, Object> map){
        return tbldepartrmentService.selectState(map);
    }

    @RequestMapping("/getAdd")
    @ResponseBody //增加科室
    public Map<String, Object> getAdd(@RequestBody Map<String, Object> map){
        System.out.println("getAdd"+":增加:");
        return tbldepartrmentService.addDate(map);
    }

    @RequestMapping("/UpDate")
    @ResponseBody //修改科室信息
    public Map<String, Object> UpDate(@RequestBody Map<String, Object> map){
        System.out.println("修改信息");
        return tbldepartrmentService.updDate(map);
    }

    @RequestMapping("/getKname")
    @ResponseBody //查询集合
    public Map<String, Object> getKname(@RequestBody Map<String, Object> map){
        System.out.println("getKname"+":国际查询");
        return tbldepartrmentService.selTblkname(map);
    }

    @RequestMapping("/updStateDate")
    @ResponseBody
    public Map<String, Object> updStateDate(@RequestBody Map<String, Object> map){
        System.out.println("updStateDate"+":批量修改状态");
        return tbldepartrmentService.updStateDate(map);
    }

    @RequestMapping("/upfile")
    @ResponseBody
    public Map<String,Object> upfile(@RequestParam("file") MultipartFile file) throws Exception{
        return tbldepartrmentService.upfile(file);
    }


    @RequestMapping("/checkdname")
    @ResponseBody
    public  Map<String,Object> checkdname(@RequestBody Map<String, Object> map){
        Tbldepartrment list=tbldepartrmentService.Seldistinct(String.valueOf(map.get("dname")),null);
        if(list!=null){
            map.put("sign",0);
        }else {
            map.put("sign",1);
        }
        return KTool.codeToclient(map);
    }

    @RequestMapping("/checkdcode")
    @ResponseBody
    public  Map<String,Object> checkdcode(@RequestBody Map<String, Object> map){
        Tbldepartrment list=tbldepartrmentService.Seldistinct(null,String.valueOf(map.get("dcode")));
        if(list!=null){
            map.put("sign",0);
        }else {
            map.put("sign",1);
        }
        return KTool.codeToclient(map);
    }

//    @RequestMapping("/downfile")   // io流下载文件 xls会乱码
//    @ResponseBody
//    public void downfile(HttpServletRequest req, HttpServletResponse resp) throws Exception{
//        System.out.println(1111111);
//        String path= Test.class.getResource("/").getPath();
//        path = URLDecoder.decode(path,"utf-8");
//        String fileName = "03.xls";
//        String filePath = path+"static/excel/"+fileName;
//        resp.setContentType("text/html;charset=UTF-8");
//        resp.setHeader("content-disposition","attachment;fileName="+"03.xls");
//        System.out.println(filePath);
//        InputStream is = new FileInputStream(filePath);
//        int count = 0 ;
//        byte[] by = new byte[1024];
//        OutputStream out=  resp.getOutputStream();
//        while((count=is.read(by))!=-1){
//            out.write(by, 0, count);//将缓冲区的数据输出到浏览器
//        }
//        is.close();
//        out.flush();
//        out.close();
//    }

}
