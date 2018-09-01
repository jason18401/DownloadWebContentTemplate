package com.example.hyu13.downloadwebcontent;
//Program downloads html contents from a website and implements Async

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask asyncTask = new DownloadTask();
        String result = null;

        try {
            //You can add multiple sites to download from ex. asyncTask.execute("https://www.ecowebhosting.co.uk/", "www.stack.com", "anotherwebsite.com")
            result = asyncTask.execute("https://www.ecowebhosting.co.uk/").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Log.i("Contents of URL", result);
    }


}
