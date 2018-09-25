package com.example.vivekreddy.nwapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadImageTask extends AsyncTask <String, Void,Bitmap>{


    @Override
    protected Bitmap doInBackground(String... strings) {

        String s1=strings[0];
        InputStream in;
        try{
            URL myUrl = new URL(s1);
            HttpURLConnection myCon =(HttpURLConnection) myUrl.openConnection();
            myCon.setConnectTimeout(20000);
            myCon.setReadTimeout(10000);
            myCon.setRequestMethod("GET");
            myCon.connect();
            in = myCon.getInputStream();
            Bitmap mymap = BitmapFactory.decodeStream(in);
            return mymap;


        }
        catch (Exception e){

            e.printStackTrace();

        }
        return null;

    }
}
