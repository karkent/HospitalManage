package com.cykj.hospitalsystem.until;

import com.alibaba.fastjson.JSONObject;
import com.cykj.hospitalsystem.bean.Tblmedicaltype;
import com.cykj.hospitalsystem.bean.Tblwaringnotes;
import com.cykj.hospitalsystem.bean.Tblwarning;
import com.cykj.hospitalsystem.controller.WebSocketServer;
import com.cykj.hospitalsystem.mapper.TblwaringnotesMapper;
import com.cykj.hospitalsystem.mapper.TblwarningMapper;
import com.cykj.hospitalsystem.service.TblmedicaltypeService;
import com.cykj.hospitalsystem.service.TblwaringnotesService;
import org.omg.CORBA.OBJ_ADAPTER;
import org.omg.CORBA.TIMEOUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.MapUtils;

import javax.print.attribute.HashAttributeSet;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class Timer {

    public final int TIMEOUT = 6 * 1000;
    private int z = 0;
    @Autowired
    TblmedicaltypeService tblmedicaltypeService;
    @Autowired
    TblwaringnotesService tblwaringnotesService;
    @Autowired
    TblwaringnotesMapper tblwaringnotesMapper;
    @Autowired
    TblwarningMapper tblwarningMapper;
    @Autowired
    // 时间 间隔
    @Scheduled(fixedDelay = 1000 * 5 * 120) //
    //判断 收集入库 不能超过一个小时的 方法
    public void playSth() throws IOException {
        z++;
        System.out.println("进行了一次"+z);
        // 预警设置的 实体类
        Tblwarning tblwarning =  tblwarningMapper.warningconfig();

        getWarningTime(tblwarning);// 调用入库超时的预警

        weightWarning(tblwarning);// 调用入库重量异常的预警

        outOvertime(tblwarning);// 调用交接超时的预警

        //预警弹窗的表格数据
        //默认从第一页开始
        Map<String,Object> map = new HashMap<>();
        map.put("nowPage",0);
        map.put("pageSize",10);
        map = tblwaringnotesService.findAll(map);
        String s = JSONObject.toJSONString(map);
        System.out.println("打印准备发送的数据：" + s);
        WebSocketServer.BroadCastInfo(s);
    }

    public void outOvertime(Tblwarning tblwarning){
        //获得当前系统前一个小时的时间
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String timeStr = tblwarning.getJoinovertime();
        int timeInt = 48; // 默认值等于1
        if (timeStr != null || !timeStr.equals("")) {
            timeInt = Integer.valueOf(timeStr);
        }
        //减去n个小时
        c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) - timeInt);
        String dateStr = DateFormat.getDateTimeInstance().format(c.getTime());
        String nowdate = DateFormat.getDateTimeInstance().format(new Date());
        System.out.println(dateStr+"@@"+nowdate);
        Map<String,Object> map = new HashMap<>();
        map.put("dateStr",dateStr);
        // 获得交接超时的 列表，返回的是收集列表的集合
        List<Tblmedicaltype> medicaltypeList = tblwaringnotesMapper.OutOvertime(map);
        if (medicaltypeList.size() > 0) {
            List<Tblwaringnotes> wlist = new ArrayList<>();
            //循环遍历获得收集预警的数据
            for (Tblmedicaltype tblmedicaltype : medicaltypeList) {
                Long getTime = null;
                try {
                    getTime = Long.parseLong(dateToStamp(nowdate)) - Long.parseLong(dateToStamp(tblmedicaltype.getCollectdate()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Long houer = Long.valueOf(timeInt * 3600000);
                if (getTime>=houer && getTime!=null){
                    map.put("handlestate",0); // 默认 未处理
                    map.put("warningtype",30); // 交接超时预警 也就是出库超时
                    map.put("warninglink",35); // 环节  出库
                    map.put("wcase","出库超时异常"); // 环节  入库
                    map.put("dateStr",dateStr);
                    map.put("medicaltypeList",medicaltypeList);
                    System.out.println(JSONObject.toJSONString(map));
                    tblwaringnotesMapper.delOutStockOvertimeWaring();//先清空，预警信息表中，所有交接预警的信息
                    tblwaringnotesMapper.addnoteByMap(map); // 然后再重新添加，重量预警的信息
                    //批量设置 入库表中，入库异常的预警状态，将tbltrashin表的spare1设置为1.
                    tblwaringnotesMapper.setOutStockOvertimeWaringState(map);
                }
            }
        }
    }

    int a = 0;
    int b = 0;
    // 入库超时的预警    入库是收集之后没有及时入库的
    public void getWarningTime(Tblwarning tblwarning){
        //获得当前系统前一个小时的时间
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        System.out.println(c+"系统时间");

        String timeStr = tblwarning.getEnterovertime();
        int timeInt = 1; // 默认值等于1
        System.out.println(timeStr+"预警时间");
        if (timeStr!=null || !timeStr.equals("")){
            timeInt = Integer.valueOf(timeStr);
        }
        //减去n个小时
        c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) - timeInt);
        String dateStr = DateFormat.getDateTimeInstance().format(c.getTime());
        System.out.println(dateStr);

        //获得 已经超过n小时的 数据  进行预警设置
        List<Tblmedicaltype> list = tblmedicaltypeService.outtimein(dateStr);
        if (list.size() != 0) {
            List<Tblwaringnotes> wlist = new ArrayList<>();
            //循环遍历获得收集预警的数据
            String nowdate = DateFormat.getDateTimeInstance().format(new Date());
            for (Tblmedicaltype tblmedicaltype : list) {
                b++;
                Long getTime = null;
                try {
                    getTime = Long.parseLong(dateToStamp(nowdate))-Long.parseLong(dateToStamp(tblmedicaltype.getCollectdate()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Long houer = Long.valueOf(timeInt*3600000);
                if (getTime>=houer && getTime!=null){
                    a++;
                    System.out.println("wl"+a);
                    String bagcode = tblmedicaltype.getBagcode();
                    int did = (int) tblmedicaltype.getDid();
                    //  每一条 收集的数据    都会生成一条预警消息
                    int hid = (int) tblmedicaltype.getHid();
                    Tblwaringnotes tblwaringnotes = new Tblwaringnotes(0, 29, 34, bagcode, did, "入库超时预警", nowdate,hid);
                    System.out.println(JSONObject.toJSONString(tblwaringnotes)+"ko");
                    wlist.add(tblwaringnotes);
                    tblmedicaltypeService.warningstatus((int) tblmedicaltype.getInfoid());
                }
                System.out.println("wk"+a);
            }
            System.out.println(wlist=null);
            System.out.println(wlist+"@$#@$");
            if (wlist!=null){
                int i = tblwaringnotesService.addnote(wlist);
            }
        }

    }

    public void weightWarning(Tblwarning tblwarning){
        //根据重量的预警设置，获得预警提示
        String Carweight = tblwarning.getCarweight();//收集车重量

        String Removeboxkg = tblwarning.getRemoveboxkg();//是否去除箱重量

        String Boxkg = tblwarning.getBoxkg();//箱重
        Long Peelnum = tblwarning.getPeelnum();//去皮个数
        String Bagerror = tblwarning.getBagerror();//允许误差20%，取到20，则代表20%
        double bagerrorDouble = 10;//默认20
        System.out.println(Carweight+"!"+Removeboxkg+"@"+Boxkg+"@"+Peelnum+"@"+bagerrorDouble);
        if (Bagerror != null || !Bagerror.equals("")) {
            bagerrorDouble = Double.valueOf(Bagerror); // 将字符串转换成双精度
        }

        double frontNum = (100 + bagerrorDouble) * 0.01; // 用于传入数据库做 误差的计算
        double rearNum = (100 - bagerrorDouble) * 0.01;

        double delKg = Double.valueOf(Carweight);

        if (Removeboxkg.equals("是")) {
            delKg += Double.valueOf(Boxkg) * Double.valueOf(Peelnum) ;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("delKg", delKg);
        map.put("frontNum", frontNum);
        map.put("rearNum", rearNum);
        // 可以查出 所有超重预警的收集列表
        List<Tblmedicaltype> medicaltypeList = tblwarningMapper.StockInWeightCheck(map);
        System.out.println(JSONObject.toJSONString(medicaltypeList)+"@@@@");

        String nowdate = DateFormat.getDateTimeInstance().format(new Date());
        map.put("handlestate",0); // 默认 未处理
        map.put("warningtype",31); // 重量异常
        map.put("warninglink",34); // 环节  入库
        map.put("wcase","入库重量异常"); // 环节  入库
        map.put("nowdate",nowdate);
        map.put("medicaltypeList",medicaltypeList);

        if (medicaltypeList.size() > 0) {
            System.out.println("没跳出");
            tblwaringnotesMapper.delInStockWeightWaring(map);//先清空，预警信息表中，入库环节重量预警的信息
            System.out.println(JSONObject.toJSONString(map)+"qqq");
            tblwaringnotesMapper.addnoteByMap(map); // 然后再重新添加，重量预警的信息
            //批量设置 收集表，入库重量异常的状态，将tblmedicaltype表的spare1设置为1.
            map.put("spare1",1);
            tblwaringnotesMapper.setWeightWaringState(map);
        }


        List<Tblmedicaltype> OutweightList = tblwarningMapper.StockOutWeightCheck(map);

        map.put("warninglink",35); // 环节  出库
        map.put("wcase","出库重量异常"); // 环节  出库
        map.put("medicaltypeList",OutweightList); // 集合覆盖，在执行，添加 出库异常预警的信息
        if (OutweightList.size() > 0 ){
            tblwaringnotesMapper.delInStockWeightWaring(map);//先清空，预警信息表中，出库环节重量预警的信息
            tblwaringnotesMapper.addnoteByMap(map); // 然后再重新添加，重量预警的信息
            //批量设置 收集表，出库重量异常的状态，将tblmedicaltype表的spare2设置为1.
            map.put("spare2",1);
            tblwaringnotesMapper.setWeightWaringState(map);
        }
    }

    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
}
