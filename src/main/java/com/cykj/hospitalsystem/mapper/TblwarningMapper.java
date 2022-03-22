package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.Tblmedicaltype;
import com.cykj.hospitalsystem.bean.Tblstaff;
import com.cykj.hospitalsystem.bean.Tblwarning;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface TblwarningMapper {
    Tblwarning warningconfig();
    int savaWarning(Map<String,Object> map);
    List<Tblstaff> warningGetInId();
    int addWarningstaff(@Param(value = "map") Map<String,Object> map);
    int delAllByWarningid();
    List<Tblstaff> warningStaff();
    List<Tblmedicaltype> StockInWeightCheck(Map<String,Object> map);
    List<Tblmedicaltype> StockOutWeightCheck(Map<String,Object> map);

}
