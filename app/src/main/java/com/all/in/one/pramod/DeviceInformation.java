package com.all.in.one.pramod;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DeviceInformation extends AppCompatActivity {
    String information ;
    Build build;
    Build.VERSION  version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_information);

        TextView textView = findViewById(R.id.deviceid);

        deviceInformation();
        textView.setText(information);


    }

    public void deviceInformation(){

        information = "Device id = "+ Build.DEVICE +"\n" + "Device Model = " + Build.MODEL +"\n";











    }
}
