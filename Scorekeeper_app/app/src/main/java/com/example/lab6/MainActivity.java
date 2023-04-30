package com.example.lab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mScore1, mScore2;
    TextView mScoreText1, mScoreText2;
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = (TextView)findViewById(R.id.score_1);
        mScoreText2 = (TextView)findViewById(R.id.score_2);
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            //Set the score text views
            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;

    }

    public void decreaseScore(View view) {
        int viewId = view.getId();
        switch (viewId){
            case R.id.decreaseTeam1:
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam2:
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }

    public void increaseScore(View view) {
        int viewId = view.getId();
        switch(viewId){
            case R.id.increaseTeam1:
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }
}