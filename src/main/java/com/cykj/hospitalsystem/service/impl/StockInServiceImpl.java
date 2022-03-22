package com.cykj.hospitalsystem.service.impl;
import com.cykj.hospitalsystem.bean.StockIn;
import com.cykj.hospitalsystem.bean.Tbladmininfo;
import com.cykj.hospitalsystem.bean.Tblhospitalinfo;
import com.cykj.hospitalsystem.bean.Tblstaff;
import com.cykj.hospitalsystem.mapper.StockInMapper;
import com.cykj.hospitalsystem.mapper.TbladmininfoMapper;
import com.cykj.hospitalsystem.service.StockInService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StockInServiceImpl implements StockInService {

    @Autowired
    private StockInMapper stockInMapper;
    @Autowired
    private TbladmininfoMapper tbladmininfoMapper;
    // 查询医废入库信息
    @Override
    public List<StockIn> queryStockInInfo(Map<String,Object> map) {
        System.out.println("查询医废入库信息");
        List<StockIn> list = stockInMapper.queryStockInInfo(map);
        return list;
    }
    // 查询医废入库信息总条数
    @Override
    public int queryStockInInfoCount(Map map) {
        return stockInMapper.queryStockInInfoCount(map);
    }

    // 查询所有医院名称
    @Override
    public List<Tblhospitalinfo> getHospitalName() {
        return stockInMapper.getHospitalName();
    }

    // 批量出库
    @Override
    public Map<String,Object> batchOutLibrary(Map<String,Object> map) {
        stockInMapper.batchOutLibrary(map);
        map.put("msg","批量出库成功");
        String roletype = map.get("RoleType").toString();
        String Name = "";
        if (roletype.equals("admin")) {
            Tbladmininfo admin = tbladmininfoMapper.byUserNameGetAdmin(map);
            Name =  admin.getAname();
        }else if (roletype.equals("staff")){
            map.put("staffid",map.get("adminid"));
            Tblstaff tblstaff = tbladmininfoMapper.loginStaff(map);
            Name = tblstaff.getSname();
        }
        map.put("outman",Name);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDayStr = sdf.format(date);
        map.put("outdate",nowDayStr);
        stockInMapper.AddTWO(map);
        return KTool.codeToclient(map);
    }

    // 批量全部出库
    @Override
    public Map<String,Object> batchOutLibraryAll(Map<String,Object> map) {
        map.put("stickInArray",stockInMapper.findTblByState());

        String roletype = map.get("RoleType").toString();
        String Name = "";
        if (roletype.equals("admin")) {
            Tbladmininfo admin = tbladmininfoMapper.byUserNameGetAdmin(map);
            Name =  admin.getAname();
        }else if (roletype.equals("staff")){
            map.put("staffid",map.get("adminid"));
            Tblstaff tblstaff = tbladmininfoMapper.loginStaff(map);
            Name = tblstaff.getSname();
        }
        map.put("outman",Name);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDayStr = sdf.format(date);
        map.put("outdate",nowDayStr);
        stockInMapper.AddTWO(map);
        stockInMapper.batchOutLibraryAll();
        map.put("msg","批量全部出库成功");
        return KTool.codeToclient(map);
    }

    // 查询医废入库信息(无分页)
    @Override
    public List<StockIn> queryStockInInfoAll(String hname, String state, String beginTime, String endTime) {
        return stockInMapper.queryStockInInfoAll(hname, state, beginTime, endTime);
    }

}
