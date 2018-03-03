package gjp.com.wzmanager.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/12.
 */

public class SpyjBean implements Serializable {
    private String tablename;
    private String auditingflag;
    private String keycol;
    private String sqdh;
    private String keyvalue;
    private String module;
    private String serial;
    private String li_level;
    private String audiitem;
    private String ls_audiuser;
    private String auditingidea;

    public SpyjBean() {
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getAuditingflag() {
        return auditingflag;
    }

    public void setAuditingflag(String auditingflag) {
        this.auditingflag = auditingflag;
    }

    public String getKeycol() {
        return keycol;
    }

    public void setKeycol(String keycol) {
        this.keycol = keycol;
    }

    public String getSqdh() {
        return sqdh;
    }

    public void setSqdh(String sqdh) {
        this.sqdh = sqdh;
    }

    public String getKeyvalue() {
        return keyvalue;
    }

    public void setKeyvalue(String keyvalue) {
        this.keyvalue = keyvalue;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getLi_level() {
        return li_level;
    }

    public void setLi_level(String li_level) {
        this.li_level = li_level;
    }

    public String getAudiitem() {
        return audiitem;
    }

    public void setAudiitem(String audiitem) {
        this.audiitem = audiitem;
    }

    public String getLs_audiuser() {
        return ls_audiuser;
    }

    public void setLs_audiuser(String ls_audiuser) {
        this.ls_audiuser = ls_audiuser;
    }

    public String getAuditingidea() {
        return auditingidea;
    }

    public void setAuditingidea(String auditingidea) {
        this.auditingidea = auditingidea;
    }
}
