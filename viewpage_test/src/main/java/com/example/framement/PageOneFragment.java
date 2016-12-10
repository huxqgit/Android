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

public class PageOneFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.vp_onepage,container, false);

        TextView tv_one=(TextView) view.findViewById(R.id.tv_one);
        tv_one.setText("PageOneFragment");

        return view;
    }
}
