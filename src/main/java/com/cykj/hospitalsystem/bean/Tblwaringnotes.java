package com.cykj.hospitalsystem.bean;


import javax.lang.model.element.NestingKind;

public class Tblwaringnotes {

    private long noteid;
    private long handlestate;
    private long warningtype;
    private long warninglink;
    private String bagcode;
    private long kid;
    private String wcase;
    private String wtime;
    private long handleman;
    private String handleidea;
    private String handletime;
    private long hid;
    private String spare1;
    private String spare2;

    private String hname;
    private String dname;
    private String sname;

    // 关联映射 增加的属性
    private Tbldepartrment departrment;
    private Tbldata tbldata;
    private Tblhospitalinfo hospital;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Tbldepartrment getDepartrment() {
        return departrment;
    }

    public void setDepartrment(Tbldepartrment departrment) {
        this.departrment = departrment;
    }

    public Tbldata getTbldata() {
        return tbldata;
    }

    public void setTbldata(Tbldata tbldata) {
        this.tbldata = tbldata;
    }

    public Tblhospitalinfo getHospital() {
        return hospital;
    }

    public void setHospital(Tblhospitalinfo hospital) {
        this.hospital = hospital;
    }

    public Tblwaringnotes(int handlestate, int warningtype, int warninglink, String bagcode, int kid, String wcase, String wtime,long hid) {
        this.bagcode = bagcode;
        this.handlestate = handlestate;
        this.warningtype = warningtype;
        this.warninglink = warninglink;
        this.kid = kid;
        this.wcase = wcase;
        this.wtime = wtime;
        this.hid = hid;
    }
    public Tblwaringnotes () {

    }


    public long getNoteid() {
        return noteid;
    }

    public void setNoteid(long noteid) {
        this.noteid = noteid;
    }


    public long getHandlestate() {
        return handlestate;
    }

    public void setHandlestate(long handlestate) {
        this.handlestate = handlestate;
    }


    public long getWarningtype() {
        return warningtype;
    }

    public void setWarningtype(long warningtype) {
        this.warningtype = warningtype;
    }


    public long getWarninglink() {
        return warninglink;
    }

    public void setWarninglink(long warninglink) {
        this.warninglink = warninglink;
    }


    public String getBagcode() {
        return bagcode;
    }

    public void setBagcode(String bagcode) {
        this.bagcode = bagcode;
    }


    public long getKid() {
        return kid;
    }

    public void setKid(long kid) {
        this.kid = kid;
    }


    public String getWcase() {
        return wcase;
    }

    public void setWcase(String wcase) {
        this.wcase = wcase;
    }


    public String getWtime() {
        return wtime;
    }

    public void setWtime(String wtime) {
        this.wtime = wtime;
    }


    public long getHandleman() {
        return handleman;
    }

    public void setHandleman(long handleman) {
        this.handleman = handleman;
    }


    public String getHandleidea() {
        return handleidea;
    }

    public void setHandleidea(String handleidea) {
        this.handleidea = handleidea;
    }


    public String getHandletime() {
        return handletime;
    }

    public void setHandletime(String handletime) {
        this.handletime = handletime;
    }


    public long getHid() {
        return hid;
    }

