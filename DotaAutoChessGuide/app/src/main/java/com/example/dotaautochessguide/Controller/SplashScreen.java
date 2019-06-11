package com.example.dotaautochessguide.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.dotaautochessguide.R;

public class SplashScreen extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        ImageView logo;
        logo = findViewById(R.id.splashlogo);


        Animation myanim = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.fade_in);
        logo.startAnimation(myanim);

        final Intent aftersplash = new Intent(SplashScreen.this, Menu.class);
        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                } finally {
                    startActivity(aftersplash);
                    finish();
                }
            }
        };
        timer.start();
    }
}

