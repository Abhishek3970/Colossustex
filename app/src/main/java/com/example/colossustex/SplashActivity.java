package com.example.colossustex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        goFullScreen();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                start();
            }
        }, SPLASH_DELAY);
    }

    private void start() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void goFullScreen() {
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        );
    }
}
