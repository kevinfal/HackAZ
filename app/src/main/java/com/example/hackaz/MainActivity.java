package com.example.hackaz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//commit test

    //---> ATTRIBUTES <---//
    private BluetoothController myc1 = new BluetoothController(); // myc stands for my controller
    private Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView testBox = findViewById(R.id.testDistance);

        if(!myc1.setUpBluetooth()){
            testBox.setText("BLUETOOTH NOT FOUND");
        }
        else {
            testBox.setText("BLUETOOTH FOUND");
        }

        btnTest = findViewById(R.id.testButton);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myc1.beginSearch(MainActivity.super.getApplicationContext());
            }
        });

    }


}
