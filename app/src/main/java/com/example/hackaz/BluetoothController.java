package com.example.hackaz;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

import static android.bluetooth.BluetoothAdapter.ACTION_REQUEST_ENABLE;
import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class BluetoothController {

    //---> ATTRIBUTES <---//



    //---> GETTERS/SETTERS <---//



    //---> OTHER FUNCTIONS <---//


    // Setting up Bluetooth in a given device to use
    public void setUpBluetooth() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
            System.out.println("Failure to connect. Bluetooth not supported on device.");
        }

        //if (!bluetoothAdapter.isEnabled()) {
        //    Intent enableBtIntent = new Intent(ACTION_REQUEST_ENABLE);
        //    startActivityForResult(enableBtIntent, ACTION_REQUEST_ENABLE);
        //}

        if (!bluetoothAdapter.isEnabled()){
            bluetoothAdapter.enable();
        }

    }

    //Searching


    //Pairing


    //Message sending


    //Message receiving


    //Distance Processing

}
