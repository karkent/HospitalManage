package com.cykj.hospitalsystem.service.impl;

import com.cykj.hospitalsystem.bean.Tbldepartrment;
import com.cykj.hospitalsystem.bean.Tblrole;
import com.cykj.hospitalsystem.bean.Tblstaff;
import com.cykj.hospitalsystem.bean.Tblwarning;
import com.cykj.hospitalsystem.mapper.RoleMapper;
import com.cykj.hospitalsystem.mapper.TbldepartrmentMapper;
import com.cykj.hospitalsystem.mapper.TblwarningMapper;
import com.cykj.hospitalsystem.service.WarningService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WarningServiceImpl implements WarningService {
    @Autowired
    private TblwarningMapper tblwarningMapper;
    @Autowired
    private TbldepartrmentMapper tbldepartrmentMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Map<String, Object> warningconfig() {
        Map<String,Object> map = new HashMap<>();
        Tblwarning tblwarning =  tblwarningMapper.warningconfig();
        String[] strings = tblwarning.getNotice().split(",");
        for (int i=0;i<strings.length;i++){
            strings[i] = strings[i].trim();
        }
        tblwarning.setArrnotice(strings);
        map.put("data",tblwarning);
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String,Object> departmentstaff() {
        //查找 科室的列表 及其员工
        List<Tbldepartrment> departrmentList = tbldepartrmentMapper.departmentstaff();
        for (Tbldepartrment tbldepartrment : departrmentList) {
            if (tbldepartrment.getChildren() != null) {
                tbldepartrment.setLabel(tbldepartrment.getLabel() + "(" + tbldepartrment.getChildren().size() + ")");
            }
        }

        List<Tblrole> roles = roleMapper.RoleStaff();
        //查找  角色的列表 及其员工
        for (Tblrole tr : roles) {
            if (tr.getChildren().size() > 0) {
                tr.setLabel(tr.getLabel() + "(" + tr.getChildren().size() + ")");
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("departrmentList",departrmentList);
        map.put("roles",roles);
        // 已保存的预警通知人
        map.put("warningStaff",tblwarningMapper.warningStaff());

        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> savaWarning(Map<String, Object> map) {
        String notice = map.get("arrnotice").toString().replace("[", "");
        notice = notice.replace("]", "");
        map.put("notice", notice);
        tblwarningMapper.savaWarning(map);

        tblwarningMapper.delAllByWarningid(); // 删除全部，然后再插入

        tblwarningMapper.addWarningstaff(map);

        //启用的方法
//        // 查找员工id 已经在关联表的集合
//        List<Tblstaff> inStaffs = tblwarningMapper.warningGetInId();
//        // 新建一个空的集合。
//        List<Tblstaff> addStaffs = new ArrayList<>();
        // 去除 左右[]
//        String staff = map.get("staffArray").toString().replace("[","");
//        staff = staff.replace("]","").trim(); // 并去除左右空格
//        String staffArray[] = staff.split(",");//分割成新的数组
//        if (staffArray.length>0){
//            for (int i = 0; i < staffArray.length; i++) {
//                String staff1 = staffArray[i].trim();
//                int staffid = Integer.valueOf(staff1);
//                System.out.println("打印前端传来的数组元素："+staffid);
//                if (inStaffs.size() > 0) {
//                    int fisg = 1;
//                    for (Tblstaff ts : inStaffs) {
//                        if (ts.getStaffid() == staffid) {
//                            fisg = 0;
//                        }
//                    }
//                    if (fisg==1){
//                        Tblstaff tblstaff = new Tblstaff();
//                        tblstaff.setStaffid(staffid);
//                        addStaffs.add(tblstaff);
//                    }
//                } else {
//                    Tblstaff tblstaff = new Tblstaff();
//                    tblstaff.setStaffid(staffid);
//                    addStaffs.add(tblstaff);
//                }
//            }
//            map.put("addStaffs",addStaffs);
//            if (addStaffs.size()>0){
//                tblwarningMapper.addWarningstaff(map);
//            }
//        }
        return KTool.codeToclient(map);
    }
}
