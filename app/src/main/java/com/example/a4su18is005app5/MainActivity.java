package com.example.a4su18is005app5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnStart, btnStop,btnResume; //created obj for button class
    TextView txtCounter;  //created obj for txtview

    int i=1;
    Handler customHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCounter = findViewById(R.id.textCounter);
        btnStart = findViewById(R.id.buttonStart);
        btnStop = findViewById(R.id.buttonStop);
        btnResume=findViewById(R.id.buttonResume);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //write logic

                customHandler.postDelayed(updateTimerThread,0);
            }
        }); // start the time

        btnResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customHandler.removeCallbacks(updateTimerThread);

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0;
                customHandler.removeCallbacks(updateTimerThread);
            }
        }); // end the time

    }
    private  Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            txtCounter.setText("" + i);
            customHandler.postDelayed(this,1000);
            i++;
        }
    };
}