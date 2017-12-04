package com.example.space.chatapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Splash extends AppCompatActivity {
    private static final int SPLASH_TIME_MS = 2000;
    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                // check if user in already logged in or not
                if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                    // list all user to begin chat with
                    // for now go to the login also
                    startActivity(new Intent(Splash.this, Login.class));
                } else {
                    startActivity(new Intent(Splash.this, Login.class));
                }
                finish();
            }
        };
        mHandler.postDelayed(mRunnable, SPLASH_TIME_MS);
    }
}