package com.example.android.coffeeorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class start extends AppCompatActivity {
    private TextView tv;
    private TextView tv2;
    private ImageView iv;
    private ImageView iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        tv = (TextView) findViewById(R.id.coffee_text);
        tv2 = (TextView) findViewById(R.id.powered_by);
        iv = (ImageView) findViewById(R.id.coffee_image);
        iv2 = (ImageView) findViewById(R.id.powered_by_logo);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(myAnimation);
        tv2.startAnimation(myAnimation);
        iv.startAnimation(myAnimation);
        iv2.startAnimation(myAnimation);
        final Intent i = new Intent(this, MainActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
