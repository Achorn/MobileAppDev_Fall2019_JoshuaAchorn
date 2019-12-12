package com.example.coffeehelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button mButtonStart;
    private Button mButtonStop;


    //for calculator
    private EditText cofText;
    private Button calc;
    private TextView ansCof;
    private TextView ansWa;
    private Switch cups;

    //for timer
    private Chronometer chronometer;
    private boolean isRunning;
    private long savedTime;

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ratio calc
        cofText = findViewById(R.id.etCoffee);
        calc = findViewById(R.id.btnCalculate);
        ansCof = findViewById(R.id.tvCoffee);
        ansWa = findViewById(R.id.tvWater);
        cups = findViewById(R.id.cupsSwitch);



        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int coffeeVal = Integer.parseInt(cofText.getText().toString());
                int waterVal = coffeeVal*16;

                if(cups.isChecked()){
                    ansCof.setText(coffeeVal*2 +"g");
                    ansWa.setText(waterVal*2 + "g");
                }
                else {
                    ansCof.setText(coffeeVal + "g");
                    ansWa.setText(waterVal + "g");
                }
            }
        });





//      chronometer was made by using the android chronometer widget found here:
//       https://developer.android.com/reference/android/widget/Chronometer

        mButtonStart = findViewById(R.id.btnStart);
        mButtonStop = findViewById(R.id.btnStop);
        chronometer = findViewById(R.id.chronometer);


        if(isRunning){ //check if saved instance has a running chronometer
            chronometer.setBase(savedTime);
            chronometer.start();
        }


        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(!isRunning){
                    chronometer.setFormat("%s");
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    savedTime = chronometer.getBase();
                    chronometer.start();

                    isRunning = true;
                }
            }
        });

        mButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isRunning) {
                    chronometer.stop();
                    isRunning = false;
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("coffee", cofText.getText().toString());
        outState.putString("cofAns", ansCof.getText().toString());
        outState.putString("watAns", ansWa.getText().toString());



        outState.putLong("time", savedTime);
        outState.putBoolean("running", isRunning);


    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        cofText.setText(savedInstanceState.getString("coffee"));
        ansCof.setText(savedInstanceState.getString("cofAns"));
        ansWa.setText(savedInstanceState.getString("watAns"));
//
        isRunning = savedInstanceState.getBoolean("running");
        savedTime = savedInstanceState.getLong("time");
    }
}