    public void setHid(long hid) {
        this.hid = hid;
    }


    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1;
    }


    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2;
    }

}
/**

 {"WarningList":[
 {"noteid":97,"handlestate":0,"warningtype":0,"warninglink":0,"bagcode":null,"kid":0,"wcase":null,"wtime":null,"handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,
 "departrment":{"did":0,"kid":0,"dname":"后勤保障科","dcode":null,"dspell":null,"depidemic":null,"dprintnum":0,"dplacenta":null,"pwarning":0,"collecmode":null,"ordernum":0,"dfloornum":null,"dfloor":null,"droomNum":null,"dproduce":null,"insterdate":null,"updatadate":null,"spare1":null,"spare2":null,"dincode":null,"tbldata":null,"tblkname":null,"dstate":null,"kname":null,"knum":null,"label":null,"children":null},
 "tbldata":
 {"dataid":0,"pid":null,"dataname":"出库超时预警","dremarks":null,"dstate":0,"value":0,"label":null,"children":null},
 "hospital":{"hid":0,"hname":"儿童医院","huscc":null,"hbusiness":null,"haddress":null,"hstate":0,"hwarrantdate":null,"hlevel":null,"hequalorder":null,"hlegal":null,"hlegalcard":null,"hofficephone":null,"hmobilephone":null,"hcantoncode":null,"hinsterdate":null,"hupdatadate":null,"hspare1":null,"hspare2":null,"tbldata":null}},
 {"noteid":96,"handlestate":0,"warningtype":0,"warninglink":0,"bagcode":null,"kid":0,"wcase":null,"wtime":null,"handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":{"did":0,"kid":0,"dname":"后勤保障科","dcode":null,"dspell":null,"depidemic":null,"dprintnum":0,"dplacenta":null,"pwarning":0,"collecmode":null,"ordernum":0,"dfloornum":null,"dfloor":null,"droomNum":null,"dproduce":null,"insterdate":null,"updatadate":null,"spare1":null,"spare2":null,"dincode":null,"tbldata":null,"tblkname":null,"dstate":null,"kname":null,"knum":null,"label":null,"children":null},"tbldata":{"dataid":0,"pid":null,"dataname":"出库超时预警","dremarks":null,"dstate":0,"value":0,"label":null,"children":null},"hospital":{"hid":0,"hname":"儿童医院","huscc":null,"hbusiness":null,"haddress":null,"hstate":0,"hwarrantdate":null,"hlevel":null,"hequalorder":null,"hlegal":null,"hlegalcard":null,"hofficephone":null,"hmobilephone":null,"hcantoncode":null,"hinsterdate":null,"hupdatadate":null,"hspare1":null,"hspare2":null,"tbldata":null}},{"noteid":95,"handlestate":0,"warningtype":0,"warninglink":0,"bagcode":null,"kid":0,"wcase":null,"wtime":null,"handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":{"did":0,"kid":0,"dname":"后勤保障科","dcode":null,"dspell":null,"depidemic":null,"dprintnum":0,"dplacenta":null,"pwarning":0,"collecmode":null,"ordernum":0,"dfloornum":null,"dfloor":null,"droomNum":null,"dproduce":null,"insterdate":null,"updatadate":null,"spare1":null,"spare2":null,"dincode":null,"tbldata":null,"tblkname":null,"dstate":null,"kname":null,"knum":null,"label":null,"children":null},"tbldata":{"dataid":0,"pid":null,"dataname":"重量异常预警","dremarks":null,"dstate":0,"value":0,"label":null,"children":null},"hospital":{"hid":0,"hname":"儿童医院","huscc":null,"hbusiness":null,"haddress":null,"hstate":0,"hwarrantdate":null,"hlevel":null,"hequalorder":null,"hlegal":null,"hlegalcard":null,"hofficephone":null,"hmobilephone":null,"hcantoncode":null,"hinsterdate":null,"hupdatadate":null,"hspare1":null,"hspare2":null,"tbldata":null}},{"noteid":70,"handlestate":0,"warningtype":0,"warninglink":0,"bagcode":null,"kid":0,"wcase":null,"wtime":null,"handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":{"did":0,"kid":0,"dname":"骨科诊室","dcode":null,"dspell":null,"depidemic":null,"dprintnum":0,"dplacenta":null,"pwarning":0,"collecmode":null,"ordernum":0,"dfloornum":null,"dfloor":null,"droomNum":null,"dproduce":null,"insterdate":null,"updatadate":null,"spare1":null,"spare2":null,"dincode":null,"tbldata":null,"tblkname":null,"dstate":null,"kname":null,"knum":null,"label":null,"children":null},"tbldata":{"dataid":0,"pid":null,"dataname":"重量异常预警","dremarks":null,"dstate":0,"value":0,"label":null,"children":null},"hospital":{"hid":0,"hname":"儿童医院","huscc":null,"hbusiness":null,"haddress":null,"hstate":0,"hwarrantdate":null,"hlevel":null,"hequalorder":null,"hlegal":null,"hlegalcard":null,"hofficephone":null,"hmobilephone":null,"hcantoncode":null,"hinsterdate":null,"hupdatadate":null,"hspare1":null,"hspare2":null,"tbldata":null}},{"noteid":69,"handlestate":0,"warningtype":0,"warninglink":0,"bagcode":null,"kid":0,"wcase":null,"wtime":null,"handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":{"did":0,"kid":0,"dname":"骨科诊室","dcode":null,"dspell":null,"depidemic":null,"dprintnum":0,"dplacenta":null,"pwarning":0,"collecmode":null,"ordernum":0,"dfloornum":null,"dfloor":null,"droomNum":null,"dproduce":null,"insterdate":null,"updatadate":null,"spare1":null,"spare2":null,"dincode":null,"tbldata":null,"tblkname":null,"dstate":null,"kname":null,"knum":null,"label":null,"children":null},"tbldata":{"dataid":0,"pid":null,"dataname":"重量异常预警","dremarks":null,"dstate":0,"value":0,"label":null,"children":null},"hospital":{"hid":0,"hname":"儿童医院","huscc":null,"hbusiness":null,"haddress":null,"hstate":0,"hwarrantdate":null,"hlevel":null,"hequalorder":null,"hlegal":null,"hlegalcard":null,"hofficephone":null,"hmobilephone":null,"hcantoncode":null,"hinsterdate":null,"hupdatadate":null,"hspare1":null,"hspare2":null,"tbldata":null}},{"noteid":68,"handlestate":0,"warningtype":0,"warninglink":0,"bagcode":null,"kid":0,"wcase":null,"wtime":null,"handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":{"did":0,"kid":0,"dname":"骨科诊室","dcode":null,"dspell":null,"depidemic":null,"dprintnum":0,"dplacenta":null,"pwarning":0,"collecmode":null,"ordernum":0,"dfloornum":null,"dfloor":null,"droomNum":null,"dproduce":null,"insterdate":null,"updatadate":null,"spare1":null,"spare2":null,"dincode":null,"tbldata":null,"tblkname":null,"dstate":null,"kname":null,"knum":null,"label":null,"children":null},"tbldata":{"dataid":0,"pid":null,"dataname":"重量异常预警","dremarks":null,"dstate":0,"value":0,"label":null,"children":null},"hospital":{"hid":0,"hname":"儿童医院","huscc":null,"hbusiness":null,"haddress":null,"hstate":0,"hwarrantdate":null,"hlevel":null,"hequalorder":null,"hlegal":null,"hlegalcard":null,"hofficephone":null,"hmobilephone":null,"hcantoncode":null,"hinsterdate":null,"hupdatadate":null,"hspare1":null,"hspare2":null,"tbldata":null}},{"noteid":67,"handlestate":0,"warningtype":0,"warninglink":0,"bagcode":null,"kid":0,"wcase":null,"wtime":null,"handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":{"did":0,"kid":0,"dname":"骨科","dcode":null,"dspell":null,"depidemic":null,"dprintnum":0,"dplacenta":null,"pwarning":0,"collecmode":null,"ordernum":0,"dfloornum":null,"dfloor":null,"droomNum":null,"dproduce":null,"insterdate":null,"updatadate":null,"spare1":null,"spare2":null,"dincode":null,"tbldata":null,"tblkname":null,"dstate":null,"kname":null,"knum":null,"label":null,"children":null},"tbldata":{"dataid":0,"pid":null,"dataname":"重量异常预警","dremarks":null,"dstate":0,"value":0,"label":null,"children":null},"hospital":{"hid":0,"hname":"儿童医院北区","huscc":null,"hbusiness":null,"haddress":null,"hstate":0,"hwarrantdate":null,"hlevel":null,"hequalorder":null,"hlegal":null,"hlegalcard":null,"hofficephone":null,"hmobilephone":null,"hcantoncode":null,"hinsterdate":null,"hupdatadate":null,"hspare1":null,"hspare2":null,"tbldata":null}},{"noteid":66,"handlestate":0,"warningtype":0,"warninglink":0,"bagcode":null,"kid":0,"wcase":null,"wtime":null,"handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":{"did":0,"kid":0,"dname":"内镜科","dcode":null,"dspell":null,"depidemic":null,"dprintnum":0,"dplacenta":null,"pwarning":0,"collecmode":null,"ordernum":0,"dfloornum":null,"dfloor":null,"droomNum":null,"dproduce":null,"insterdate":null,"updatadate":null,"spare1":null,"spare2":null,"dincode":null,"tbldata":null,"tblkname":null,"dstate":null,"kname":null,"knum":null,"label":null,"children":null},"tbldata":{"dataid":0,"pid":null,"dataname":"重量异常预警","dremarks":null,"dstate":0,"value":0,"label":null,"children":null},"hospital":{"hid":0,"hname":"儿童医院","huscc":null,"hbusiness":null,"haddress":null,"hstate":0,"hwarrantdate":null,"hlevel":null,"hequalorder":null,"hlegal":null,"hlegalcard":null,"hofficephone":null,"hmobilephone":null,"hcantoncode":null,"hinsterdate":null,"hupdatadate":null,"hspare1":null,"hspare2":null,"tbldata":null}},{"noteid":65,"handlestate":0,"warningtype":0,"warninglink":0,"bagcode":null,"kid":0,"wcase":null,"wtime":null,"handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":{"did":0,"kid":0,"dname":"内镜科","dcode":null,"dspell":null,"depidemic":null,"dprintnum":0,"dplacenta":null,"pwarning":0,"collecmode":null,"ordernum":0,"dfloornum":null,"dfloor":null,"droomNum":null,"dproduce":null,"insterdate":null,"updatadate":null,"spare1":null,"spare2":null,"dincode":null,"tbldata":null,"tblkname":null,"dstate":null,"kname":null,"knum":null,"label":null,"children":null},"tbldata":{"dataid":0,"pid":null,"dataname":"重量异常预警","dremarks":null,"dstate":0,"value":0,"label":null,"children":null},"hospital":{"hid":0,"hname":"儿童医院","huscc":null,"hbusiness":null,"haddress":null,"hstate":0,"hwarrantdate":null,"hlevel":null,"hequalorder":null,"hlegal":null,"hlegalcard":null,"hofficephone":null,"hmobilephone":null,"hcantoncode":null,"hinsterdate":null,"hupdatadate":null,"hspare1":null,"hspare2":null,"tbldata":null}},{"noteid":64,"handlestate":0,"warningtype":0,"warninglink":0,"bagcode":null,"kid":0,"wcase":null,"wtime":null,"handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":{"did":0,"kid":0,"dname":"内镜科","dcode":null,"dspell":null,"depidemic":null,"dprintnum":0,"dplacenta":null,"pwarning":0,"collecmode":null,"ordernum":0,"dfloornum":null,"dfloor":null,"droomNum":null,"dproduce":null,"insterdate":null,"updatadate":null,"spare1":null,"spare2":null,"dincode":null,"tbldata":null,"tblkname":null,"dstate":null,"kname":null,"knum":null,"label":null,"children":null},"tbldata":{"dataid":0,"pid":null,"dataname":"重量异常预警","dremarks":null,"dstate":0,"value":0,"label":null,"children":null},"hospital":{"hid":0,"hname":"儿童医院","huscc":null,"hbusiness":null,"haddress":null,"hstate":0,"hwarrantdate":null,"hlevel":null,"hequalorder":null,"hlegal":null,"hlegalcard":null,"hofficephone":null,"hmobilephone":null,"hcantoncode":null,"hinsterdate":null,"hupdatadate":null,"hspare1":null,"hspare2":null,"tbldata":null}}],"code":1,"count":18}

 {"code":1,"hospitalList":[
 {"hid":41,"hname":"儿童医院","huscc":null,"hbusiness":null,"haddress":null,"hstate":0,"hwarrantdate":null,"hlevel":null,"hequalorder":null,"hlegal":null,"hlegalcard":null,"hofficephone":null,"hmobilephone":null,"hcantoncode":null,"hinsterdate":null,"hupdatadate":null,"hspare1":null,"hspare2":null,"tbldata":null},
 {"hid":42,"hname":"儿童医院北区","huscc":null,"hbusiness":null,"haddress":null,"hstate":0,"hwarrantdate":null,"hlevel":null,"hequalorder":null,"hlegal":null,"hlegalcard":null,"hofficephone":null,"hmobilephone":null,"hcantoncode":null,"hinsterdate":null,"hupdatadate":null,"hspare1":null,"hspare2":null,"tbldata":null}]}

 {"WarningList":[
 {"noteid":97,"handlestate":0,"warningtype":0,"warninglink":35,"bagcode":null,"kid":0,"wcase":"出库超时异常","wtime":null,"handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":null,"tbldata":null,"hospital":null},
 {"noteid":96,"handlestate":0,"warningtype":0,"warninglink":35,"bagcode":null,"kid":0,"wcase":"出库超时异常","wtime":null,"handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":null,"tbldata":null,"hospital":null},
 {"noteid":95,"handlestate":0,"warningtype":0,"warninglink":34,"bagcode":null,"kid":0,"wcase":"入库重量异常","wtime":"2021-12-23 23:15:28","handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":null,"tbldata":null,"hospital":null},
 {"noteid":70,"handlestate":0,"warningtype":0,"warninglink":35,"bagcode":null,"kid":0,"wcase":"出库重量异常","wtime":"2021-12-14 12:55:57","handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":null,"tbldata":null,"hospital":null},{"noteid":69,"handlestate":0,"warningtype":0,"warninglink":35,"bagcode":null,"kid":0,"wcase":"出库重量异常","wtime":"2021-12-14 12:55:57","handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":null,"tbldata":null,"hospital":null},{"noteid":68,"handlestate":0,"warningtype":0,"warninglink":35,"bagcode":null,"kid":0,"wcase":"出库重量异常","wtime":"2021-12-14 12:55:57","handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":null,"tbldata":null,"hospital":null},{"noteid":67,"handlestate":0,"warningtype":0,"warninglink":35,"bagcode":null,"kid":0,"wcase":"出库重量异常","wtime":"2021-12-14 12:55:57","handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":null,"tbldata":null,"hospital":null},{"noteid":66,"handlestate":0,"warningtype":0,"warninglink":35,"bagcode":null,"kid":0,"wcase":"出库重量异常","wtime":"2021-12-14 12:55:57","handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":null,"tbldata":null,"hospital":null},{"noteid":65,"handlestate":0,"warningtype":0,"warninglink":35,"bagcode":null,"kid":0,"wcase":"出库重量异常","wtime":"2021-12-14 12:55:57","handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":null,"tbldata":null,"hospital":null},{"noteid":64,"handlestate":0,"warningtype":0,"warninglink":35,"bagcode":null,"kid":0,"wcase":"出库重量异常","wtime":"2021-12-14 12:55:57","handleman":0,"handleidea":null,"handletime":null,"hid":0,"spare1":null,"spare2":null,"departrment":null,"tbldata":null,"hospital":null}],"code":1,"count":18}
 **/