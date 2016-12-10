package com.example.viewpagetest;

/**
 * Created by huxq on 2016/12/10.
 */


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.framement.PageFourFragment;
import com.example.framement.PageOneFragment;
import com.example.framement.PageThreeFragment;
import com.example.framement.PageTwoFragment;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class FragmentTagsActivity extends FragmentActivity implements OnClickListener {

    private LinearLayout linear_shouye, linear_xinxi, linear_wo, linear_gongju;

    private ImageButton img_shouye, img_xinxi, img_wo, img_gongju;

    //存放 Fragment对象
    private List<Fragment> fragments;

    private FragmentManager manager;

    //记录上一次的 framgment 下标
    private int selectedfragment = 0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framement_tags);
        fragments = new ArrayList<Fragment>();
        InitView();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * 进行初始化工作
     */
    private void InitView() {

        //初始化 tabs
        linear_shouye = (LinearLayout) findViewById(R.id.linear_shouye);
        linear_gongju = (LinearLayout) findViewById(R.id.linear_gongju);
        linear_wo = (LinearLayout) findViewById(R.id.linner_wo);
        linear_xinxi = (LinearLayout) findViewById(R.id.linear_xinxi);

        img_gongju = (ImageButton) findViewById(R.id.img_gongju);
        img_shouye = (ImageButton) findViewById(R.id.img_shouye);
        img_wo = (ImageButton) findViewById(R.id.img_wo);
        img_xinxi = (ImageButton) findViewById(R.id.img_xinxi);

        // 设置tab 点击事件
        linear_gongju.setOnClickListener(this);
        linear_shouye.setOnClickListener(this);
        linear_wo.setOnClickListener(this);
        linear_xinxi.setOnClickListener(this);


        //初始化fragment 数据
        PageOneFragment pageOneFragment = new PageOneFragment();
        fragments.add(pageOneFragment);
        PageTwoFragment pageTwoFragment = new PageTwoFragment();
        fragments.add(pageTwoFragment);
        PageThreeFragment pageThreeFragment = new PageThreeFragment();
        fragments.add(pageThreeFragment);
        PageFourFragment fourFragment = new PageFourFragment();
        fragments.add(fourFragment);

        //实例化对象
        manager = getSupportFragmentManager();

        //初始化第一个页面
        FragmentTransaction beginTransaction = manager.beginTransaction();
        beginTransaction.add(R.id.fragment, pageOneFragment);
        beginTransaction.commit();
    }

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
     *
     * @param i
     */
    private void SetTabsSelectedImg(int i) {
        FragmentTransaction beginTransaction = manager.beginTransaction();
        beginTransaction.remove(fragments.get(selectedfragment));
        beginTransaction.add(R.id.fragment, fragments.get(i));
        selectedfragment = i;
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
        beginTransaction.commit();

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
                .setName("FragmentTags Page") // TODO: Define a title for the content shown.
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
}
