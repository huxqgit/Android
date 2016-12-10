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


public class PageOneBusiness {

    //	private Context context;
    private View view;

    //初始化控件
    private TextView tv_one;
    private Button btn_one;
    private int i=0;

    public PageOneBusiness(Context context, View view) {
        //	this.context = context;
        this.view = view;
    }


    public void OpBusinessInit(){
        tv_one=(TextView) view.findViewById(R.id.tv_one);
        btn_one=(Button) view.findViewById(R.id.btn_onepage);
        btn_one.setOnClickListener(new btnOnepageListener());
    }


    /**
     * 点击事件
     * @author yuan
     *
     */
    class btnOnepageListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            i++;
            tv_one.setText("OnePageClickListener i="+i);
        }
    }



}
