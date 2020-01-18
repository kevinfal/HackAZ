package com.example.hackaz;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import static android.bluetooth.BluetoothAdapter.ACTION_REQUEST_ENABLE;
import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class BluetoothController {

    //---> ATTRIBUTES <---//
    private BluetoothAdapter bluetoothAdapter;


    //---> CONSTRUCTORS <---//
    protected BluetoothController(){
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    //---> GETTERS/SETTERS <---//



    //---> OTHER FUNCTIONS <---//


    // Setting up Bluetooth in a given device to use
    protected boolean setUpBluetooth() {

        if (bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
            System.out.println("Failure to connect. Bluetooth not supported on device.");
            return false;

        }

        //if (!bluetoothAdapter.isEnabled()) {
        //    Intent enableBtIntent = new Intent(ACTION_REQUEST_ENABLE);
        //    startActivityForResult(enableBtIntent, ACTION_REQUEST_ENABLE);
        //}

        if (!bluetoothAdapter.isEnabled()){
            bluetoothAdapter.enable();
        }

        return true;
    }

    //Searching


    //Pairing


    //Message sending
    public boolean sendMessage(){
        return true;
    }

    //Message receiving
    public boolean receiveMessage(){
        return true;
    }

    //Distance Processing
    private final BroadcastReceiver receiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action)) {
                int  rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI,Short.MIN_VALUE);
                Toast.makeText(context.getApplicationContext(),"  RSSI: " + rssi + "dBm", Toast.LENGTH_SHORT).show();
            }
        }
    };

    //Other
    protected void beginSearch(){
        bluetoothAdapter.startDiscovery();
    }

}
