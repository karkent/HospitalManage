package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.Tblbox;
import com.cykj.hospitalsystem.bean.Tbldata;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface TblboxMapper {

    List<Tblbox> showTable(Map<String, Object> map);

    List<Tbldata> selTbldata();
    /*添加*/
    int addbox(List<Tblbox> list);

    /*根据时间查最大值*/
    String MaxboxCode(@Param(value = "startTime") String startTime,
                      @Param(value = "endTime") String endTime);

    //批量操作
    int setstate(@Param(value = "map") Map<String, Object> map);

    int countRows(Map<String, Object> map);

    List<Tblbox> tblboxes(Map<String, Object> map);
    //   手工登记的业务 根据boxcode返回boxid

    String getIdbyBoxcode(String boxcode);
}
