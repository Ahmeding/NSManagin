package tn.com.hitecart.nsmanaging.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tn.com.hitecart.nsmanaging.R;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checking();
            }
        }, SPLASH_TIME_OUT);

    }

    private void checking() {
        Intent intent;
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
