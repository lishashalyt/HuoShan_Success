package com.bawei.hslss.huoshan_success;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bawei.hslss.huoshan_success.fragment.Live_fragment;
import com.bawei.hslss.huoshan_success.fragment.vedio_fragment;

public class LiveVedioActivity extends AppCompatActivity {

    private TabLayout mTb;
    private ViewPager mVp;
    /**
     * 注册/登录
     */
    private TextView mLogin;
    String[] itemName = {"直播","视频"};
    TbAdapter tbAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_vedio);
        initView();

        tbAdapter=new TbAdapter(getSupportFragmentManager());
        mTb.setupWithViewPager(mVp);
        mVp.setAdapter(tbAdapter);
    }

    private void initView() {
        mTb = (TabLayout) findViewById(R.id.tb);
        mVp = (ViewPager) findViewById(R.id.vp);
        mLogin = (TextView) findViewById(R.id.login);
    }
    class TbAdapter extends FragmentPagerAdapter {


        public TbAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                //注意：activity中导入的包必须和碎片一致 v4包!!!
                case 0:
                    return new Live_fragment();
                case 1:
                    return new vedio_fragment();
            }
            return new vedio_fragment();
        }

        @Override
        public int getCount() {
            return itemName.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return itemName[position];
        }
    }
}
