package com.example.hyu13.downloadwebcontent;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Void, String>{//1st string url, 2nd method we may or may not use to show progress(not implemented here so Void), 3rd return Type

    @Override
    protected String doInBackground(String... urls) {

        String result ="";
        URL url;
        HttpURLConnection urlConnection = null;

        try{
            url = new URL(urls[0]); //urls[0] bc we are only interested in the first element
            urlConnection = (HttpURLConnection)url.openConnection();
            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();   //tracks html content we are currently on

            while(data != -1){ //the end of the data has a value of -1
                char current = (char)data; //cast data to char bc data is an int
                result += current; // reading chars from input stream reader and adding to result, it is going to contain all of the chars of the html of that site
                data = reader.read();
            }
            return result;  //returned back to task in main

        }catch (Exception e){
            e.printStackTrace();
            return "Failed";
        }
    }
}
