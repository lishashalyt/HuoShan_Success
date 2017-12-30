package com.bawei.hslss.huoshan_success;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int time=3;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time--;
                if(time==0){
                  /*新建一个要跳转到的页面*/
                    Intent intent = new Intent(MainActivity.this,LiveVedioActivity.class);
                    startActivity(intent);
                    return;
                }
                handler.postDelayed(this,1000);
            }
        },1000);
    }
}
