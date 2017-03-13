package com.baway.jingzeyang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * 实现点击按钮可以加载进度条
 */
public class MainActivity extends AppCompatActivity {
    private Myview circleView;
    int progress = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        circleView = (Myview) findViewById(R.id.circleView);
    }
    //开始按钮的监听
    public void start(View v) {
        // 1000公里
        circleView.setMax(100);
        progress=0;
        new Thread() {
            public void run() {
                while (true) {
                    progress = progress + 1;
                    String text = progress + "%";
                    circleView.setProgressAndText(progress, text);
                    try {
                        sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (progress == 100) {
                        break;
                    }
                }
            };
        }.start();
    }
    //重置按钮的监听
    public void chong(View view){
        progress = 0;
        new Thread() {
            public void run() {
                while (true) {
                    progress = (progress + 0);
                    String text = progress + "%";
                    circleView.setProgressAndText(progress, text);
                    try {
                        sleep(3000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (progress == 0) {
                        break;
                    }
                }
            };
        }.start();
    }
}
