package gjp.com.wzmanager.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/5.
 */

public class BxMxBean implements Serializable{
    private FeeaskBean tmatser;
    private List<FeeaskMxBean> listdata;

    public BxMxBean() {
    }

    public FeeaskBean getTmatser() {
        return tmatser;
    }

    public void setTmatser(FeeaskBean tmatser) {
        this.tmatser = tmatser;
    }

    public List<FeeaskMxBean> getListdata() {
        return listdata;
    }

    public void setListdata(List<FeeaskMxBean> listdata) {
        this.listdata = listdata;
    }
}
