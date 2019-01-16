package com.example.nvdq1.uianimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Animation animFlash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = (ImageView)findViewById(R.id.imageView);
        Button btnStartAnimation = (Button)findViewById(R.id.btnStartAnimation);
        Button btnStopAnimation = (Button)findViewById(R.id.btnStopAnimation);

        animFlash = AnimationUtils.loadAnimation(this, R.anim.flash);
        animFlash.setDuration(500);

        btnStartAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.startAnimation(animFlash);
            }
        });

        btnStopAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.clearAnimation();
            }
        });
    }
}
