package com.uacs.android.loggingandbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Info Log: Inside onCreate method");

        Log.e(TAG, "Error Log: Inside onCreate method");

        tv = (TextView) findViewById(R.id.tv_start);

        tv.setText("My first android program");

        Log.i(TAG, tv.getText().toString());

    }
}
