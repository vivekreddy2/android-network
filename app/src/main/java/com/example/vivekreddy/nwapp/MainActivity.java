package com.example.vivekreddy.nwapp;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConnectInternetTask c1;
    DownloadImageTask downloadimg;
    static TextView myText;
    static ImageView myImage;
    ConnectivityManager myConManager;
    NetworkInfo myInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = (TextView) findViewById(R.id.myResult);
        myImage = (ImageView) findViewById(R.id.imgres);
        myConManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        myInfo=myConManager.getActiveNetworkInfo();

    }


    public void doSomething(View view){
        c1 = new ConnectInternetTask(this);
        c1.execute("http://www.google.com");


    }

    public void doSomething1(View view) {
        if(myInfo !=null && myInfo.isConnected()){
            downloadimg = new DownloadImageTask();
            downloadimg.execute("https://www.amrita.edu/sites/default/");
        }
    }
}
