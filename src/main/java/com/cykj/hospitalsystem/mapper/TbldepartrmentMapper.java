package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.Tbldepartrment;
import com.cykj.hospitalsystem.bean.Tblkname;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbldepartrmentMapper {

//    List<Tbldepartrment> selectList(Map<String,Object> map);
    String countRows(Map<String, Object> map);

    List<Tbldepartrment> selectState(Map<String, Object> map);

    String MaxDid();
    int addDate(Map<String, Object> map);

    int updDate(Map<String, Object> map);

    int updStateDate(@Param(value = "map") Map<String, Object> map);

    List<Tblkname> selTblkname();

    int addBatch(List<Tbldepartrment> list);

    Tbldepartrment Seldistinct(@Param(value = "dname") String dname,
                               @Param(value = "dcode") String dcode);
    List<Tbldepartrment> departmentstaff();
}
