package com.example.nvdq1.viewpager2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new SampleFragment1());
        fragmentList.add(new SampleFragment2());

        SimpleFragmentPagerAdapter pagerAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);

        ViewPager viewPager = (ViewPager)findViewById(R.id.ViewPager);
        viewPager.setAdapter(pagerAdapter);
    }

    public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
        // A List to hold our fragments
        private List<Fragment> fragments;

        // A constructor to receive a fragment manager and a List
        public SimpleFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            // Call the super class' version
            // of this constructor
            super(fm);
            this.fragments = fragments;
        }

        // Just two methods to override
        // to get the current position of
        // the adapter and the size of the List
        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }
}
