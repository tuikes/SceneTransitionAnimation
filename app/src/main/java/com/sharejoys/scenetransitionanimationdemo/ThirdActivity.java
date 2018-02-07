package com.sharejoys.scenetransitionanimationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置允许使用转场动画  api>=21
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        // 设置contentFeature,可使用切换动画
//        Transition explode = TransitionInflater.from(this).inflateTransition(android.R.transition.explode);
//        getWindow().setEnterTransition(explode);
//        getWindow().setExitTransition(explode);
////
        Explode fade = new Explode();
        fade.setDuration(1000);
        getWindow().setExitTransition(fade);//出去的动画
        getWindow().setEnterTransition(fade);//进来的动画
    }
}
