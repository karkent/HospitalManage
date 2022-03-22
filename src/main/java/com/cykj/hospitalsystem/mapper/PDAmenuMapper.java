package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.TblPdAmenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
@Repository
public interface PDAmenuMapper {

    List<TblPdAmenu> authorityMenuPDA(Map<String,Object> map);

    List<TblPdAmenu> getPDAId(Map<String,Object> map);

    List<TblPdAmenu> getPDAidByArrayId(@Param(value = "map") Map<String, Object> map);
    /*批量修改状态*/
    int setPDAmenuState(@Param(value = "map") Map<String, Object> map);
    /*修改菜单数据*/
    int setPDAmenuData(Map<String,Object> map);
    /*新增菜单*/
    int addPDAmenu(Map<String, Object> map);

}
