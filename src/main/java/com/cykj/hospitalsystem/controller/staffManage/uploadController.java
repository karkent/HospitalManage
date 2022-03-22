package com.cykj.hospitalsystem.controller.staffManage;


import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

@Controller
@CrossOrigin
@RestController
@RequestMapping("file")
public class uploadController {
    @Autowired
    HttpServletRequest request;

    //可上传文件类型定义
    private List fileTypes = new ArrayList() {
        {
            add("jpg");
            add("png");
        }
    };

    @RequestMapping("upload")
    public Map<String, Object> uploadFile(@RequestParam Map<String,Object> map,@RequestParam(value = "file", required = false) MultipartFile file) throws UnsupportedEncodingException {
        System.out.println(map.get("staffid"));
        if (file.isEmpty()) {
            map.put("code","0");
            map.put("msg","上传的文件为空");
        }else{
            // 获取文件全名a.py
            String fileName = file.getOriginalFilename();
            //获取文件根目录resources-部署后是target包下classes的目录
            String path= Test.class.getResource("/").getPath();
            path = URLDecoder.decode(path,"utf-8");
            System.out.println("项目路径classes"+path);
            // 文件上传路径
            String templatePath = path+"static/img";
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            //获取文件名
            String prefixName = fileName.substring(0, fileName.lastIndexOf("."));
            // 解决中文问题,liunx 下中文路径,图片显示问题
            fileName = UUID.randomUUID() + suffixName;
            //dest0代表根目录 img
            File dest0 = new File(templatePath);
            //dest 代表子目录 img下的
            String userId="00001";//暂时写静态的，这里可以获取用户id 专门存这个用户的img
            File dest = new File(dest0, userId + File.separator + fileName);
            //文件上传-覆盖
            try {
                // 检测是否存在目录
                if (!dest0.getParentFile().exists()) {
                    dest0.getParentFile().mkdirs();
                }
                //检测文件是否存在
                if (!dest.exists()) {
                    dest.mkdirs();
                }
                file.transferTo(dest);
                System.out.println("文件在项目下的地址为："+dest.getPath().substring(dest.getPath().lastIndexOf("static\\")));
                map.put("code","1");
                map.put("msg","文件上传成功");
            } catch (Exception e) {
                map.put("code","0");
                map.put("msg","文件上传失败");
            }
        }
        return map;
    }

}


