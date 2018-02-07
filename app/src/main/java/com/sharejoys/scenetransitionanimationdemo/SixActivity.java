package com.sharejoys.scenetransitionanimationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public class SixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置允许使用转场动画  api>=21
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
    }
}
