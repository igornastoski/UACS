package com.uacs.android.uithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button buttonStart, buttonStop;

    private Boolean mstopLoop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Thread id: " + Thread.currentThread().getId());
        buttonStart = (Button)findViewById(R.id.startButton);
        buttonStop = (Button)findViewById(R.id.endButton);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.startButton:
                mstopLoop=true;
//                while (mstopLoop){
//                    Log.i(TAG, "Thread id in while loop: " + Thread.currentThread().getId());
//                }

                new Thread (new Runnable(){
                    @Override
                    public void run(){
                        while (mstopLoop){
                            Log.i(TAG, "Thread id in while loop: " + Thread.currentThread().getId());
                }
                    }
                }).start();
                break;
            case R.id.endButton:
                mstopLoop = false;
                break;
        }
    }
}
