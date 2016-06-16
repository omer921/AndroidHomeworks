package com.example.omer.hw3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrontPageFragment.currentFrag = 0;
      //  Button button = (Button) findViewById(R.id.aboutMeButton);

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
            case R.id.action_choice1:
                intent = new Intent(this, FrontPageActivity.class);
                startActivity(intent);
                return true;
            /*case R.id.action_choice2:
                intent = new Intent(this, Task2_Activity.class);
                startActivity(intent);
                return true;
            case R.id.action_choice3:
                intent = new Intent(this, Task3_Activity.class);
                startActivity(intent);
                return true;
            case R.id.action_choice4:
                intent = new Intent(this, Task4_Activity.class);
                startActivity(intent);
                return true;*/
        }
        return super.onOptionsItemSelected(item);
    }
}
