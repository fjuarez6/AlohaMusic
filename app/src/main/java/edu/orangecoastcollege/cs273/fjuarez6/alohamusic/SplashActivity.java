package edu.orangecoastcollege.cs273.fjuarez6.alohamusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Define the TimerTask to launch media activity
        TimerTask mediaTask = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashActivity.this, MediaActivity.class));
            }
        };

        Timer timer = new Timer();
        timer.schedule(mediaTask, 5000);
    }
}
