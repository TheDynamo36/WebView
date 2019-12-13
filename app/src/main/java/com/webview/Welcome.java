package com.webview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

public class Welcome extends AppCompatActivity {
Button google;
Button epic;
Button duck;
Button goButton;
EditText url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        google = findViewById(R.id.google);
        epic = findViewById(R.id.epic);
        duck = findViewById(R.id.duck);
        goButton = findViewById(R.id.goButton);
        url = findViewById(R.id.URL);

        final Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent.putExtra("SearchEngine","https://www.google.com");
                startActivity(intent);
            }
        });

        epic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent.putExtra("SearchEngine","https://www.epicsearch.in");
                startActivity(intent);
            }
        });

        duck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent.putExtra("SearchEngine","https://www.duckduckgo.com");
                startActivity(intent);
            }
        });

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URL = url.getText().toString();
                if(!URL.isEmpty()) {
                    if(!URL.contains("https://")) {
                        if(URL.contains("www."))
                            startNew(intent, "https://"+URL);
                        else
                            startNew(intent,"https://www."+URL);
                    }
                    else
                        startNew(intent, URL);
                }
                Toast.makeText(getApplicationContext(),"Please enter a website",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startNew(Intent intent, String URL) {
        intent.putExtra("SearchEngine", URL);
        startActivity(intent);
    }

}
