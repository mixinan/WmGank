package cc.guoxingnan.wmgank.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cc.guoxingnan.wmgank.R;
import cc.guoxingnan.wmgank.WebViewActivity;


public class AboutFragment extends Fragment implements View.OnClickListener {

    private static AboutFragment mAboutFragment;
    private Context mContext;
    private TextView tvVersion;
    private TextView tvDaiMaJia;
    private TextView tvGank;
    private TextView tvDrakeet;
    private TextView tvMeiZi;
    private TextView tvSatan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        mContext = getActivity();
        initView(view);
        initListener();
        initData();
        return view;
    }


    private void initView(View view) {
        tvVersion = (TextView) view.findViewById(R.id.tv_version);
        tvDaiMaJia = (TextView) view.findViewById(R.id.tv_daimajia);
        tvGank = (TextView) view.findViewById(R.id.tv_gank);
        tvDrakeet = (TextView) view.findViewById(R.id.tv_drakeet);
        tvMeiZi = (TextView) view.findViewById(R.id.tv_meizi);
        tvSatan = (TextView) view.findViewById(R.id.tv_satan);
    }

    private void initData() {
        try {
            String version = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionName;
            tvVersion.setText("Version " + version);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initListener() {
        tvDaiMaJia.setOnClickListener(this);
        tvGank.setOnClickListener(this);
        tvDrakeet.setOnClickListener(this);
        tvMeiZi.setOnClickListener(this);
        tvSatan.setOnClickListener(this);
    }

    public static AboutFragment newInstance() {
        if (mAboutFragment == null) {
            mAboutFragment = new AboutFragment();
        }
        return mAboutFragment;
    }


    @Override
    public void onClick(View v) {
    	String desc = null;
    	String url = null;
    	
        switch (v.getId()) {
            case R.id.tv_daimajia:
            	desc = mContext.getResources().getString(R.string.daimajia);
            	url = "https://github.com/daimajia";
                break;
            case R.id.tv_gank:
            	desc = mContext.getResources().getString(R.string.gank);
            	url = "http://gank.io";
                break;
            case R.id.tv_drakeet:
            	desc = mContext.getResources().getString(R.string.drakeet);
            	url = "https://github.com/drakeet";
                break;
            case R.id.tv_meizi:
            	desc = mContext.getResources().getString(R.string.meizi);
            	url = "https://github.com/drakeet/Meizhi";
                break;
            case R.id.tv_satan:
            	desc = "ÎÒµÄGitHub";
            	url = mContext.getResources().getString(R.string.github);
                break;
        }
        
        Intent intent = new Intent();
        intent.putExtra("click", url);
        intent.putExtra("title", desc);
        intent.setClass(mContext, WebViewActivity.class);
        startActivity(intent);
    }
}
