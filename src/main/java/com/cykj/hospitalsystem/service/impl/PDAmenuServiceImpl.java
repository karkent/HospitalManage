package com.cykj.hospitalsystem.service.impl;

import com.cykj.hospitalsystem.bean.Routes;
import com.cykj.hospitalsystem.bean.TblPdAmenu;
import com.cykj.hospitalsystem.mapper.PDAmenuMapper;
import com.cykj.hospitalsystem.mapper.PDAroleMapper;
import com.cykj.hospitalsystem.service.PDAmenuService;
import com.cykj.hospitalsystem.until.KTool;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PDAmenuServiceImpl implements PDAmenuService {
    @Autowired
    private PDAmenuMapper pdAmenuMapper;
    @Autowired
    private PDAroleMapper pdAroleMapper;
    @Override
    public Map<String, Object> authorityMenuPDA(Map<String, Object> map) {

        List<TblPdAmenu> pdaList = pdAmenuMapper.authorityMenuPDA(map);
        List<TblPdAmenu> list = diguiTree(pdaList,0);
        if (map.get("nowPage") == null){
            map.put("PDAlist",list);
        }else {
            int nowPage = Integer.valueOf(map.get("nowPage").toString());
            int pageSize = Integer.valueOf(map.get("pageSize").toString());
            List<TblPdAmenu> listPage = new ArrayList<>();
            for (int i = nowPage; i < list.size() && i < pageSize; i++) {
                listPage.add(list.get(i));
            }
            map.put("PDAlist",listPage);
            map.put("totalCum",list.size());
        }
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> SelectAuthorityPDA(Map<String, Object> map) {
        System.out.println("收到roleid11"+map.get("roleid"));
        pdAroleMapper.delAllbyRoleid(map);
        //根据前端发来的菜单id的数组，查数据库拿到对应的菜单实体类集合。

        String listTree[]  = (String[]) map.get("treeArray");
        if (listTree.length > 0) {
            map.put("mstate",2);
            map.put("label",null);
            List<TblPdAmenu> pdaList = pdAmenuMapper.authorityMenuPDA(map);
            String str = "";
            for (int i = 0; i < listTree.length; i++) {
                str += getPdaPid(pdaList, listTree[i],str);
            }
            String treeArray[] = str.split("-");
            for (int i = 0; i < treeArray.length; i++) {
                System.out.println("数组下表"+i+"内容"+treeArray[i]);
            }
            Stream<String> stream = Arrays.stream(treeArray);
            List<String> Strlist = stream.distinct().collect(Collectors.toList());
            //去重后的listStr
            for (String strlist:Strlist){
                System.out.println("元素"+strlist);
            }
            map.put("treeArray",Strlist);
            List<TblPdAmenu> list = pdAmenuMapper.getPDAidByArrayId(map);
            if (list.size() > 0) {
                map.put("PDAList", list);
                pdAroleMapper.addNewData(map);
            }
            map.put("msg","分配成功");
        }
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> getPDAId(Map<String, Object> map) {
        List<TblPdAmenu> list = pdAmenuMapper.getPDAId(map);
        for (int i = 0; i < list.size(); i++) {
            getPDAArray(list, list.get(i).getMpid());
        }
        String PDAStr = "";
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getMenuid()!=-1){
                PDAStr+=list.get(i).getMenuid()+"-";
            }
        }
        String PDAStrArray[] = PDAStr.split("-");
        map.put("PDAStrArray", PDAStrArray);
        return KTool.codeToclient(map);
    }

    // 前端发来的树形数组id，每个id找到他的所有父级
    public String getPdaPid(@NotNull List<TblPdAmenu> list, String treeObj, String str){
        str = treeObj + "-";
        for (TblPdAmenu pda : list) {
            if (pda.getMenuid() == Integer.parseInt(treeObj.trim()) && pda.getMpid() != 0) {
                str += pda.getMpid() + "-";
                str += getPdaPid(list, (pda.getMpid()+"").trim(), str);//寻找父级的父级
            }
        }
        return str;
    }
    @Override
    public Map setPDAmenuState(Map<String, Object> map) {
        pdAmenuMapper.setPDAmenuState(map);
        String msg = "";
        switch (map.get("mstate").toString()){
            case "2":
                msg = "启用";
                break;
            case "3":
                msg = "禁用";
                break;
            case "4":
                msg = "作废";
                break;
        }
        map.put("msg","批量"+msg+"成功!");
        return KTool.codeToclient(map);
    }

    @Override
    public Map setPDAmenuData(Map<String, Object> map) {
        pdAmenuMapper.setPDAmenuData(map);
        map.put("msg", "修改成功");
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> addPDAmenu(Map<String, Object> map) {
        System.out.println("menuValue:----------" + map.get("mpid"));
        System.out.println(map.get("mpid")+"集合");

        map.put("mpid",map.get("mpid"));
        map.put("mstate",2);
        map.put("label",map.get("label"));
        map.put("url",map.get("url"));

        pdAmenuMapper.addPDAmenu(map);
        map.put("msg","增加成功");
        return KTool.codeToclient(map);
    }


    public void getPDAArray(List<TblPdAmenu> list, int ParentId) {
        for (int i = 0; i < list.size(); i++) {
            int rid = list.get(i).getMenuid(); // 获取id
            int pid = list.get(i).getMpid(); // 获取它的父级id
            if (ParentId == rid) {
                list.get(i).setMenuid(-1); //并将这个父级的菜单id，设置一个标识为为-1
                getPDAArray(list, pid); //递归继续寻找父级的父级。
            }
        }
    }


    public List<TblPdAmenu> diguiTree(List<TblPdAmenu> PDAs, int parentId) {
        List<TblPdAmenu> childrens = new ArrayList<>();
        for (int i = 0; i < PDAs.size(); i++) {
            int pid = PDAs.get(i).getMpid(); // 获取当前 tree的父级id
            int id = PDAs.get(i).getMenuid(); // 获取当前 tree的id
            if (pid == parentId) { // 判断当前这个子id属于谁
                TblPdAmenu pda = PDAs.get(i);
                pda.setChildren(diguiTree(PDAs, id));
                childrens.add(pda);
            }
        }
        return childrens;
    }
}
