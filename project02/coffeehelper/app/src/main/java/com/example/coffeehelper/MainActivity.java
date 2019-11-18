package com.example.coffeehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView mTvTime;
    private Button mButtonStart;
    private Button mButtonStop;
//    private Button mButtonReset;


    private Context mContext;
    private Chronometer mChromometer;
    private Thread mThreadChrono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        mTvTime = findViewById(R.id.tv_time);
        mButtonStart = findViewById(R.id.btnStart);
        mButtonStop = findViewById(R.id.btnStop);
//        mButtonReset = findViewById(R.id.btnReset);

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
