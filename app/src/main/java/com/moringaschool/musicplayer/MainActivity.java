package com.moringaschool.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.l1) LinearLayout mLinearLayout1;
    @BindView(R.id.l2) LinearLayout mLinearLayout2;
    @BindView(R.id.tag) TextView mTag;
    @BindView(R.id.app_title) TextView mApp_tittle;
    @BindView(R.id.logo_main) ImageView mLogo;


   Animation DownTop,Fade,RightLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DownTop = AnimationUtils.loadAnimation(this,R.anim.downtop);
        Fade= AnimationUtils.loadAnimation(this,R.anim.fade);
        RightLeft=AnimationUtils.loadAnimation(this,R.anim.rightleft);

        mLinearLayout2.setAnimation(DownTop);
        mApp_tittle.setAnimation(Fade);
        mLogo.setAnimation(RightLeft);

        final Intent intent = new Intent(MainActivity.this,ButtonsActivity.class);
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                    finish();

                }
            }
        };thread.start();
    }
}