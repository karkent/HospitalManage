package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.Tblsave;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
@Repository
public interface SaveMapper {

    int countRows(Map<String, Object> map);
    //新增
    int addSave(Map<String, Object> map);
    //修改
    int updateSave(Map<String, Object> map);
    //查状态
    List<Tblsave> selsavestate(Map<String, Object> map);
    //批量操作
    int setstate(@Param(value = "map") Map<String, Object> map);

    Tblsave findExist(@Param(value = "savename") String savename,
                      @Param(value = "savecode") String savecode);
}
