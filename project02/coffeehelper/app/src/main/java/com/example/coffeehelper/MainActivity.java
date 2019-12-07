package com.example.coffeehelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView mTvTime;
    private Button mButtonStart;
    private Button mButtonStop;


    //for calculator
    private EditText cofText;
    private Button calc;
    private TextView ansCof;
    private TextView ansWa;
    private Switch cups;

    //for timer
    private Context mContext;
    private Chronometer mChronometer;
    private Thread mThreadChrono;
    private boolean classRunChecker = false;
    private long timerChecker = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        savedInstanceState.get()

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







        mTvTime = findViewById(R.id.tv_time);
        mButtonStart = findViewById(R.id.btnStart);
        mButtonStop = findViewById(R.id.btnStop);

        mContext = this;
        mChronometer = new Chronometer(mContext);
        mThreadChrono = new Thread(mChronometer);
        mThreadChrono.start();
        mChronometer.setmStartTime(timerChecker);
        mChronometer.setmIsRunning(classRunChecker);





        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

//                mThreadChrono.interrupt();
//                mThreadChrono = null;
//                mChronometer = null;

//                mChronometer = new Chronometer(mContext);
//                mThreadChrono = new Thread(mChronometer);

                if(!mChronometer.ismIsRunning()){
                    mChronometer = new Chronometer(mContext);
                    mThreadChrono = new Thread(mChronometer);
                    mThreadChrono.start();
                    mChronometer.start();
                }
            }
        });

        mButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mChronometer.ismIsRunning()){
                    mChronometer.stop();
                    mThreadChrono.interrupt();
                    mThreadChrono = null;
                    mChronometer = null;
                    mChronometer = new Chronometer(mContext);

                }
            }
        });
    }

    public void updateTimerText(final String time){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTvTime.setText(time);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("coffee", cofText.getText().toString());
        outState.putString("cofAns", ansCof.getText().toString());
        outState.putString("watAns", ansWa.getText().toString());

//        timer
        outState.putLong("time",  mChronometer.getmStartTime());
        outState.putBoolean("running", mChronometer.ismIsRunning());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        cofText.setText(savedInstanceState.getString("coffee"));
        ansCof.setText(savedInstanceState.getString("cofAns"));
        ansWa.setText(savedInstanceState.getString("watAns"));

        timerChecker = savedInstanceState.getLong("time");
        classRunChecker = savedInstanceState.getBoolean("running");
//        mChronometer.setmStartTime(savedInstanceState.getLong("time"));
//        mChronometer.setmIsRunning(savedInstanceState.getBoolean("running"));
    }
}
