package com.jinal.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class Splash_Activity extends AppCompatActivity {
        LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lottieAnimationView = findViewById(R.id.splash);
        lottieAnimationView.setImageAssetsFolder("assets");
        lottieAnimationView.setAnimation("Attendence.json");
        lottieAnimationView.playAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity(new Intent(Splash_Activity.this,Login_Activity.class));
               finish();
            }
        },5000);
    }
}