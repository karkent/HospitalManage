package com.cykj.hospitalsystem.mapper;
import com.cykj.hospitalsystem.bean.WasteTableInfo;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface WasteTableMapper {
    //根据 日期显示医疗卫生机构交接人员名称，废物运送人员名，交接时间
    WasteTableInfo getWasteTableInfo(Map<String,Object> map);

}
