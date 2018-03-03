package gjp.com.wzmanager.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/5.
 */

public class PdTimeMxBean implements Serializable{
    private PcBean tmatser;
    private List<PcTimeMxBean> listdata;

    public PdTimeMxBean() {
    }

    public PcBean getTmatser() {
        return tmatser;
    }

    public void setTmatser(PcBean tmatser) {
        this.tmatser = tmatser;
    }

    public List<PcTimeMxBean> getListdata() {
        return listdata;
    }

    public void setListdata(List<PcTimeMxBean> listdata) {
        this.listdata = listdata;
    }
}
