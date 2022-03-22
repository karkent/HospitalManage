package com.cykj.hospitalsystem.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.hospitalsystem.bean.Tbldepartrment;
import com.cykj.hospitalsystem.bean.Tblkname;
import com.cykj.hospitalsystem.bean.Tblrole;
import com.cykj.hospitalsystem.bean.Tblstaff;
import com.cykj.hospitalsystem.mapper.RoleMapper;
import com.cykj.hospitalsystem.mapper.TbldepartrmentMapper;
import com.cykj.hospitalsystem.service.TbldepartrmentService;
import com.cykj.hospitalsystem.until.FileUploadUtil;
import com.cykj.hospitalsystem.until.KTool;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Cache;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TbldepartrmentImpl implements TbldepartrmentService {

    @Autowired
    private TbldepartrmentMapper tbldepartrmentMapper;

    @Override
    public Map<String, Object> selectState(Map<String,Object> map) {
        String dstateStr = KTool.dataid18tonull(map.get("dstate"));
        map.put("dstateStr",dstateStr);
        System.out.println("处理后的数据是："+dstateStr);
        String str=map.get("searchStr").toString().trim();
        if(KTool.checkNameChese(str)){
            map.put("dname",str);
        }else {
            map.put("dcode",str);
            map.put("dspell",str);
        }
        List<Tbldepartrment> listState=tbldepartrmentMapper.selectState(map);
        map.put("TbldepartrmentList",listState);
        String a = tbldepartrmentMapper.countRows(map);
        int totalCum = 0;
        if(a!=null || a!=""){
            totalCum = Integer.parseInt(tbldepartrmentMapper.countRows(map));
        }
        map.put("totalCum",totalCum);
        map.put("code",1);
        return map;
    }

    @Override
    public Map<String, Object> addDate(Map<String, Object> map) {
//自增内码
        Date date = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nowDayStr = sdf.format(date);
        System.out.println(nowDayStr);
        //找到科室表中最大的id
        String departmentMaxId = tbldepartrmentMapper.MaxDid(); // 用于生成 管理员内码
        if(departmentMaxId !=null){
            map.put("dincode",nowDayStr+(departmentMaxId+""));
        }else {
            map.put("dincode",0);
        }
        // 转换拼音
       map.put("dspell",KTool.toPinyin(map.get("dname").toString().trim()));
       tbldepartrmentMapper.addDate(map);
       map.put("msg","增加成功");
       return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> updDate(Map<String, Object> map) {
        tbldepartrmentMapper.updDate(map);
        map.put("msg","修改成功");
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> selTblkname(Map<String, Object> map) {
        List<Tblkname> list=tbldepartrmentMapper.selTblkname();
        map.put("list",list);
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> updStateDate(Map<String, Object> map) {
        int i = tbldepartrmentMapper.updStateDate(map);
        String msg = "";
        switch (map.get("dstate").toString()){
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
        if(i>=1){
            map.put("code",1);
            map.put("msg","批量"+msg+"成功!");
        }else{
            map.put("code",0);
            map.put("msg","批量"+msg+"异常，请重试");
        }
        return map;
    }

    @Override
    public Map<String, Object> upfile(MultipartFile file) throws IOException, BiffException {
        System.out.println("进入upfile");
        Map<String, Object> map = new HashMap<>();
        JSONObject jsonRsult = new JSONObject();
        if (file.isEmpty()){
            jsonRsult.put("code",201);
            jsonRsult.put("msg","请选择文件");
            map.put("code",201);
            map.put("msg","请选择文件");
        }else{
            String path= FileUploadUtil.upload(file);
            InputStream io=new FileInputStream(path);
            Workbook wb=Workbook.getWorkbook(io);
            Sheet[] sheets= wb.getSheets();
            System.out.println("打印sheets数组"+sheets);
            Sheet st=sheets[0];
            System.out.println("打印sheets下表0"+st);

            int rows=st.getRows();
            int cols=st.getColumns();
            List<Tbldepartrment> deplist=new ArrayList<>();
            //查询国际编码表的所有数据
            List<Tblkname> knlist = tbldepartrmentMapper.selTblkname();
            System.out.println("列数="+cols);
            for(int i=1;i<rows;i++){
                Cell[] cells = st.getRow(i);
                Tbldepartrment dep=new Tbldepartrment();
                dep.setDname(cells[1].getContents());
                dep.setDcode(cells[2].getContents());
                try{
                     //代码区
                    dep.setDspell(cells[5].getContents());
                }catch(Exception e){
                    //异常处理
                    dep.setDspell("");
                }
                try{
                    //代码区
                    String knameStr = cells[3].getContents().trim();
                    long knameofkid = 0 ;

                    String knumStr = cells[4].getContents().trim();
                    long knumofkid = 0 ;

                    for (Tblkname tk : knlist) {
                        if (tk.getKname().equals(knameStr)) {
                            knameofkid = tk.getKid();
                        }
                        if (tk.getKnum().equals(knumStr)) {
                            knumofkid = tk.getKid();
                        }
                    }
                    if (knameofkid == 0){
                        // 如果导入数据的时候数据库没有对应的，则不赋值
                        //如果有其他业务要求，再写
                    }else{
                        dep.setKname(knameofkid+"");
                    }
                    if (knumofkid == 0){

                    }else{
                        dep.setKnum(knumofkid+"");
                    }
                }catch(Exception e){
                    //异常处理
                    e.printStackTrace();
                }
                try{
                    //代码区
                    String cellsState = cells[0].getContents().trim();
                    String dstate = "2";
                    if("启用".equals(cellsState)){
                        dstate = "2";
                    }else if("禁用".equals(cellsState)){
                        dstate = "3";
                    }else if("作废".equals(cellsState)){
                        dstate = "4";
                    }else {
                        dstate = "2";
                    }
                    dep.setDstate(dstate);
                }catch(Exception e){
                    e.printStackTrace();
                    //异常处理
                    dep.setDstate("2");
                }
                deplist.add(dep);
            }
            System.out.println(deplist);
            int i = tbldepartrmentMapper.addBatch(deplist);
            if(i>=1){
                map.put("code",1);
                map.put("msg","文件导入成功");
            }else{
                map.put("code",0);
                map.put("msg","文件导入异常");
            }
        }
        return map;
    }

    @Override
    public Tbldepartrment Seldistinct(String dname, String dcode) {
        return tbldepartrmentMapper.Seldistinct(dname, dcode);
    }

    //    @Override
//    public Map<String, Object> selectList(Map<String, Object> map) {
//        List<Tbldepartrment> list=tbldepartrmentMapper.selectList(map);
//        map.put("list",list);
//        int  totalCum = Integer.parseInt(tbldepartrmentMapper.countRows(map));
//        map.put("totalCum",totalCum);
//        return map;
//    }

    //    @Override
//    public Map<String,Object> start(Map<String, Object> map) {
//        map.put("dstate",2);
//        int i = tbldepartrmentMapper.updStateDate(map);
//        if(i>=1){
//            map.put("code",1);
//            map.put("msg","启用成功");
//        }else{
//            map.put("code",0);
//            map.put("msg","启用异常，请重试");
//        }
//        return map;
//    }
//
//    @Override
//    public Map<String,Object> stop(Map<String, Object> map) {
//        map.put("dstate",3);
//        int i = tbldepartrmentMapper.updStateDate(map);
//        if(i>=1){
//            map.put("code",1);
//            map.put("msg","禁用成功");
//        }else{
//            map.put("code",0);
//            map.put("msg","禁用异常，请重试");
//        }
//        return map;
//    }
//
//    @Override
//    public Map<String,Object> disable(Map<String, Object> map) {
//        map.put("dstate",4);
//        int i = tbldepartrmentMapper.updStateDate(map);
//        if(i>=1){
//            map.put("code",1);
//            map.put("msg","作废成功");
//        }else{
//            map.put("code",0);
//            map.put("msg","作废异常，请重试");
//        }
//        return map;
//    }

}
