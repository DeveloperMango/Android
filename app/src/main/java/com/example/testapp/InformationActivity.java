package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        TextView textView = findViewById(R.id.version);
        StringBuffer buf = new StringBuffer();
        java.lang.Process p;

        try {
            p = Runtime.getRuntime().exec("getprop");
            p.waitFor();
            BufferedReader rd = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while((line = rd.readLine()) != null){
                if(line.contains("ro.product.version")) {
                    buf.append(line + "\n"); break;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        String info = "";
        info = buf.toString().replace("ro.product.version", "Version: ");
        info = info.replace("[", "");
        info = info.replace("]","");

        WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo =  wifiManager.getConnectionInfo();
        String mac = wifiInfo.getMacAddress();

        info += "MAC: "+mac+"\n";

        textView.setText(info);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25F);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}