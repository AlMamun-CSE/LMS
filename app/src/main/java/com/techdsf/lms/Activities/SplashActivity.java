package com.techdsf.lms.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.techdsf.lms.R;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivity";

    //Firebase Var.........................
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.d(TAG, "onCreate: started.");

        //initialize firebase All variable
        firebaseAuth=FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //This method will be executed once the timer is over
                FirebaseUser currentUser=firebaseAuth.getCurrentUser();
                if (currentUser==null){
                    Intent i = new Intent(SplashActivity.this, RegisterActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, 7000);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: started.");
        FirebaseUser currentUser=firebaseAuth.getCurrentUser();
        if (currentUser!=null){
            Intent mainIntent=new Intent(SplashActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }
    }
}