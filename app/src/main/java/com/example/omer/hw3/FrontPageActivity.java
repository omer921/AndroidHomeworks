package com.example.omer.hw3;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FrontPageActivity extends AppCompatActivity implements FrontPageFragment.OnFragmentInteractionListener{
    Fragment mContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, FrontPageFragment.newInstance()).commit();

        if (savedInstanceState != null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container,FrontPageFragment.newInstance()).commit();
        }
        /*else {
            mContent = FrontPageFragment.newInstance(0);
        }*/


    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = new Intent(this, MainActivity.class);
        switch (id) {

            case R.id.action_choice0:
                //setContentView(R.layout.activity_main);
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        FrontPageFragment.currentFrag = 0;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(int num){
        //int id =
        Intent intent = new Intent(this, MainActivity.class);
        Log.e("Fragment", "Button Clicked in activity");
        if (num == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, FrontPageFragment.newInstance()).commit();
        }
        else if (num == 1) {
            intent = new Intent(this, Task1_Activity.class);
            startActivity(intent);
        }
        else if (num == 2 ) {
            intent = new Intent(this, Task2_Activity.class);
            startActivity(intent);
        }
    }



}
