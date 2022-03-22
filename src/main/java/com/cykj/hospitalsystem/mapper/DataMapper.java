package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.Tbldata;
import com.cykj.hospitalsystem.bean.ViewD;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DataMapper {

    int countRows(Map<String, Object> map);
    //新增
    int addData(Map<String, Object> map);
    //修改
    int updateData(Map<String, Object> map);

    List<Tbldata> selpname(Map<String, Object> map);

    int setstate(@Param(value = "map") Map<String, Object> map);

    List<Tbldata> findAllByPid(Map<String, Object> map);
    //显示表格
    List<Tbldata> findAll(Map<String, Object> map);
}
