package gjp.com.wzmanager.param;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/18.
 */

public class ExcuteAuditBean implements Serializable {
    private String ls_keyvalue;
    private String ls_audiuser;
    private String ls_audiuser_name;
    private String ls_auditingflag;
    private String ls_auditingidea;
    private String ls_audiuser_next;

    public ExcuteAuditBean() {
    }

    public String getLs_keyvalue() {
        return ls_keyvalue;
    }

    public void setLs_keyvalue(String ls_keyvalue) {
        this.ls_keyvalue = ls_keyvalue;
    }

    public String getLs_audiuser() {
        return ls_audiuser;
    }

    public void setLs_audiuser(String ls_audiuser) {
        this.ls_audiuser = ls_audiuser;
    }

    public String getLs_audiuser_name() {
        return ls_audiuser_name;
    }

    public void setLs_audiuser_name(String ls_audiuser_name) {
        this.ls_audiuser_name = ls_audiuser_name;
    }

    public String getLs_auditingflag() {
        return ls_auditingflag;
    }

    public void setLs_auditingflag(String ls_auditingflag) {
        this.ls_auditingflag = ls_auditingflag;
    }

    public String getLs_auditingidea() {
        return ls_auditingidea;
    }

    public void setLs_auditingidea(String ls_auditingidea) {
        this.ls_auditingidea = ls_auditingidea;
    }

    public String getLs_audiuser_next() {
        return ls_audiuser_next;
    }

    public void setLs_audiuser_next(String ls_audiuser_next) {
        this.ls_audiuser_next = ls_audiuser_next;
    }
}
