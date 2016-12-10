package com.example.framement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.viewpagetest.R;

/**
 * Created by huxq on 2016/12/10.
 */

public class PageThreeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.vp_threepage,container, false);
        TextView tv_three=(TextView) view.findViewById(R.id.tv_three);
        tv_three.setText("PageThreeFragment");
        return view;
    }
}
