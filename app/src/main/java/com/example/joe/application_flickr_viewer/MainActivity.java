package com.example.joe.application_flickr_viewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = (Button)findViewById(R.id.btnThree);

            btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Developer Information",Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, DevInfo.class);
                startActivity(i);
            }
        });

        btnTwo = (Button)findViewById(R.id.btnOne);

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Search Locations",Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, TopLocations.class);
                startActivity(i);
            }
        });

    }




}
