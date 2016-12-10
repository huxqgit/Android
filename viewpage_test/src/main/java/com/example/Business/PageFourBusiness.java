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

public class PageFourBusiness {

    //	private Context context;
    private View view;

    //初始化控件
    private TextView tv_four;
    private Button btn_four;
    private int i=0;

    public PageFourBusiness(Context context, View view) {
        //	this.context = context;
        this.view = view;
    }


    public void OpBusinessInit(){
        tv_four=(TextView) view.findViewById(R.id.tv_four);
        btn_four=(Button) view.findViewById(R.id.btn_fourpage);
        btn_four.setOnClickListener(new btnTwopageListener());
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
            tv_four.setText("FourPageClickListener i="+i);
        }
    }

}

