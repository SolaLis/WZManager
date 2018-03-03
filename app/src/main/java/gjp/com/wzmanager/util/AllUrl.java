package gjp.com.wzmanager.util;

/**
 * Created by Administrator on 2017/5/12.
 */

public  class AllUrl {
    public static final String YSGJ_URL="http://gjprj.cn:8704/NatToolDataService.asmx/GetNatInfo";//映射工具
    public static final String NETWORK_ERROR="网络请求失败，请检查服务器设置";
    public static final String CODE_404="404错误";
    public static final String CODE_500="服务器内部错误";
    public static final String CODE_501="501错误";
    public static final String CODE_503="503错误";
    public static final String PORT_TOO_LOONG="端口号有误";
    public static final String LOGIN_URL="/api/login/login";//登录
    public static final String BM_URL="/api/bm/bm";//获取有权限的部门
    public static final String EMPLOYEE_URL="/api/EMPLOYEE/EMPLOYEE";//获取申请人
    public static final String SQB_URL="/api/apply/apply";//获取申请表
    public static final String SEARCH_SQB_URL="/api/SearchApply/SearchApply";//搜索
    public static final String SQBMX_URL="/api/applydetail/applydetail";//获取申请表明细
    public static final String AUDIRE_INFO_URL="/api/AudireInfo/Audire";//获取审批信息
    public static final String AUDIRECORD_URL="/api/Audirecord/Audirecord";//获取已审批单据
    public static final String AUDIRECORD_Examine_URL="/api/AudirecordExamine/AudirecordExamine";//获取待审批单据
    public static final String AUDIRECORDMX_URL="/api/commonapplydetail/commonapplydetail";//获取待审批表明细
    public static final String AUDIRE_URL="/api/ExcuteAudit/ExcuteAudit";//审批同意和拒绝接口
    public static final String ISLAST_URL="/api/isLastPerson/islast";//判断下一级是否是选审
    public static final String NextAudit_URL="/api/NextAuditPeople/NextAudit";//获取选审下一级审批人

}
