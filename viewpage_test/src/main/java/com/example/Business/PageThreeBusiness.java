package com.example.Business;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.viewpagetest.R;

/**
 * Created by huxq on 2016/12/10.
 */


public class PageThreeBusiness {

    // private Context context;
    private View view;

    // 初始化控件
    private TextView tv_three;
    private Button btn_three;
    private int i = 0;

    public PageThreeBusiness(Context context, View view) {
        // this.context = context;
        this.view = view;
    }

    public void OpBusinessInit() {
        tv_three = (TextView) view.findViewById(R.id.tv_three);
        btn_three = (Button) view.findViewById(R.id.btn_threepage);
        btn_three.setOnClickListener(new btnThreepageListener());
    }

    /**
     * 点击事件
     *
     * @author yuan
     *
     */
    class btnThreepageListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            i++;
            tv_three.setText("ThreePageClickListener i=" + i);
        }
    }

}