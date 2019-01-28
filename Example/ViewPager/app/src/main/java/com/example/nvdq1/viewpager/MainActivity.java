package com.example.nvdq1.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int[] images;
    ViewPager viewPager;
    ImagePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reference the images and put them in our array
        images = new int[] { R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.g};

        // get a reference to the ViewPager in the layout
        viewPager = (ViewPager) findViewById(R.id.ViewPager);

        // Initialize our PagerAdapter
        adapter = new ImagePagerAdapter(MainActivity.this, images);

        // Bind the PagerAdapter to the ViewPager
        viewPager.setAdapter(adapter);
    }
}
