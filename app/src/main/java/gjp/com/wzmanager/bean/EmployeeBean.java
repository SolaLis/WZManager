package gjp.com.wzmanager.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/25.
 */

public class EmployeeBean implements Serializable {
    private String em_id;

    private String em_pym;

    private String em_code;

    private String sys_date;

    private String em_name;

    private String duty_name;

    private String bm_name;

    private String em_birth;

    private String em_tel;

    private String em_address;

    private String rebate_id;

    private String rebate_percent;

    private String comment;

    private String sys_del;

    private String xtxs;

    private String usercode;

    public EmployeeBean() {
    }

    public String getEm_id() {
        return em_id;
    }

    public void setEm_id(String em_id) {
        this.em_id = em_id;
    }

    public String getEm_pym() {
        return em_pym;
    }

    public void setEm_pym(String em_pym) {
        this.em_pym = em_pym;
    }

    public String getEm_code() {
        return em_code;
    }

    public void setEm_code(String em_code) {
        this.em_code = em_code;
    }

    public String getSys_date() {
        return sys_date;
    }

    public void setSys_date(String sys_date) {
        this.sys_date = sys_date;
    }

    public String getEm_name() {
        return em_name;
    }

    public void setEm_name(String em_name) {
        this.em_name = em_name;
    }

    public String getDuty_name() {
        return duty_name;
    }

    public void setDuty_name(String duty_name) {
        this.duty_name = duty_name;
    }

    public String getBm_name() {
        return bm_name;
    }

    public void setBm_name(String bm_name) {
        this.bm_name = bm_name;
    }

    public String getEm_birth() {
        return em_birth;
    }

    public void setEm_birth(String em_birth) {
        this.em_birth = em_birth;
    }

    public String getEm_tel() {
        return em_tel;
    }

    public void setEm_tel(String em_tel) {
        this.em_tel = em_tel;
    }

    public String getEm_address() {
        return em_address;
    }

    public void setEm_address(String em_address) {
        this.em_address = em_address;
    }

    public String getRebate_id() {
        return rebate_id;
    }

    public void setRebate_id(String rebate_id) {
        this.rebate_id = rebate_id;
    }

    public String getRebate_percent() {
        return rebate_percent;
    }

    public void setRebate_percent(String rebate_percent) {
        this.rebate_percent = rebate_percent;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSys_del() {
        return sys_del;
    }

    public void setSys_del(String sys_del) {
        this.sys_del = sys_del;
    }

    public String getXtxs() {
        return xtxs;
    }

    public void setXtxs(String xtxs) {
        this.xtxs = xtxs;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }
}
