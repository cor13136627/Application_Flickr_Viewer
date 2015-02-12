package com.example.joe.application_flickr_viewer;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
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

        btnOne = (Button)findViewById(R.id.btnOne);

            btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Developer Information",Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, activity_search.class);
                startActivity(i);
            }
        });

        btnTwo = (Button)findViewById(R.id.btnTwo);

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Search Locations",Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, Top_Locations.class);
                startActivity(i);
            }
        });

        btnThree = (Button)findViewById(R.id.btnThree);

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Top Photos",Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, Top_Photographs.class);
                startActivity(i);
            }
        });

    }




}
