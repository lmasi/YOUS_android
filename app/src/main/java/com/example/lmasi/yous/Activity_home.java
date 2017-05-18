package com.example.lmasi.yous;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Activity_home extends Activity {

    RelativeLayout main;

    ImageView log_in;
    ImageView sign_in;

    NetFileReader nf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = (RelativeLayout)findViewById(R.id.main);
        main.setBackgroundColor(Color.WHITE);


        log_in = new ImageView(getApplicationContext());
        log_in.setBackground(getResources().getDrawable(R.drawable.log_in));
        log_in.setLayoutParams(new YousParameter(527,85).setMargin(0,555,0,0).addRules(RelativeLayout.CENTER_HORIZONTAL));
        main.addView(log_in);
        log_in.setId(log_in.hashCode());
        log_in.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    startActivity(new Intent(Activity_home.this, Activity_Login.class));
                    finish();
                }

                return true;
            }
        });

        sign_in = new ImageView(getApplicationContext());
        sign_in.setBackground(getResources().getDrawable(R.drawable.sign_up));
        sign_in.setLayoutParams(new YousParameter(527,85).setMargin(0,22,0,0)
                                    .addRules(RelativeLayout.CENTER_HORIZONTAL)
                                    .addRules(RelativeLayout.BELOW, log_in.getId())
                                );
        main.addView(sign_in);
        sign_in.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    startActivity(new Intent(Activity_home.this, Activity_SignUp.class));
                    finish();
                }

                return true;
            }
        });
    }
}