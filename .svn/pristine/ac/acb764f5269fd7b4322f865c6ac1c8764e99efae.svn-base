package gjp.com.wzmanager.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gjp.com.wzmanager.R;
import gjp.com.wzmanager.adapter.AudireInfoAdapter;
import gjp.com.wzmanager.adapter.RecycleViewDivider;
import gjp.com.wzmanager.bean.AudireInfoBean;
import gjp.com.wzmanager.contract.AudireInfoContract;
import gjp.com.wzmanager.param.ExcuteAuditBean;
import gjp.com.wzmanager.param.IsLastBean;
import gjp.com.wzmanager.presenter.AudireInfoPresenter;
import gjp.com.wzmanager.util.AllUrl;
import gjp.com.wzmanager.util.BaseUtil;
import gjp.com.wzmanager.util.ProgressDialogUtils;
import gjp.com.wzmanager.util.SharedPreferencesUtil;

public class AudireInfoActivity extends BaseActivity implements AudireInfoContract.View {

    @BindView(R.id.header_title)
    TextView headerTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.rv_audire_info)
    RecyclerView rvAudireInfo;
    @BindView(R.id.tv_audire_info_jj)
    TextView tvAudireInfoJj;
    @BindView(R.id.tv_audire_info_ty)
    TextView tvAudireInfoTy;
    @BindView(R.id.ll_audire_info_btn)
    LinearLayout llAudireInfoBtn;
    private AudireInfoContract.Presenter presenter;
    private List<AudireInfoBean> audireInfoBeanList = new ArrayList<>();
    private List<AudireInfoBean> audireInfoBeanList1 = new ArrayList<>();
    private AudireInfoAdapter adapter;
    private String url,url1,url2,url3;
    private String sqdh;
    private String usercode;

    private View CustomView;
    private View CustomView1;

    private int flag;
    private String yj1;
    private String yj2;
    AudireInfoBean audireInfoBean = new AudireInfoBean();

    private IsLastBean isLastBean=new IsLastBean();
    private ExcuteAuditBean excuteAuditBean=new ExcuteAuditBean();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audire_info);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        flag = intent.getIntExtra("flag", 0);
        init();
        ProgressDialogUtils.showProgressDialog(this, "正在加载...");
        presenter = new AudireInfoPresenter(this);
        usercode = SharedPreferencesUtil.getStringData(this, "usercode", null);
        url = SharedPreferencesUtil.getStringData(this, "setUrl", null) + AllUrl.AUDIRE_INFO_URL;
        url1 = SharedPreferencesUtil.getStringData(this, "setUrl", null) + AllUrl.ISLAST_URL;
        url2 = SharedPreferencesUtil.getStringData(this, "setUrl", null) + AllUrl.NextAudit_URL;
        url3 = SharedPreferencesUtil.getStringData(this, "setUrl", null) + AllUrl.AUDIRE_URL;
        sqdh = getIntent().getStringExtra("sqdh");
        presenter.getAudireInfo(url, sqdh);
    }

    private void init() {
        headerTitle.setText("审批信息");
        ivBack.setVisibility(View.VISIBLE);
        if (flag == 1) {
            llAudireInfoBtn.setVisibility(View.VISIBLE);
        } else {
            llAudireInfoBtn.setVisibility(View.GONE);
        }
    }

    @Override
    public void getAudireInfoSuccess(List<AudireInfoBean> list) {
        ProgressDialogUtils.dismissProgressDialog();
        audireInfoBeanList = list;
        Log.e("LOG", "getAudireInfoSuccess(AudireInfoActivity.java:73)===" + audireInfoBeanList.size());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setAdapter();
            }
        });
    }

    @Override
    public void getAudireInfoFailed(final String errorMessage) {
        ProgressDialogUtils.dismissProgressDialog();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                BaseUtil.myToast(errorMessage);
            }
        });
    }

    @Override
    public void getAudireSuccess(int i) {
        ProgressDialogUtils.dismissProgressDialog();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                BaseUtil.myToast("审核成功");
                Intent intent=new Intent(AudireInfoActivity.this, MainActivity.class);
                intent.putExtra("flag",1);
                startActivity(intent);
              /*  audireInfoBeanList.clear();
                presenter.getAudireInfo(url, sqdh);
                tvAudireInfoJj.setEnabled(false);
                tvAudireInfoTy.setEnabled(false);
                tvAudireInfoJj.setBackgroundColor(getResources().getColor(R.color.color_b5));
                tvAudireInfoTy.setBackgroundColor(getResources().getColor(R.color.color_b5));*/
            }
        });
    }

    @Override
    public void getAudireFailed(final String errorMessage) {
        ProgressDialogUtils.dismissProgressDialog();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                BaseUtil.myToast(errorMessage);
            }
        });
    }

    @Override
    public void getNextAuditSuccess(List<AudireInfoBean> list) {
        ProgressDialogUtils.dismissProgressDialog();
            audireInfoBeanList1=list;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder builder1 = myBuilder1(AudireInfoActivity.this);
                    final RadioGroup group= (RadioGroup) CustomView1.findViewById(R.id.rg_customview1);;
                    for(int i=0; i<audireInfoBeanList1.size(); i++)
                    {
                        RadioButton tempButton = new RadioButton(AudireInfoActivity.this);
                        tempButton.setPadding(80, 0, 0, 0);                 // 设置文字距离按钮四周的距离
                        tempButton.setText(audireInfoBeanList1.get(i).getAudiuser_name());
                        tempButton.setId(i);
                        group.addView(tempButton, LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    }
                    group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            RadioButton tempButton = (RadioButton)findViewById(checkedId); // 通过RadioGroup的findViewById方法，找到ID为checkedID的RadioButton
                            // 以下就可以对这个RadioButton进行处理了
                           // BaseUtil.myToast(checkedId+"");
                            excuteAuditBean.setLs_audiuser_next(audireInfoBeanList1.get(checkedId).getAudiuser());

                        }
                    });
                    final AlertDialog dialog2 = builder1.show();

                    dialog2.setCanceledOnTouchOutside(false);
                    Button ortherbtnemil1 = (Button) CustomView1.findViewById(R.id.ortherbtnemil1);
                    ortherbtnemil1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            dialog2.dismiss();
                        }
                    });
                    Button ortherbtnweb1 = (Button) CustomView1.findViewById(R.id.ortherbtnweb1);
                    ortherbtnweb1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.e("LOG","onClick(AudireInfoActivity.java:205)==="+group.getCheckedRadioButtonId());
                            if (group.getCheckedRadioButtonId()==-1){
                                    BaseUtil.myToast("请指定下一级审批人");
                            } else {
                                Log.e("LOG","onClick(AudireInfoActivity.java:195)===");
                                dialog2.dismiss();
                                excuteAuditBean.setLs_keyvalue(audireInfoBean.getKeyvalue());
                                excuteAuditBean.setLs_audiuser(audireInfoBean.getAudiuser());
                                excuteAuditBean.setLs_audiuser_name(audireInfoBean.getAudiuser_name());
                                excuteAuditBean.setLs_auditingflag("1");
                                excuteAuditBean.setLs_auditingidea(yj1);
                                //excuteAuditBean.setLs_audiuser_next(audireInfoBean.getAudiuser());
                                ProgressDialogUtils.showProgressDialog(AudireInfoActivity.this,"正在提交审核...");
                                presenter.audire(url3, excuteAuditBean);
                            }
                        }
                    });
                    ImageButton customviewtvimgCancel = (ImageButton) CustomView1.findViewById(R.id.customviewtvimgCancel);
                    customviewtvimgCancel.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            dialog2.dismiss();
                        }
                    });
                }
            });
    }

    @Override
    public void getNextAuditFailed(final String errorMessage) {
        ProgressDialogUtils.dismissProgressDialog();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                BaseUtil.myToast(errorMessage);
            }
        });
    }

    @Override
    public void getIsLastSuccess(final String auditype) {
        ProgressDialogUtils.dismissProgressDialog();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if ("3".equals(auditype)){
                    presenter.nextAudit(url2,isLastBean);
                }else {
                    excuteAuditBean.setLs_keyvalue(audireInfoBean.getKeyvalue());
                    excuteAuditBean.setLs_audiuser(audireInfoBean.getAudiuser());
                    excuteAuditBean.setLs_audiuser_name(audireInfoBean.getAudiuser_name());
                    excuteAuditBean.setLs_auditingflag("1");
                    excuteAuditBean.setLs_auditingidea(yj1);
                    excuteAuditBean.setLs_audiuser_next("");
                    ProgressDialogUtils.showProgressDialog(AudireInfoActivity.this,"正在提交审核...");
                    presenter.audire(url3, excuteAuditBean);
                }
            }
        });

    }

    @Override
    public void getIsLastFailed(final String errorMessage) {
        ProgressDialogUtils.dismissProgressDialog();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                BaseUtil.myToast(errorMessage);
            }
        });
    }

    private void setAdapter() {
        //  if (adapter == null) {
        adapter = new AudireInfoAdapter(audireInfoBeanList);
        //设置布局管理者
        rvAudireInfo.setLayoutManager(new LinearLayoutManager(AudireInfoActivity.this));
        rvAudireInfo.addItemDecoration(new RecycleViewDivider(
                AudireInfoActivity.this, LinearLayoutManager.HORIZONTAL, 1, R.color.color_b5));
        rvAudireInfo.setAdapter(adapter);
    /*   } else {
            adapter.notifyDataSetChanged();
        }*/
    }

    @OnClick({R.id.iv_back, R.id.tv_audire_info_jj, R.id.tv_audire_info_ty})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_audire_info_jj:
                new AlertDialog.Builder(this)
                       // .setTitle("确认")
                        .setMessage("您确定要拒绝吗？")
                        .setPositiveButton("是", hello)
                        .setNegativeButton("否", hello)
                        .show();
                break;
            case R.id.tv_audire_info_ty:
                AlertDialog.Builder builder = myBuilder(AudireInfoActivity.this);
                final AlertDialog dialog1 = builder.show();
                dialog1.setCanceledOnTouchOutside(false);
                Button ortherbtnemil = (Button) CustomView.findViewById(R.id.ortherbtnemil);
                ortherbtnemil.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });

                Button ortherbtnweb = (Button) CustomView.findViewById(R.id.ortherbtnweb);
                final EditText edittext = (EditText) CustomView.findViewById(R.id.customviewspyj);
                ortherbtnweb.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        for (AudireInfoBean audireInfoBean1 : audireInfoBeanList) {
                            if (usercode.equals(audireInfoBean1.getAudiuser())&&"0".equals(audireInfoBean1.getAuditingflag())) {
                                audireInfoBean = audireInfoBean1;
                                break;
                            }
                        }
                        yj1=edittext.getText().toString();
                        isLastBean.setAuditype(audireInfoBean.getAuditype());
                        isLastBean.setKeyValue(audireInfoBean.getKeyvalue());
                        isLastBean.setLevel(audireInfoBean.getLevel());
                        presenter.isLast(url1,isLastBean);
                        dialog1.dismiss();
                    }
                });

                ImageButton customviewtvimgCancel = (ImageButton) CustomView.findViewById(R.id.customviewtvimgCancel);
                customviewtvimgCancel.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });
                break;
        }
    }

    // 给对话框里的按钮注册事件
    DialogInterface.OnClickListener hello = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {

            switch (which) {
                case AlertDialog.BUTTON_POSITIVE:// 点击 确认，退出程序
                    AlertDialog.Builder builder = myBuilder(AudireInfoActivity.this);
                    final AlertDialog dialog1 = builder.show();
                    dialog1.setCanceledOnTouchOutside(false);
                    Button ortherbtnemil = (Button) CustomView.findViewById(R.id.ortherbtnemil);
                    ortherbtnemil.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            dialog1.dismiss();
                        }
                    });

                    Button ortherbtnweb = (Button) CustomView.findViewById(R.id.ortherbtnweb);
                    final EditText edittext = (EditText) CustomView.findViewById(R.id.customviewspyj);
                    ortherbtnweb.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            ProgressDialogUtils.showProgressDialog(AudireInfoActivity.this,"正在提交审核...");
                            AudireInfoBean audireInfoBean = new AudireInfoBean();
                            for (AudireInfoBean audireInfoBean1 : audireInfoBeanList) {
                                if (usercode.equals(audireInfoBean1.getAudiuser())&&"0".equals(audireInfoBean1.getAuditingflag())) {
                                    audireInfoBean = audireInfoBean1;
                                    break;
                                }
                            }
                            yj2=edittext.getText().toString();
                            excuteAuditBean.setLs_keyvalue(audireInfoBean.getKeyvalue());
                            excuteAuditBean.setLs_audiuser(audireInfoBean.getAudiuser());
                            excuteAuditBean.setLs_audiuser_name(audireInfoBean.getAudiuser_name());
                            excuteAuditBean.setLs_auditingflag("2");
                            excuteAuditBean.setLs_auditingidea(yj2);
                            excuteAuditBean.setLs_audiuser_next("");
                            presenter.audire(url3, excuteAuditBean);
                            dialog1.dismiss();
                        }
                    });

                    ImageButton customviewtvimgCancel = (ImageButton) CustomView.findViewById(R.id.customviewtvimgCancel);
                    customviewtvimgCancel.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            dialog1.dismiss();
                        }
                    });

                    break;
                case AlertDialog.BUTTON_NEGATIVE:// 点击 取消 取消对话框
                    dialog.dismiss();
                    break;
                default:
                    break;
            }
        }
    };

    protected AlertDialog.Builder myBuilder(AudireInfoActivity dialogWindows) {
        final LayoutInflater inflater = this.getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(dialogWindows);
        CustomView = inflater.inflate(R.layout.customview, null);
        return builder.setView(CustomView);
    }
    protected AlertDialog.Builder myBuilder1(AudireInfoActivity dialogWindows) {

        final LayoutInflater inflater = this.getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(dialogWindows);
        CustomView1 = inflater.inflate(R.layout.customview1, null);
        return builder.setView(CustomView1);
    }
}
