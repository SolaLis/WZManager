package gjp.com.wzmanager.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/28.
 */

public class AudireInfoBean implements Serializable {
    private String serial;

    private String module;

    private String keyvalue;

    private String audiuser;

    private String dates;

    private String classname;

    private String auditingidea;

    private String auditingflag;

    private String auditingdate;

    private String applydescribe;

    private String usercode;

    private String deptcode;

    private String guid;

    private int level;

    private String auditype;

    private String audiitem;

    private int activation;

    private String tablename;

    private String keycol;

    private String title;

    private String usernamec;

    private String audiuser_name;

    private String bm_name;

    private String audit;
    private String shlb;

    public AudireInfoBean() {
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getKeyvalue() {
        return keyvalue;
    }

    public void setKeyvalue(String keyvalue) {
        this.keyvalue = keyvalue;
    }

    public String getAudiuser() {
        return audiuser;
    }

    public void setAudiuser(String audiuser) {
        this.audiuser = audiuser;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getAuditingidea() {
        return auditingidea;
    }

    public void setAuditingidea(String auditingidea) {
        this.auditingidea = auditingidea;
    }

    public String getAuditingflag() {
        return auditingflag;
    }

    public void setAuditingflag(String auditingflag) {
        this.auditingflag = auditingflag;
    }

    public String getAuditingdate() {
        return auditingdate;
    }

    public void setAuditingdate(String auditingdate) {
        this.auditingdate = auditingdate;
    }

    public String getApplydescribe() {
        return applydescribe;
    }

    public void setApplydescribe(String applydescribe) {
        this.applydescribe = applydescribe;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAuditype() {
        return auditype;
    }

    public void setAuditype(String auditype) {
        this.auditype = auditype;
    }

    public String getAudiitem() {
        return audiitem;
    }

    public void setAudiitem(String audiitem) {
        this.audiitem = audiitem;
    }

    public int getActivation() {
        return activation;
    }

    public void setActivation(int activation) {
        this.activation = activation;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getKeycol() {
        return keycol;
    }

    public void setKeycol(String keycol) {
        this.keycol = keycol;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsernamec() {
        return usernamec;
    }

    public void setUsernamec(String usernamec) {
        this.usernamec = usernamec;
    }

    public String getAudiuser_name() {
        return audiuser_name;
    }

    public void setAudiuser_name(String audiuser_name) {
        this.audiuser_name = audiuser_name;
    }

    public String getBm_name() {
        return bm_name;
    }

    public void setBm_name(String bm_name) {
        this.bm_name = bm_name;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public String getShlb() {
        return shlb;
    }

    public void setShlb(String shlb) {
        this.shlb = shlb;
    }

    @Override
    public String toString() {
        return "AudireInfoBean{" +
                "serial='" + serial + '\'' +
                ", module='" + module + '\'' +
                ", keyvalue='" + keyvalue + '\'' +
                ", audiuser='" + audiuser + '\'' +
                ", dates='" + dates + '\'' +
                ", classname='" + classname + '\'' +
                ", auditingidea='" + auditingidea + '\'' +
                ", auditingflag='" + auditingflag + '\'' +
                ", auditingdate='" + auditingdate + '\'' +
                ", applydescribe='" + applydescribe + '\'' +
                ", usercode='" + usercode + '\'' +
                ", deptcode='" + deptcode + '\'' +
                ", guid='" + guid + '\'' +
                ", level=" + level +
                ", auditype='" + auditype + '\'' +
                ", audiitem='" + audiitem + '\'' +
                ", activation=" + activation +
                ", tablename='" + tablename + '\'' +
                ", keycol='" + keycol + '\'' +
                ", title='" + title + '\'' +
                ", usernamec='" + usernamec + '\'' +
                ", audiuser_name='" + audiuser_name + '\'' +
                ", bm_name='" + bm_name + '\'' +
                ", audit='" + audit + '\'' +
                ", shlb='" + shlb + '\'' +
                '}';
    }
}
