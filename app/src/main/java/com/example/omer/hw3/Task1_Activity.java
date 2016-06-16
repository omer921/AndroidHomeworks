package com.example.omer.hw3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.HashMap;

public class Task1_Activity extends AppCompatActivity implements MovieFragment.OnFragmentInteractionListener {

    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1_);

        //getSupportFragmentManager().beginTransaction().replace(R.id.container2, MovieFragment.newInstance(0)).commit();

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        vpPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                final float normalized_position = Math.abs(Math.abs(position-1));
                page.setScaleY(normalized_position/ 1 +.02f);
            }
        });

        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
               // Log.e("Postion Offset", positionOffset+"");
                Log.e("Position", position+"");

                /*if (positionOffset > 0) {
                    position++;
                }
                else {
                    position--;
                }
                */
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public void onFragmentInteraction() {};


    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 30;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return MovieFragment.newInstance(0);
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return MovieFragment.newInstance(1);
                case 2: // Fragment # 1 - This will show SecondFragment
                    return MovieFragment.newInstance(2);
                case 3: // Fragment # 1 - This will show SecondFragment
                    return MovieFragment.newInstance(3);
                case 4: // Fragment # 1 - This will show SecondFragment
                    return MovieFragment.newInstance(4);
                case 5: // Fragment # 1 - This will show SecondFragment
                    return MovieFragment.newInstance(5);
                case 6: // Fragment # 1 - This will show SecondFragment
                    return MovieFragment.newInstance(6);
                case 7: // Fragment # 1 - This will show SecondFragment
                    return MovieFragment.newInstance(7);
                case 8: // Fragment # 1 - This will show SecondFragment
                    return MovieFragment.newInstance(8);
                case 9: // Fragment # 1 - This will show SecondFragment
                    return MovieFragment.newInstance(9);
                case 10: // Fragment # 1 - This will show SecondFragment
                    return MovieFragment.newInstance(10);
                default:
                    return MovieFragment.newInstance(position);
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            MovieData movieData = new MovieData();
            HashMap movie = movieData.getItem(position);
            return "" + movie.get("name");
        }

    }
}
