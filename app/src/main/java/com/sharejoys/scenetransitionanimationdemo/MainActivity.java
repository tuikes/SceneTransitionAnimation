package com.sharejoys.scenetransitionanimationdemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.support.v4.util.Pair.create;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.way_one)
    TextView mWayOne;
    @BindView(R.id.way_two)
    TextView mWayTwo;
    @BindView(R.id.way_three)
    TextView mWayThree;
    @BindView(R.id.way_four)
    TextView mWayFour;
    @BindView(R.id.way_five)
    TextView mWayFive;
    @BindView(R.id.way_six)
    TextView mWaySix;
    @BindView(R.id.main_img)
    ImageView mImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置允许使用转场动画  api>=21
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.way_one, R.id.way_two, R.id.way_three, R.id.way_four, R.id.way_five, R.id.way_six})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.way_one:
                startActivity(new Intent(this, FirstActivity.class));
                overridePendingTransition(R.anim.slide_bottom_in, R.anim.slide_top_out);
                break;
            case R.id.way_two:
                //<item name="android:windowAnimationStyle">@style/ActivityInOutAnim</item>
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.way_three:
                Fade fade = new Fade();
                fade.setDuration(400);
                getWindow().setExitTransition(fade);//出来的动画
                getWindow().setEnterTransition(fade);//进去的动画
                Intent intent = new Intent(this, ThirdActivity.class);
                //如果有共享元素，可以设置共享元素，那么它就会按照共享元素动画执行，其他的子view就会按照Fade动画执行。
                ActivityOptions activityOptions1 = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent, activityOptions1.toBundle());
                break;
            case R.id.way_four:
                //ActivityOptions需要API>=21,兼容API<21需要用ActivityOptionsCompat代替。动画来自下面设置
                //<item name="android:windowEnterTransition">@transition/activity_slide</item>
                //<item name="android:windowExitTransition">@transition/activity_slide</item>
                //<item name="android:windowContentTransitions">true</item>
                Intent intent2 = new Intent(this, FourthActivity.class);
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent2, activityOptions.toBundle());
                break;
            case R.id.way_five:
                Intent intent1 = new Intent(this, FifthActivity.class);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, mWayFive, "btn");
                ActivityCompat.startActivity(this, intent1, optionsCompat.toBundle());
                break;
            case R.id.way_six:
                Intent intent4 = new Intent(this, SixActivity.class);
                ActivityOptionsCompat optionsCompat3 = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, Pair.create((View) mImg, "beauty_img"), Pair.create((View) mWaySix, "btn_six"));
                ActivityCompat.startActivity(this, intent4, optionsCompat3.toBundle());
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_bottom_in, R.anim.slide_top_out);
    }
}
