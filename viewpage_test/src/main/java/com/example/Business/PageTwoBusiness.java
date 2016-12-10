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


public class PageTwoBusiness {

    //	private Context context;
    private View view;

    //初始化控件
    private TextView tv_two;
    private Button btn_two;
    private int i=0;

    public PageTwoBusiness(Context context, View view) {
        //	this.context = context;
        this.view = view;
    }


    public void OpBusinessInit(){
        tv_two=(TextView) view.findViewById(R.id.tv_two);
        btn_two=(Button) view.findViewById(R.id.btn_twopage);
        btn_two.setOnClickListener(new btnTwopageListener());
    }


    /**
     * 点击事件
     * @author yuan
     *
     */
    class btnTwopageListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            i++;
            tv_two.setText("TwoPageClickListener i="+i);
        }
    }

}