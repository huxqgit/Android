package com.example.viewpagetest;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.Business.PageFourBusiness;
import com.example.Business.PageOneBusiness;
import com.example.Business.PageThreeBusiness;
import com.example.Business.PageTwoBusiness;
import com.example.adapter.TabsPageAdapter;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huxq on 2016/12/10.
 */

/**
 * 使用说明:
 * (1) 实现 top.xml
 * (2) 实现 buttom.xml
 * (3) 实现 Acitvity.xml 页面
 * (4) tab 和 ViewPage 业务 在此类 实现
 * (5) 子页面 业务实现 在 com.example.Business
 * (7) 基本思路
 * 通过 ViewPage 实现页面可滑动 和 tab 可以点击切换页面;
 * 子页面业务实现 在Business 里 实现 ,通过 子页面的View来操作 该页面业务;
 * 当然 也可以在ViewPage 的监听事件里实现 (单独的将 ViewPage的切换页面的监听事件写成一个类实现) ;
 *
 * @author yuan
 */

public class PagerViewTagsActivity extends Activity implements OnClickListener {

    private ViewPager vp_tabs;
    private LinearLayout linear_shouye, linear_xinxi, linear_wo, linear_gongju;

    private ImageButton img_shouye, img_xinxi, img_wo, img_gongju;

    private View one_page, two_page, three_page, four_page;

    private List<View> views;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagerview_tabs);
        views = new ArrayList<View>();
        // 初始化
        InitView();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void InitView() {
        // 初始化工作
        vp_tabs = (ViewPager) findViewById(R.id.vp_tabs);
        linear_shouye = (LinearLayout) findViewById(R.id.linear_shouye);
        linear_gongju = (LinearLayout) findViewById(R.id.linear_gongju);
        linear_wo = (LinearLayout) findViewById(R.id.linner_wo);
        linear_xinxi = (LinearLayout) findViewById(R.id.linear_xinxi);

        img_gongju = (ImageButton) findViewById(R.id.img_gongju);
        img_shouye = (ImageButton) findViewById(R.id.img_shouye);
        img_wo = (ImageButton) findViewById(R.id.img_wo);
        img_xinxi = (ImageButton) findViewById(R.id.img_xinxi);

        // 初始化 view 数据
        one_page = View.inflate(this, R.layout.vp_onepage, null);
        two_page = View.inflate(this, R.layout.vp_twopage, null);
        three_page = View.inflate(this, R.layout.vp_threepage, null);
        four_page = View.inflate(this, R.layout.vp_fourpage, null);

        views.add(one_page);
        views.add(two_page);
        views.add(three_page);
        views.add(four_page);

        // 设置 adapter
        TabsPageAdapter pageAdapter = new TabsPageAdapter(views);
        vp_tabs.setAdapter(pageAdapter);

        // 设置tab 点击事件
        linear_gongju.setOnClickListener(this);
        linear_shouye.setOnClickListener(this);
        linear_wo.setOnClickListener(this);
        linear_xinxi.setOnClickListener(this);

        //设置ViewPage 切换效果
        vp_tabs.setOnPageChangeListener(new vp_tabsOnChangeListener());

        //子页面 初始化 工作
        InitItemPage();
    }

    /**
     * 初始化
     * Item 事件处理
     */
    private void InitItemPage() {

        //初始化 view Item 中的事件

        //第一个页面事件
        PageOneBusiness onePageBusiness = new PageOneBusiness(this, one_page);
        onePageBusiness.OpBusinessInit();

        //第二个页面事件
        PageTwoBusiness pageTwoBusiness = new PageTwoBusiness(this, two_page);
        pageTwoBusiness.OpBusinessInit();

        //第三个页面事件
        PageThreeBusiness pageThreeBusiness = new PageThreeBusiness(this, three_page);
        pageThreeBusiness.OpBusinessInit();

        //第四个页面事件
        PageFourBusiness pageFourBusiness = new PageFourBusiness(this, four_page);
        pageFourBusiness.OpBusinessInit();

    }

    /**
     * Tags 的 点击事件
     */
    @Override
    public void onClick(View v) {
        // tabs 点击事件
        ResetTabsImg();
        switch (v.getId()) {
            case R.id.linear_shouye:
                SetTabsSelectedImg(0);
                break;
            case R.id.linear_gongju:
                SetTabsSelectedImg(2);
                break;
            case R.id.linner_wo:
                SetTabsSelectedImg(3);
                break;
            case R.id.linear_xinxi:
                SetTabsSelectedImg(1);
                break;
        }

    }

    /**
     * (1)实现选中后的 tabs的img
     * (2)切换 viewpager item
     *
     * @param i
     */
    private void SetTabsSelectedImg(int i) {

        switch (i) {
            case 0:
                img_shouye.setImageResource(R.drawable.ic_menu_deal_on);
                break;
            case 1:
                img_xinxi.setImageResource(R.drawable.ic_menu_more_on);
                break;
            case 2:
                img_gongju.setImageResource(R.drawable.ic_menu_user_on);
                break;
            case 3:
                img_wo.setImageResource(R.drawable.ic_menu_poi_on);
                break;
        }

        //切换 viewpage item
        vp_tabs.setCurrentItem(i);

    }

    /**
     * 将 tabs 的 图片设置 默认颜色
     */
    private void ResetTabsImg() {
        // 重置tab 图片
        img_gongju.setImageResource(R.drawable.ic_menu_user_off);
        img_shouye.setImageResource(R.drawable.ic_menu_deal_off);
        img_wo.setImageResource(R.drawable.ic_menu_poi_off);
        img_xinxi.setImageResource(R.drawable.ic_menu_more_off);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("PagerViewTags Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


    /**
     * ViewPage 切换 监听事件
     *
     * @author yuan
     */
    class vp_tabsOnChangeListener implements OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
            //

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageSelected(int arg0) {
            //设置 tab 背景
            ResetTabsImg();
            SetTabsSelectedImg(arg0);
        }

    }

}
