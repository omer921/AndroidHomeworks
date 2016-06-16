package com.example.omer.hw3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Task2_Activity extends AppCompatActivity implements Task3Fragment.OnFragmentInteractionListener {
    boolean mTwoPane = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2_);


        getSupportFragmentManager().beginTransaction().replace(R.id.container3, Task3Fragment.newInstance(0)).commit();

        if (findViewById(R.id.container4) != null) {
            mTwoPane = true;
        }
    }

    @Override
    public void onBackPressed() {
        if (!mTwoPane) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container3, Task3Fragment.newInstance(0)).commit();
        }
    }

    public void onFragmentInteraction(int num) {
        if (mTwoPane && (num == 1)){
            getSupportFragmentManager().beginTransaction().replace(R.id.container4, Task3Fragment.newInstance(1)).commit();
        }
        else if (mTwoPane && (num == 2)) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container4, Task3Fragment.newInstance(2)).commit();
        }
        else if (mTwoPane && (num == 3)) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container4, Task3Fragment.newInstance(3)).commit();
        }
        else if (mTwoPane && (num == 4)) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container4, Task3Fragment.newInstance(4)).commit();
        }
        else if (mTwoPane && (num == 5)) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container4, Task3Fragment.newInstance(5)).commit();
        }
        else {
            getSupportFragmentManager().beginTransaction().replace(R.id.container3, Task3Fragment.newInstance(num)).commit();
        }

    }
}
