package gjp.com.wzmanager.param;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/18.
 */

public class IsLastBean implements Serializable {
    private String keyValue;
    private String auditype;
    private int level;

    public IsLastBean() {
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getAuditype() {
        return auditype;
    }

    public void setAuditype(String auditype) {
        this.auditype = auditype;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
