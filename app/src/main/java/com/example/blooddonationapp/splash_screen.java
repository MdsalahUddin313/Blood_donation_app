package com.example.blooddonationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.blooddonationapp.Auth.Login;

public class splash_screen extends AppCompatActivity {

    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        status_bar();
        iv=(ImageView)findViewById(R.id.imageLogo);
        Animation anime= AnimationUtils.loadAnimation(this,R.anim.splash_screen_anim);

        iv.startAnimation(anime);

        final Intent intent=new Intent(splash_screen.this, Login.class);

        Thread timer=new Thread(){
            public void run(){
                try{

                    sleep(5000);
                }catch (InterruptedException e){

                    e.printStackTrace();
                }

                finally {
                    startActivity(intent);
                    finish();
                }
            }

        };
        timer.start();
    }

    void status_bar(){
        Window window = getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(getResources().getColor(R.color.white));
        }
    }
}