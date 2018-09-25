package com.example.vivekreddy.nwapp;

import android.content.Context;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectInternetTask extends AsyncTask<String, Void, String> {
    Context ctx;

    public ConnectInternetTask(Context ct){ctx=ct;}
    @Override
    protected String doInBackground(String... strings) {

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
            BufferedReader myBuf = new BufferedReader(new InputStreamReader(in));
            StringBuilder st= new StringBuilder();
            String line = "";
            while((line=myBuf.readLine())!=null){
                st.append(line+"\n");


            }
            myBuf.close();
            in.close();
            return st.toString();


        }
        catch (Exception e){

            e.printStackTrace();
        }


        return null;
    }

    protected void onPostExecute(String s){MainActivity.myText.setText(s);}
}
