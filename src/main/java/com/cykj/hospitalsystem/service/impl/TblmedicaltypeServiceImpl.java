package com.cykj.hospitalsystem.service.impl;



import com.alibaba.fastjson.JSONObject;
import com.cykj.hospitalsystem.bean.*;
import com.cykj.hospitalsystem.mapper.*;
import com.cykj.hospitalsystem.service.TblmedicaltypeService;
import com.cykj.hospitalsystem.until.KTool;
//import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimePullMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.yaml.snakeyaml.events.Event;

//import javax.management.openmbean.OpenDataException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TblmedicaltypeServiceImpl implements TblmedicaltypeService {

    @Autowired
    private TblmedicaltypeMapper tblmedicaltypeMapper;
    @Autowired
    private TrashTypeMapper trashTypeMapper;
    @Autowired
    private StockInMapper stockInMapper;
    @Autowired
    private TblboxMapper tblboxMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private WasteTableMapper wasteTableMapper;
    @Override
    public Map<String, Object> selTbldpartment(Map<String, Object> map) {
        List<Tbldepartrment> list = tblmedicaltypeMapper.selTbldpartment();
        map.put("list", list);
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> selTbltypeprin(Map<String, Object> map) {
        List<Tbltypeprint> list = tblmedicaltypeMapper.selTbltypeprin();
        map.put("list", list);
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> selTblhospitalinfo(Map<String, Object> map) {
        List<Tblhospitalinfo> list = tblmedicaltypeMapper.selTblhospitalinfo();
        map.put("list", list);
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> selTbldata(Map<String, Object> map) {
        List<Tbldata> list = tblmedicaltypeMapper.selTbldata();
        map.put("list", list);
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> selTblstaff(Map<String, Object> map) {
        List<Tblstaff> list = tblmedicaltypeMapper.selTblstaff();
        map.put("list", list);
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> selTblsave(Map<String, Object> map) {
        List<Tblsave> list = tblmedicaltypeMapper.selTblsave();
        map.put("list", list);
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> selTblboxcode(Map<String, Object> map) {
        List<Tblbox> list = tblmedicaltypeMapper.selTblboxcode();
        map.put("list", list);
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> selTblboxcodes(Map<String, Object> map) {
        List<Tblbox> list = tblmedicaltypeMapper.selTblboxcodes();
        map.put("list", list);
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> findAll(Map<String, Object> map) {
        String timeStr = map.get("start").toString();
        if (!timeStr.equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long timel = (Long) map.get("start");
            Long time2 = (Long) map.get("end");
            String startdate = sdf.format(new Date(timel));
            String enddate = sdf.format(new Date(time2));
            map.put("startdate", startdate);
            map.put("enddate", enddate);
        }

        // ?????????????????????
        String str = map.get("searchStr").toString().trim();
        if (KTool.isNumeric(str)) { // ????????????
            map.put("bagcode", str);
            map.put("boxcode", str);
        }
        map.put("tableData", tblmedicaltypeMapper.findAll(map));
        map.put("totalCum", tblmedicaltypeMapper.countRows(map));
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> find(Map<String, Object> map) {
        String timeStr = map.get("start").toString();
        if (!timeStr.equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long timel = (Long) map.get("start");
            Long time2 = (Long) map.get("end");
            String startdate = sdf.format(new Date(timel));
            String enddate = sdf.format(new Date(time2));
            map.put("startdate", startdate);
            map.put("enddate", enddate);
        }
        // ?????????????????????
        String str = map.get("searchStr").toString().trim();
        if (KTool.isNumeric(str)) { // ????????????
            map.put("bagcode", str);
            map.put("boxcode", str);
        }
        List<Viewmedicaltype> map1 = tblmedicaltypeMapper.find(map);
        for (Viewmedicaltype v :map1) {
            if (v.getSaveid()==0 ){
                v.setSavename(null);
            }
        }

        map.put("tableData",map1);
        map.put("totalCum", tblmedicaltypeMapper.countRows(map));
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> upTrashType(Map<String, Object> map) {
        int i = tblmedicaltypeMapper.upTrashType(map);
        String msg = "";
        switch (map.get("typeid").toString()) {
            case "1":
                msg = "???????????????";
                break;
            case "2":
                msg = "???????????????";
                break;
            case "3":
                msg = "???????????????";
            case "4":
                msg = "???????????????";
            case "5":
                msg = "???????????????";
            case "6":
                msg = "????????????????????????";
            case "7":
                msg = "????????????????????????(???)";
            case "8":
                msg = "???????????????????????????";
            case "9":
                msg = "???????????????????????????";
                break;
        }
        if (i >= 1) {
            map.put("code", 1);
            map.put("msg", "??????" + msg + "??????!");
        } else {
            map.put("code", 0);
            map.put("msg", "??????" + msg + "??????????????????");
        }
        return map;
    }

    @Override
    public Map<String, Object> upTrashState(Map<String, Object> map) {
        int i = tblmedicaltypeMapper.upTrashState(map);
        if (i >= 1) {
            map.put("code", 1);
            map.put("msg", "??????" + "??????!");
        } else {
            map.put("code", 0);
            map.put("msg", "??????" + "??????????????????");
        }
        return map;
    }
    //???
    @Override
    public Map<String, Object> upSaveid(Map<String, Object> map) {

        List<Tblmedicaltype> tblmedicaltypes = tblmedicaltypeMapper.findTrashIn(map);
        Map<String,Object> map1 = null;
        for (Tblmedicaltype t : tblmedicaltypes) {
            System.out.println(JSONObject.toJSONString(t)+"@#$");
            map1 = new HashMap<>();
            map1.put("infoid",t.getInfoid());
            map1.put("weight",t.getWeight());
            map1.put("joinid",map.get("adminid"));
            map1.put("collectdate",KTool.todayTime());
            stockInMapper.addMedicalIn(map1);
        }
        int i = tblmedicaltypeMapper.upSaveid(map);

        System.out.println(map.get("saveid")+"#$RT"+JSONObject.toJSONString(map));
        if (i >= 1) {
            map.put("code", 1);
            map.put("msg", "???????????????" + "??????!");
        } else {
            map.put("code", 0);
            map.put("msg", "???????????????" + "??????????????????");
        }
        return map;
    }

    @Override
    public Map<String, Object> upBoxcode(Map<String, Object> map) {
        tblmedicaltypeMapper.upBoxcode(map);
        map.put("msg", "???????????????(???)??????");
        return KTool.codeToclient(map);
    }
    //???
    @Override
    public Map<String, Object> HandaddDate(Map<String, Object> map) {

        Object adminId = map.get("adminid");
        map.put("infraction", 0);
        map.put("warningisno", 0);
        tblmedicaltypeMapper.HandaddDate(map);
        map.put("infoid", tblmedicaltypeMapper.findSumtable(map));

        map.put("joinid",adminId);
        stockInMapper.addMedicalIn(map);
        map.put("msg", "??????????????????");

//         Tblboxcode ???????????????  ?????????
        map.put("bstate", 26);
        String boxidArry[] = {tblboxMapper.getIdbyBoxcode(map.get("boxcode").toString())};
        map.put("boxidArry", boxidArry);
        tblboxMapper.setstate(map);
        List<Tblbox> list = tblmedicaltypeMapper.selTblboxcode();
        map.put("list", list);

        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> DpartPonser(Map<String, Object> map) {
        List<ViewDepstaff> list = tblmedicaltypeMapper.DpartPonser(map);
        map.put("list", list);
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> collectList(Map<String, Object> map) {
        List<ViewDepstaff> list = tblmedicaltypeMapper.collectList(map);
        JSONObject.toJSONString(list+"123");
        map.put("list", list);
        return KTool.codeToclient(map);
    }

    // ??????
    @Override
    public List<Tblmedicaltype> outtimein(String nowtime) {
        return tblmedicaltypeMapper.outtimein(nowtime);
    }

    @Override
    public int warningstatus(int infoid) {
        return tblmedicaltypeMapper.warningstatus(infoid);
    }


    // ?????????
    @Override
    public Map getNumByType(Map<String, Object> map) {
        Date date = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowdate = sdf.format(date);

        map.put("dayList", day(nowdate));//???????????????
        System.out.println(JSONObject.toJSONString(day(nowdate))+"!!");
        map.put("nowdate", nowdate);//???????????????
        System.out.println(JSONObject.toJSONString(nowdate));
        map.put("monthList", month(nowdate));// ???????????????
        System.out.println(JSONObject.toJSONString(month(nowdate)));
        map.put("MonthStart", nowdate.substring(0, 7) + "-01");//???????????????
        System.out.println(JSONObject.toJSONString(nowdate.substring(0, 7) + "-01"));
        map.put("inOut15", inOut15(nowdate)); // ????????????

        int dayforweek = Integer.valueOf(KTool.weekMap(nowdate).get("dayForWeek").toString()); // ???????????????\

        String Monday = KTool.getNextDay(nowdate, -(dayforweek - 1)); // ????????????????????????

        map.put("collectWeight", getCollectWeight(nowdate, dayforweek, null)); // ??????????????????

        map.put("outWeight", getOutWeight(nowdate, dayforweek)); // ??????????????????

        map.put("Monday", Monday); // ??????????????????

        String timeArray[] = KTool.getDataToStrTime(nowdate);

        map.put("LineMap", getWeightByTypeShowLine(dayforweek, timeArray)); //??????????????????

        return KTool.codeToclient(map);
    }


    // ???????????????????????????
    @Override
    public Map<String, Object> table(Map<String, Object> map) {
        String timeStr = map.get("start").toString();
        if (!timeStr.equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long timel = (Long) map.get("start");
            Long time2 = (Long) map.get("end");
            String startdate = sdf.format(new Date(timel));
            String enddate = sdf.format(new Date(time2));
            map.put("startdate", startdate);
            map.put("enddate", enddate);    
        } else { // ?????????????????????????????????0???0???23???59
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            Date date2 = new Date();
            String startdate = sdf.format(date) + " 00:00:00";
            String enddate = sdf.format(date2) + " 23:59:59";
            map.put("startdate", startdate);
            map.put("enddate", enddate);
        }
        List<Viewmedicaltype> list = tblmedicaltypeMapper.table(map); //?????????????????????
        List<TrashTable> boxlist = tblmedicaltypeMapper.findbox(map); //??????????????????????????????
        List<TrashTable> boxlist2 = tblmedicaltypeMapper.findbox2(map); //????????????????????????
        List<TrashTable> baglist = tblmedicaltypeMapper.findbag(map); //????????????????????????
        List<TrashTable> placentalist = tblmedicaltypeMapper.findplacenta(map); //?????????????????????
        List<Viewmedicaltype> newlist = new ArrayList<>();
//        List<Map<String,Object>> listmap = new ArrayList<>();
        digui(list, newlist);
//        List<Tbltypeprint> tpList = trashTypeMapper.getNameId(); // ??????????????? ???????????????id
//
//        List<Tbldepartrment> dlist = personMapper.allDepartment(); // ????????????????????????
        List<TrashTable> ttlist = new ArrayList<>();
        for (int i = 0; i < newlist.size(); i++) {
            long did = newlist.get(i).getDid();
            long typeid2 = newlist.get(i).getTypeid();
            String dname = newlist.get(i).getDname();
            TrashTable tt = new TrashTable();
            Double totalweight = 0d;
            for (int j = 0; j < newlist.size(); j++) {
                if (did == newlist.get(j).getDid()) {
                    long typeid = newlist.get(j).getTypeid();
                    double weight = Double.parseDouble(newlist.get(j).getWeight());
                    String typename = newlist.get(j).getTname();
                    if (typeid == 1) {
                        tt.setType1(weight + "");
                        totalweight += weight;
                    } else if (typeid == 2) {
                        tt.setType2(weight + "");
                        totalweight += weight;
                    } else if (typeid == 3) {
                        tt.setType3(weight + "");
                        totalweight += weight;
                    } else if (typeid == 4) {
                        tt.setType4(weight + "");
                        totalweight += weight;
                    } else if (typeid == 5) {
                        tt.setType5(weight + "");
                        totalweight += weight;
                    } else if (typeid == 6) {
                        tt.setType6(weight + "");
                        totalweight += weight;
                    }
                }
            }
            tt.setTotalweight(totalweight + "");
            tt.setDname(dname);
            tt.setDid(did);
            tt.setTypeid(typeid2);
            tt.setSname(newlist.get(i).getSname());
            tt.setSname2(newlist.get(i).getSname2());
            ttlist.add(tt);
        }
        digui2(ttlist); // ????????????
        for (int i = 0; i < ttlist.size(); i++) {
            Double d1 = Double.parseDouble(isNull(ttlist.get(i).getType1()));
            Double d2 = Double.parseDouble(isNull(ttlist.get(i).getType2()));
            Double d3 = Double.parseDouble(isNull(ttlist.get(i).getType3()));
            Double d4 = Double.parseDouble(isNull(ttlist.get(i).getType4()));
            Double d5 = Double.parseDouble(isNull(ttlist.get(i).getType5()));
            Double d6 = Double.parseDouble(isNull(ttlist.get(i).getType6()));
            Double dt = Double.parseDouble(isNull(ttlist.get(i).getTotalweight()));
            for (int j = 0; j < ttlist.size(); j++) {
                if (i != j) {
                    d1 += Double.parseDouble(isNull(ttlist.get(j).getType1()));
                    d2 += Double.parseDouble(isNull(ttlist.get(j).getType2()));
                    d3 += Double.parseDouble(isNull(ttlist.get(j).getType3()));
                    d4 += Double.parseDouble(isNull(ttlist.get(j).getType4()));
                    d5 += Double.parseDouble(isNull(ttlist.get(j).getType5()));
                    d6 += Double.parseDouble(isNull(ttlist.get(j).getType6()));
                    dt += Double.parseDouble(isNull(ttlist.get(j).getTotalweight()));
                }
            }
            for (int j = 0; j < boxlist.size(); j++) {
                if (ttlist.get(i).getDid() == boxlist.get(j).getDid()) {
                    ttlist.get(i).setBoxnum(boxlist.get(j).getBoxnum());
                }
            }
            map.put("d1", d1);
            map.put("d2", d2);
            map.put("d3", d3);
            map.put("d4", d4);
            map.put("d5", d5);
            map.put("d6", d6);
            map.put("dt", dt);
        }
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list2.add("0");
            list3.add("0");
            list4.add("0");
        }
        for (int i = 0; i < boxlist2.size(); i++) {
            list2.set(((int) (boxlist2.get(i).getTypeid()) - 1), boxlist2.get(i).getBoxnum());
        }
        for (int i = 0; i < baglist.size(); i++) {
            list3.set(((int) (baglist.get(i).getTypeid()) - 1), baglist.get(i).getBagnum());
        }
        for (int i = 0; i < placentalist.size(); i++) {
            list4.set(((int) (placentalist.get(i).getTypeid()) - 1), placentalist.get(i).getPlacentanum());
        }
        int sum = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (int i = 0; i < list2.size(); i++) {
            sum += Integer.valueOf(list2.get(i));
            sum2 += Integer.valueOf(list3.get(i));
            sum3 += Integer.valueOf(list4.get(i));
        }
        list2.add(sum + "");
        list3.add(sum2 + "");
        list4.add(sum3 + "");
        map.put("boxlist", list2);
        map.put("baglist", list3);
        map.put("placentalist", list4);
        map.put("tableAry", ttlist);
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> findjiao(Map<String, Object> map) {
        String timeStr = map.get("start").toString();
        if (!timeStr.equals("")){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long timel = (Long) map.get("start");
            Long time2 = (Long) map.get("end");
            String startdate = sdf.format(new Date(timel));
            String enddate = sdf.format(new Date(time2));
            map.put("startdate",startdate);
            map.put("enddate",enddate);
        }
        Double sum = 0d;
        Double sum1 = 0d;
        Double sum2 = 0d;
        Double sum3 = 0d;
        Double sum4 = 0d;
        Double sum5 = 0d;
        Double sum6 = 0d;
        Double sum7 = 0d;
        Double sum8 = 0d;
        Double sum9 = 0d;
        Double sum10 = 0d;
        Double sum11 = 0d;

        List<TrashJiaoTable> list=tblmedicaltypeMapper.findjiao(map);
        for(int i=0;i<list.size();i++){
            sum += Double.parseDouble(isNull(list.get(i).getGanweight()));
            sum1 += Double.parseDouble(isNull(list.get(i).getGanbagNum()));
            sum2 += Double.parseDouble(isNull(list.get(i).getSunweight()));
            sum3 += Double.parseDouble(isNull(list.get(i).getSunbagNum()));
            sum4 += Double.parseDouble(isNull(list.get(i).getBingweight()));
            sum5 += Double.parseDouble(isNull(list.get(i).getBingagNum()));
            sum6 += Double.parseDouble(isNull(list.get(i).getHuaweight()));
            sum7 += Double.parseDouble(isNull(list.get(i).getHuabagNum()));
            sum8 += Double.parseDouble(isNull(list.get(i).getYaohweight()));
            sum9 += Double.parseDouble(isNull(list.get(i).getYaobagNum()));
            sum10 += Double.parseDouble(isNull(list.get(i).getShuweight()));
            sum11 += Double.parseDouble(isNull(list.get(i).getShubagNum()));
        }
        map.put("list",list);
        map.put("sum",sum);
        map.put("sum1",sum1);
        map.put("sum2",sum2);
        map.put("sum3",sum3);
        map.put("sum4",sum4);
        map.put("sum5",sum5);
        map.put("sum6",sum6);
        map.put("sum7",sum7);
        map.put("sum8",sum8);
        map.put("sum9",sum9);
        map.put("sum10",sum10);
        map.put("sum11",sum11);
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> hazardousWasteTable(Map<String, Object> map) {
        map.put("sunshang", 1);
        map.put("qita", null);
        List<HazardousWasteTable> list = getTablelist(map);//??????
        System.out.println("????????????");
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
        map.put("sunshang", null);
        map.put("qita", 1);
        List<HazardousWasteTable> otherlist = getTablelist(map); //??????????????????
        System.out.println("???????????????");
        for (int i=0;i<otherlist.size();i++){
            System.out.println(otherlist.get(i).toString());
        }
        for (int i = 0; i < list.size(); i++) { // ????????????????????????????????????????????????
            list.get(i).setOtherBags(otherlist.get(i).getBags());
            list.get(i).setOtherBoxs(otherlist.get(i).getBoxs());
            list.get(i).setOtherTotalweight(otherlist.get(i).getTotalweight());
        }
        map.put("tablelist", list);
        return KTool.codeToclient(map);
    }

    public List<HazardousWasteTable> getTablelist(Map<String,Object> map){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long time1 = (Long) map.get("start");
        Long time2 = (Long) map.get("end");
        String initStartdate = sdf.format(new Date(time1));
        String initEnddate = sdf.format(new Date(time2));
        map.put("startdate", initStartdate);
        map.put("enddate", initEnddate);
        List<HazardousWasteTable> list = new ArrayList<>();
        // ?????????????????? ?????????0???????????????????????????1
        int days = periodToString(time2 - time1);
        if (days == 0) {
            HazardousWasteTable hwt = tblmedicaltypeMapper.hazardousWasteTable(map);
            WasteTableInfo wti = wasteTableMapper.getWasteTableInfo(map);
            try {
                hwt.setCollectName(wti.getCollectName() == null ? "" : wti.getCollectName());
                hwt.setEnterName(wti.getEnterName() == null ? "" : wti.getEnterName());
                hwt.setInDate(wti.getInDate().substring(11, 16));
            } catch (Exception e) {
                hwt.setInDate(initEnddate.substring(11, 16));
                hwt.setStartdate(initEnddate.substring(8, 10));
            }
            list.add(hwt);
        }else {
            for (int i = 0; i <= days; i++) {
                String startdate="";
                String enddate="";
                if (i != days){
                    startdate = KTool.getDataToStr(KTool.getNextDay(initStartdate, i), 0);
                    enddate = KTool.getDataToStr(KTool.getNextDay(initStartdate, i), 1);
                }else{
                    startdate = KTool.getDataToStr(initEnddate.substring(0, 10), 0);
                    enddate = initEnddate;
                }
                map.put("startdate",startdate);
                map.put("enddate",enddate);
                HazardousWasteTable hwt = tblmedicaltypeMapper.hazardousWasteTable(map);
                WasteTableInfo wti = wasteTableMapper.getWasteTableInfo(map);
                if (wti != null) {
                    hwt.setCollectName(wti.getCollectName());
                    hwt.setEnterName(wti.getEnterName());
                    hwt.setInDate(wti.getInDate().substring(11, 16));
                }
                hwt.setStartdate(startdate.substring(8,10));
                hwt.setEnddate(enddate.substring(8,10));
                list.add(hwt);
            }
        }
        return list;
    }

    private int periodToString(Long millisecond) {
        int str = 0;
        long day = millisecond / 86400000;
        long hour = (millisecond % 86400000) / 3600000;
        long minute = (millisecond % 86400000 % 3600000) / 60000;
//        if (day > 0) {
        str = (int) day;
//        }
//        if (hour > 0) {
//            str += String.valueOf(hour) + "??????";
//        }
//        if (minute > 0) {
//            str += String.valueOf(minute) + "??????";
//        }
        return str;
    }






    public String isNull(String str){
        if (str==null || str.equals("")){
            return "0";
        }
        return str;
    }
    // ???????????????
    public void digui2(List<TrashTable> ttlist){
        for (int i = 0; i < ttlist.size(); i++) {
            ttlist.get(i).getDname(); // ????????????
            for (int j = 0; j < ttlist.size(); j++) {
                if (ttlist.get(i).getDname().equals(ttlist.get(j).getDname()) && i!=j){ // ??????????????????
                    if (Double.parseDouble(ttlist.get(i).getTotalweight()) > Double.parseDouble(ttlist.get(j).getTotalweight()) ){
                        ttlist.remove(j);
                        digui2(ttlist);
                        return;
                    }else{
                        ttlist.remove(i);
                        digui2(ttlist);
                        return;
                    }
                }
            }
        }
    }
    public void digui(List<Viewmedicaltype> list,List<Viewmedicaltype> newlist){
        for (int i = 0; i < list.size(); i++) {
            long did1 = list.get(i).getDid(); // ??????id
            long typeid1 = list.get(i).getTypeid(); //????????????id
            String tname = list.get(i).getTname();// ??????????????????
            String sname = list.get(i).getSname();// ?????????
            String sname2 = list.get(i).getSname2(); //?????????
            String dname = list.get(i).getDname(); //????????????
            double weight = 0;
            for (int j = 0; j < list.size(); j++) {
                long did2 = list.get(j).getDid(); // ??????id
                long typeid2 = list.get(j).getTypeid(); //????????????id
                if (did1 == did2 && typeid1 == typeid2) {
                    weight += Double.parseDouble(list.get(j).getWeight());
                    list.remove(j--);
                }
            }
            Viewmedicaltype mt = new Viewmedicaltype();
            mt.setWeight(weight+"");
            mt.setTname(tname);
            mt.setSname(sname);
            mt.setSname2(sname2);
            mt.setDid(did1);
            mt.setTypeid(typeid1);
            mt.setDname(dname);
            newlist.add(mt);
            if (list.size() > 0) {
                digui(list, newlist);
                return;
            }
        }
    }



    // ????????? ???????????????

    public Map<String,Object> getWeightByTypeShowLine(int dayforweek,String[] timeArray) {
        List<Map<String,Object>> listMap = new ArrayList<>();
        List<Tbltypeprint> tpList = trashTypeMapper.getNameId();
        String nameStr = "";
        for (Tbltypeprint tp: tpList){ // ???????????????  ???????????? ???????????????id
            Map<String,Object> map = new HashMap<>();
            map.put("name",tp.getTname());
            map.put("type","line");
            map.put("stack","Total");
            map.put("data",getCollectWeightDay(tp.getTid()+"",timeArray));
            listMap.add(map);
            nameStr += tp.getTname() + "-";
        }

        String nameArray[] =nameStr.split("-");
        Map<String,Object> LineMap = new HashMap<>();
        LineMap.put("nameArray",nameArray);
        LineMap.put("list",listMap);
        String timeStr = "";
        for (int i = 0; i < timeArray.length; i += 2) {
            timeStr += timeArray[i].substring(11) + "&";
        }
        String timeArray2[] = timeStr.split("&");
        LineMap.put("timeArray",timeArray2);
        return LineMap;
    }
    // ????????????
    public String[] getCollectWeightDay(String typeid,String[] timeArray) { // ????????????????????????
        Map<String,Object> map = new HashMap<>();
        String sumWeight = "";
        for (int i = 0; i < timeArray.length; i+=2) {
            String startTime = timeArray[i]; //??????????????????
            String endTime = timeArray[i+1]; //??????????????????
            map.put("startTime",startTime);
            map.put("endTime",endTime);
            map.put("typeid", typeid);
            String Weight = tblmedicaltypeMapper.collectWeightSUM(map);
            if(Weight==null){
                Weight = "0";
            }
            System.out.println("?????????Weight="+Weight);
            Double d = Double.parseDouble(Weight);
            DecimalFormat df = new DecimalFormat("0.00");
            sumWeight += df.format(d) + "-";
        }
        return sumWeight.split("-");
    }


    // ????????????
    public String[] getCollectWeight(String nowdate,int dayforweek,String typeid) { // ????????????????????????
        Map<String,Object> map = new HashMap<>();
        String sumWeight = "";
        for(int i = (dayforweek-1);i>=0;i--){
            String day = KTool.getNextDay(nowdate,-i);
            int a =Integer.valueOf( KTool.weekMap(day).get("dayForWeek").toString());
            String startTime = KTool.getDataToStr(day,0); //?????????????????????
            String endTime = KTool.getDataToStr(day,1); //?????????????????????
            map.put("startTime",startTime);
            map.put("endTime",endTime);
            map.put("typeid", typeid);
            String Weight = tblmedicaltypeMapper.collectWeightSUM(map);
            if(Weight==null){
                Weight = "0";
            }
            System.out.println("?????????Weight="+Weight);
            Double d = Double.parseDouble(Weight);
            DecimalFormat df = new DecimalFormat("0.00");
            sumWeight += df.format(d) + "-";
        }

        return sumWeight.split("-");
    }
    // ????????????
    public String[] getOutWeight(String nowdate,int dayforweek) { // ????????????????????????
        Map<String,Object> map = new HashMap<>();
        String sumWeight = "";
        for(int i = (dayforweek-1);i>=0;i--){
            String day = KTool.getNextDay(nowdate,-i);
            int a =Integer.valueOf( KTool.weekMap(day).get("dayForWeek").toString());

            String startTime = KTool.getDataToStr(day,0); //?????????????????????
            String endTime = KTool.getDataToStr(day,1); //?????????????????????
            map.put("startTime",startTime);
            map.put("endTime",endTime);

            String Weight = tblmedicaltypeMapper.outWeightSUM(map);
            if(Weight==null){
                Weight = "0";
            }
            System.out.println("?????????Weight="+Weight);
            Double d = Double.parseDouble(Weight);

            DecimalFormat df = new DecimalFormat("0.00");
            sumWeight += df.format(d) + "-";
        }

        return sumWeight.split("-");
    }
//    // ????????????????????????
    public String[] inOut15(String nowdate){
        String day15before = KTool.getNextDay(nowdate,-15);
        System.out.println("???????????????????????????"+day15before);
        Map<String,Object> map = new HashMap<>();
        String inOutStr = "";
        for (int i = 14; i >= 0; i--) { // ?????????????????????
            String dayBefore = KTool.getNextDay(nowdate,-i);
            String startTime = KTool.getDataToStr(dayBefore,0);
            String endTime = KTool.getDataToStr(dayBefore,1);
            //?????? ???????????? ??? ???????????? ????????????????????? ?????? ??????
            map.put("startTime",startTime);
            map.put("endTime",endTime);
            map.put("typeid",null); // ?????????????????????????????????
            inOutStr+=tblmedicaltypeMapper.getNumByType(map)+"-";
        }
        return inOutStr.split("-");
    }


    // ?????????
    public List<Map<String,Object>> month(String nowdate){
        String MonthStart = nowdate.substring(0,7)+"-01";
        String startTime = KTool.getDataToStr(MonthStart,0);
        String endTime = KTool.getDataToStr(nowdate,1);
        return day_month(startTime,endTime);
    }

    public List<Map<String,Object>> day(String nowdate){
        String startTime = KTool.getDataToStr(nowdate,0);
        String endTime = KTool.getDataToStr(nowdate,1);
        return day_month(startTime,endTime);
    }


    // ??? ??? ??????
    public List<Map<String,Object>> day_month(String startTime,String endTime){
        Map<String,Object> map = new HashMap<>();
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        List<Map<String,Object>> list = new ArrayList<>();
        List<Tbltypeprint> tpList = trashTypeMapper.getNameId();
        for (Tbltypeprint tp: tpList){ // ???????????????  ???????????? ???????????????id
            map.put("typeid",tp.getTid());
            map.put("name",tp.getTname());
            list.add(getName_value(map)); // ??????????????????????????????list
        }
        return list;
    }
    //???????????????????????????
    public Map<String,Object> getName_value(Map<String,Object> map){
        Map<String,Object> mapName_value = new HashMap<>();
            // ??????????????????????????????????????????tbltypeprint??????id ????????????
        mapName_value.put("value", tblmedicaltypeMapper.getNumByType(map));
        //??????name???
        mapName_value.put("name", map.get("name"));
        return mapName_value;
    }

    @Override
    public Map<String, Object> kstable(Map<String, Object> map) {
        String timeStr = map.get("start").toString();
        if (!timeStr.equals("")){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long timel = (Long) map.get("start");
            Long time2 = (Long) map.get("end");
            String startdate = sdf.format(new Date(timel));
            String enddate = sdf.format(new Date(time2));
            map.put("startdate",startdate);
            map.put("enddate",enddate);
        }

        List<tbldemo> list  =  tblmedicaltypeMapper.kstable(map);
        System.out.println("????????????"+list);
        map.put("code",1);
        map.put("tableAry",list);
        return map;
    }
}