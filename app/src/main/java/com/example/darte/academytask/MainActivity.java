package com.example.darte.academytask;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String REPORTS_URL = "https://devfest-spb.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAllReports(REPORTS_URL);
            }
        });
    }

    public void showAllReports(String url){
        String urlWithReports = url;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(urlWithReports));
        startActivity(i);
    }
}
