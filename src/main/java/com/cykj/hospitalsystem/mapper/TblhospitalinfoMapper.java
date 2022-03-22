package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.Tblhospitalinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TblhospitalinfoMapper {

    //验证重复
    Tblhospitalinfo check(@Param(value = "hname") String hname,
                          @Param(value = "huscc") String huscc);

    Tblhospitalinfo selectid(@Param(value = "hname") String hname,
                             @Param(value = "huscc") String huscc);

    int countRows(Map<String, Object> map);

    int updatehospital(Map<String, Object> map);

    int addhospital(Map<String, Object> map);

    int upstate(@Param(value = "map") Map<String, Object> map);

    List<Tblhospitalinfo> find(Map<String, Object> map);
}
