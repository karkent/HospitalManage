package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.Tbldata;
import com.cykj.hospitalsystem.bean.Tbltypeprint;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface TrashTypeMapper {
    List<Tbltypeprint> seltype(Map<String, Object> map);
    //显示表格
    List<Tbltypeprint> selTrashList(Map<String, Object> map);
    //总行数
    int countRows(Map<String, Object> map);
    //新增
    int addTrash(Map<String, Object> map);
    //修改
    int updateTrash(Map<String, Object> map);

    int updateState(@Param(value = "tstate") int tstate,
                    @Param(value = "tid") int tid);
    //批量操作
    int setstate(@Param(value = "map") Map<String, Object> map);

    int selTrashListCount(Map<String, Object> map);

    Tbltypeprint findExist(@Param(value = "tname") String tname);

    List<Tbltypeprint> getNameId();
}
