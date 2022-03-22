package com.cykj.hospitalsystem.until;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import javax.lang.model.util.ElementScanner6;
import java.lang.annotation.ElementType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KTool {
    // 判断字符串是否是纯数字
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;

        }
        return true;
    }

    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    //以下两个方法判断字符串是否是纯中文
    public static boolean checkNameChese(String name) {
        boolean res = true;
        char[] cTemp = name.toCharArray();
        for (int i = 0; i < name.length(); i++) {
            if (!isChinese(cTemp[i])) {
                res = false;
                break;
            }
        }
        return res;
    }
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    //汉字转为拼音
    public static String toPinyin(String chinese){
        String pinyinStr = "";
        char[] newChar = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < newChar.length; i++) {
            if (newChar[i] > 128) {
                try {
                    pinyinStr += PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat)[0];
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            }else{
                pinyinStr += newChar[i];
            }
        }
        return pinyinStr;
    }
    public static String dataid18tonull(Object dataid){
        if(dataid !=null){
            if(dataid.toString().trim().equals("18")){
                return "";
            }else {
                return dataid.toString().trim();
            }
        }else {
            return "";
        }
    }

    public static Map<String,Object> codeToclient(Map<String,Object> map){
        map.put("code",1);
        return map;
    }
    // 新增拼音的方法
    public static boolean ispinyin(String str) {
        Pattern p = Pattern.compile("^[A-Za-z]+$");
        Matcher m = p.matcher(str);
        boolean isValid = m.matches();
        return isValid;
    }

    //日期对比在数据库里只需要用string
    public static String getDataToStr(String dataStr,int i){
        //返回 null 是为了后台 模糊查询，跳过日期选项
        if(dataStr==null){
            return null;
        }
        if(i==0){
            dataStr = dataStr+" 00:00:00";
        }else if(i==1){
            dataStr = dataStr+" 23:59:59";
        }
        return dataStr;
    }

    // 获取n天前或n天后的日期
    public static String getNextDay(String nowDay,int nextDay){
        Calendar calendar =new GregorianCalendar();//获取日历对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//格式

        Date date=new Date();
        try {
            date=sdf.parse(nowDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        calendar.add(calendar.DATE,nextDay);//获取n天前或n天后的日期
        String nextDayStr=sdf.format(calendar.getTime());
        return nextDayStr;
    }

    public static Map weekMap(String dateTime) {//传过来日期字符串
        Map weekMap = new HashMap();
        int weekNum = 0;
        int yearNum = 0;
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//格式
        try {
            date = format.parse(dateTime);//将这个格式的日期字符串转为Date对象
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance(); //使用默认时区和语言环境获得一个日历。
        calendar.setFirstDayOfWeek(Calendar.MONDAY);//返回周几
        calendar.setTime(date);//将传参过来的date对象设置到calendar属性中

        int dayForWeek = 0;//获得周几
        if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {//星期几的数组从1开始，1代表星期天
            dayForWeek = 7;
        } else {
            dayForWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        }
        weekNum = calendar.get(Calendar.WEEK_OF_YEAR);//获取本年第几周
        yearNum = calendar.get(Calendar.YEAR);//获取年份
        weekMap.put("dayForWeek", dayForWeek);
        weekMap.put("weekNum", weekNum);
        weekMap.put("dateTime", dateTime);
        System.out.println("日期时间[" + dateTime + "]年份为[" + yearNum + "]为周" + dayForWeek + "，今年的第" + weekNum + "周");
        return weekMap;
    }


    //日期对比在数据库里只需要用string
    public static String[] getDataToStrTime(String dataStr){
        //返回 null 是为了后台 模糊查询，跳过日期选项
        if(dataStr==null){
            return null;
        }
        String date = "";
        for (int i =0;i<24;i++){
            String iStr = "";
            if (i < 10) {
                iStr = "0" + i + ":";
            } else {
                iStr = i + ":";
            }
            String time1 = dataStr +" "+ iStr + "00:00";
            String time2 = dataStr +" "+ iStr + "59:59";
            date += time1 + "&" + time2 + "&";
        }
        return date.split("&");
    }

    public static String getPinyin(String china){
        HanyuPinyinOutputFormat formart = new HanyuPinyinOutputFormat();
        formart.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        formart.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        formart.setVCharType(HanyuPinyinVCharType.WITH_V);
        char[] arrays = china.trim().toCharArray();
        String result = "";
        try {
            for (int i=0;i<arrays.length;i++) {
                char ti = arrays[i];
                if(Character.toString(ti).matches("[\\u4e00-\\u9fa5]")){ //匹配是否是中文
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(ti,formart);
                    result += temp[0];
                }else{
                    result += ti;
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return result;
    }


}
