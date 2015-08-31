package com.example.euler_kalvinhe.tabtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener{
    private ViewPager viewPager;
    private LinearLayout mTabWeixin;
    private LinearLayout mTabFriend;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;
    private ImageButton btnWeixin,btnFriend,btnSetting,btnAddress;
    private PagerAdapter mPagerAdapter;
    private List<View> mViews = new ArrayList<View>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();
    }

    private void initEvents() {
        mTabSetting.setOnClickListener(this);
        mTabWeixin.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {
                int currentItem = viewPager.getCurrentItem();
                resetImg();
                switch(currentItem){
                    case 0:
                        btnWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                    case 1:
                        btnFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2:
                        btnAddress.setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3:
                        btnSetting.setImageResource(R.drawable.tab_settings_pressed);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initViews() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabWeixin = (LinearLayout) findViewById(R.id.tab_weixin);
        mTabFriend = (LinearLayout) findViewById(R.id.tab_friend);
        mTabAddress = (LinearLayout) findViewById(R.id.tab_address);
        mTabSetting = (LinearLayout) findViewById(R.id.tab_setting);
        btnWeixin = (ImageButton) findViewById(R.id.tab_weixin_img);
        btnFriend = (ImageButton) findViewById(R.id.tab_friend_img);
        btnAddress = (ImageButton) findViewById(R.id.tab_address_img);
        btnSetting = (ImageButton) findViewById(R.id.tab_setting_img);
        LayoutInflater inflater = LayoutInflater.from(this);
        View tab01 = inflater.inflate(R.layout.tab01,null);
        View tab02 = inflater.inflate(R.layout.tab02,null);
        View tab03 = inflater.inflate(R.layout.tab03,null);
        View tab04 = inflater.inflate(R.layout.tab04,null);
        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);
        mViews.add(tab04);
        mPagerAdapter = new PagerAdapter(){

            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }
        };
        viewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onClick(View view) {
        resetImg();
        switch(view.getId()){
            case R.id.tab_address:
                viewPager.setCurrentItem(2);
                btnAddress.setImageResource(R.drawable.tab_address_pressed);
                break;
            case R.id.tab_friend:
                viewPager.setCurrentItem(1);
                btnFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case R.id.tab_setting:
                viewPager.setCurrentItem(3);
                btnSetting.setImageResource(R.drawable.tab_settings_pressed);
                break;
            case R.id.tab_weixin:
                viewPager.setCurrentItem(0);
                btnWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            default:
                break;
        }
    }

    /**
     * 将所有的图片切换为暗色
     */
    private void resetImg() {
        btnWeixin.setImageResource(R.drawable.tab_weixin_normal);
        btnSetting.setImageResource(R.drawable.tab_settings_normal);
        btnAddress.setImageResource(R.drawable.tab_address_normal);
        btnFriend.setImageResource(R.drawable.tab_find_frd_normal);
    }
}
