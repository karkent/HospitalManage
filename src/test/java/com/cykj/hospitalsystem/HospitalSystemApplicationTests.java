package com.cykj.hospitalsystem;

import com.alibaba.fastjson.JSONObject;
import com.cykj.hospitalsystem.bean.Tblmedicaltype;
import com.cykj.hospitalsystem.mapper.TblwaringnotesMapper;
import com.cykj.hospitalsystem.until.KTool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@SpringBootTest
public class HospitalSystemApplicationTests {
    @Autowired
    TblwaringnotesMapper tblwaringnotesMapper;

    @Test
    public void kk() {
        List<Tblmedicaltype> tblmedicaltypes = tblwaringnotesMapper.years(KTool.getYearStartTime());
        Double yearWeight = 0.00;
        Double monthWeight = 0.00;
        Double dayWeight = 0.00;
        System.out.println(tblmedicaltypes.size() + "size");
        for (Tblmedicaltype m : tblmedicaltypes) {
            yearWeight = KTool.add(yearWeight, Double.valueOf(m.getWeight()));
            try {
                m.setCollectdate(String.valueOf(KTool.dayToTimeInMillis(m.getCollectdate())));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (Long.valueOf(m.getCollectdate()) >= KTool.getMonthStartTime()) {
                monthWeight = KTool.add(monthWeight, Double.valueOf(m.getWeight()));
            }
            //获取日
            if (Long.valueOf(m.getCollectdate()) >= KTool.getTodayZeroPointTimestamps()) {
                dayWeight = KTool.add(dayWeight, Double.valueOf(m.getWeight()));
            }
        }
//        System.out.println(KTool.timeInMillisToDay(KTool.getMonthStartTime())+"%^");
//        System.out.println(JSONObject.toJSONString(tblmedicaltypes)+"@#"+yearWeight+"@"+monthWeight+"@"+dayWeight);
        List<Tblmedicaltype> tblMSort = tblwaringnotesMapper.weightSort(KTool.getYearStartTime());
        for (Tblmedicaltype r : tblMSort) {

        }
        //近三天七天
        List<Tblmedicaltype> seven = null;
        List<Tblmedicaltype> disease = null;
        try {
            disease = KTool.bubbleSort(tblwaringnotesMapper.disease());
            seven = KTool.bubbleSort(tblwaringnotesMapper.sevenDay());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Tblmedicaltype t:disease) {

        }
        List<Tblmedicaltype> sevenDisease = null;
        for (Tblmedicaltype r : seven) {
            r.setCollectdate(r.getCollectdate().substring(0, 10));
        }
        List<Tblmedicaltype> three = seven.subList(0, 3);
        System.out.println(JSONObject.toJSONString(three)+"@#$$%");


        //科室
        List<Tblmedicaltype> officeRealTimeCollecting = tblwaringnotesMapper.officeRealTimeCollecting();
        for (Tblmedicaltype r : officeRealTimeCollecting) {
            r.setSpare3(KTool.protectedName(r.getSpare3()));
        }


        //周 日 医废占比
        List<Tblmedicaltype> weekProportion = tblwaringnotesMapper.dayWeekProportion(KTool.getNextDay
                (KTool.timeInMillisToDay(KTool.getTodayZeroPointTimestamps()), -6) + " 00:00:00");
        for (Tblmedicaltype r : weekProportion) {
            r.setSpare3(KTool.protectedName(r.getSpare3()));
        }
        List<Tblmedicaltype> dayProportion = tblwaringnotesMapper.dayWeekProportion(KTool.timeInMillisToDay
                (KTool.getTodayZeroPointTimestamps()));
        for (Tblmedicaltype r : dayProportion) {
            r.setSpare3(KTool.protectedName(r.getSpare3()));
        }
    }

    @Test
    public void fg(){
        System.out.println(KTool.todayTime()+"3242");
    }

    @Test
    public void yy() {
        System.out.println(KTool.getNextDay(KTool.timeInMillisToDay(KTool.getTodayZeroPointTimestamps()), -7) + " 00:00:00" + "@#$");
    }

}
