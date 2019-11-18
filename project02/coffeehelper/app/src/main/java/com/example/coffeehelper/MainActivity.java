package com.example.coffeehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
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
    private Chronometer mChromometer;
    private Thread mThreadChrono;

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

//        cups.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked == true)
//            }
//        });


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

        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(mChromometer == null){
                    mChromometer = new Chronometer(mContext);
                    mThreadChrono = new Thread(mChromometer);
                    mThreadChrono.start();
                    mChromometer.start();
                }
            }
        });

        mButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mChromometer != null){
                    mChromometer.stop();
                    mThreadChrono.interrupt();
                    mThreadChrono = null;
                    mChromometer = null;

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
}
