package com.cykj.hospitalsystem.service;


import com.cykj.hospitalsystem.bean.Tbldepartrment;
import com.cykj.hospitalsystem.bean.Tblkname;
import jxl.read.biff.BiffException;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public interface TbldepartrmentService {



    Map<String,Object> selectState(Map<String, Object> map);

    Map<String,Object> addDate(Map<String, Object> map);

    Map<String,Object> updDate(Map<String, Object> map);

    Map<String,Object> selTblkname(Map<String, Object> map);

    //批量修改
    Map<String,Object> updStateDate(Map<String, Object> map);

    //    Map<String,Object> selectList(Map<String,Object> map);

//    Map<String,Object> start(Map<String, Object> map);
//    Map<String,Object> stop(Map<String, Object> map);
//    Map<String,Object> disable(Map<String, Object> map);

    Map<String,Object> upfile(MultipartFile file) throws IOException, BiffException;

    Tbldepartrment Seldistinct(String dname, String dcode);

}
